package com.example.oncopredict.fragments.cervix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.oncopredict.R
import com.example.oncopredict.activities.prediction.cervix.CervixActivity

class SmokingFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cervix_smoking, container, false)

        val cbSmokes = view.findViewById<CheckBox>(R.id.cbSmokes)
        val etSmokesYears = view.findViewById<EditText>(R.id.etSmokesYears)
        val etPacksYear = view.findViewById<EditText>(R.id.etPacksYear)
        val btnNext = view.findViewById<Button>(R.id.btnNext)

        val activity = requireActivity() as CervixActivity

        btnNext.setOnClickListener {
            activity.cervixViewModel.smokes = if (cbSmokes.isChecked) 1 else 0
            activity.cervixViewModel.smokesYears = etSmokesYears.text.toString().toIntOrNull() ?: 0
            activity.cervixViewModel.smokesPacksYear = etPacksYear.text.toString().toIntOrNull() ?: 0

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ContraceptivesFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
