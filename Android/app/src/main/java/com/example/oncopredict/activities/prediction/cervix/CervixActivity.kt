package com.example.oncopredict.activities.prediction.cervix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oncopredict.R

class CervixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cervix)
    }
}