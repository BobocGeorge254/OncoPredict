package com.example.oncopredict.activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.oncopredict.R
import com.example.oncopredict.activities.prediction.FutureActivity
import com.example.oncopredict.activities.prediction.cervix.CervixActivity
import com.example.oncopredict.activities.prediction.lung.LungActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val itemLiver: LinearLayout = findViewById(R.id.liver)
        val itemLungs: LinearLayout = findViewById(R.id.lung)
        val itemCervix: LinearLayout = findViewById(R.id.cervix)
        val itemStomach: LinearLayout = findViewById(R.id.stomach)
        val itemBlood: LinearLayout = findViewById(R.id.blood)
        val itemOverall: LinearLayout = findViewById(R.id.overall)

        itemLungs.setOnClickListener {
            startActivity(Intent(this, LungActivity::class.java))
        }

        itemCervix.setOnClickListener {
            startActivity(Intent(this, CervixActivity::class.java))
        }

        val futureIntent = Intent(this, FutureActivity::class.java)

        itemLiver.setOnClickListener { startActivity(futureIntent) }
        itemStomach.setOnClickListener { startActivity(futureIntent) }
        itemBlood.setOnClickListener { startActivity(futureIntent) }
        itemOverall.setOnClickListener { startActivity(futureIntent) }
    }
}
