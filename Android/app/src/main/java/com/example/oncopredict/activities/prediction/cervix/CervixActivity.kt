package com.example.oncopredict.activities.prediction.cervix

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.oncopredict.R
import com.example.oncopredict.data.viewmodel.CervixViewModel
import com.example.oncopredict.fragments.cervix.PersonalDataFragment

class CervixActivity : AppCompatActivity() {
    val cervixViewModel: CervixViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cervix)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, PersonalDataFragment())
            .commit()
    }
}