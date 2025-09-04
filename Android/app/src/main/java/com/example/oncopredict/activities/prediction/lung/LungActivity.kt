package com.example.oncopredict.activities.prediction.lung

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.oncopredict.R
import com.example.oncopredict.data.viewmodel.LungViewModel
import com.example.oncopredict.fragments.PersonalDataFragment

class LungActivity : AppCompatActivity() {

    val lungViewModel: LungViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_lung)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, PersonalDataFragment())
            .commit()
    }
}