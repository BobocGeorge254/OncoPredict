package com.example.oncopredict.fragments.lung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.oncopredict.R
import com.example.oncopredict.data.auth.AuthSession
import com.example.oncopredict.data.prediction.PredictionResponse
import com.example.oncopredict.data.viewmodel.LungViewModel
import com.example.oncopredict.services.LungApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultsFragmentLung : Fragment() {

    private lateinit var lungViewModel: LungViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lung_results, container, false)

        lungViewModel = ViewModelProvider(requireActivity()).get(LungViewModel::class.java)

        val tvRisk = view.findViewById<TextView>(R.id.tvRiskLung)
        val tvProbabilityYes = view.findViewById<TextView>(R.id.tvProbabilityYesLung)
        val tvProbabilityNo = view.findViewById<TextView>(R.id.tvProbabilityNoLung)
        val btnTryAgain = view.findViewById<Button>(R.id.btnTryAgainLung)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(LungApi::class.java)

        // API request
        val request = lungViewModel.toRequest()
        val token = AuthSession.token
        api.predictLung(request, token).enqueue(object : Callback<PredictionResponse> {
            override fun onResponse(
                call: Call<PredictionResponse>,
                response: Response<PredictionResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        tvRisk.text = "Risk: ${it.lung_cancer_risk}"
                        tvProbabilityYes.text = "Probability YES: ${"%.2f".format(it.probability_yes * 100)}%"
                        tvProbabilityNo.text = "Probability NO: ${"%.2f".format(it.probability_no * 100)}%"
                    }
                } else {
                    tvRisk.text = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<PredictionResponse>, t: Throwable) {
                tvRisk.text = "Error: ${t.message}"
            }
        })

        btnTryAgain.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack(null, 1)
        }

        return view
    }
}
