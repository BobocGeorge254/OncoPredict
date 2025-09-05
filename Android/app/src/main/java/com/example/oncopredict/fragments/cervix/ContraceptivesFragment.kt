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

class ContraceptivesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cervix_contraceptives, container, false)

        val cbHormonal = view.findViewById<CheckBox>(R.id.cbHormonal)
        val etHormonalYears = view.findViewById<EditText>(R.id.etHormonalYears)
        val cbIUD = view.findViewById<CheckBox>(R.id.cbIUD)
        val etIUDYears = view.findViewById<EditText>(R.id.etIUDYears)
        val btnNext = view.findViewById<Button>(R.id.btnNext)

        val activity = requireActivity() as CervixActivity

        btnNext.setOnClickListener {
            activity.cervixViewModel.hormonalContraceptives = if (cbHormonal.isChecked) 1 else 0
            activity.cervixViewModel.hormonalContraceptivesYears = etHormonalYears.text.toString().toIntOrNull() ?: 0
            activity.cervixViewModel.iud = if (cbIUD.isChecked) 1 else 0
            activity.cervixViewModel.iudYears = etIUDYears.text.toString().toIntOrNull() ?: 0

            // Move to next fragment (STDs)
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, STDsFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
