package com.example.oncopredict.activities.prediction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oncopredict.R

class FutureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_future)
    }
}