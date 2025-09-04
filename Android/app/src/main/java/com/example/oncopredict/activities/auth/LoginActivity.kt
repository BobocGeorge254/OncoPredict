package com.example.oncopredict.activities.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.oncopredict.R
import com.example.oncopredict.activities.MainActivity
import com.example.oncopredict.data.auth.AuthRequest
import com.example.oncopredict.data.auth.AuthResponse
import com.example.oncopredict.data.auth.AuthSession
import com.example.oncopredict.services.AuthApi
import com.example.oncopredict.services.LungApi
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)
        tvError = findViewById(R.id.tvError)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val authApi = retrofit.create(AuthApi::class.java)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                tvError.text = "Please fill all fields"
                return@setOnClickListener
            }

            progressBar.visibility = View.VISIBLE
            tvError.text = ""

            val request = AuthRequest(username, password)
            authApi.login(request).enqueue(object : Callback<AuthResponse> {
                override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        val authResponse = response.body()
                        if (authResponse != null) {
                            val token = "${authResponse.tokenType} ${authResponse.accessToken}"
                            AuthSession.token = token

                            Toast.makeText(this@LoginActivity, "Welcome, $username!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        tvError.text = "Invalid credentials"
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    tvError.text = "Network error: ${t.localizedMessage}"
                }
            })
        }
    }
}
