package com.example.oncopredict.fragments.lung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.oncopredict.R
import com.example.oncopredict.activities.prediction.lung.LungActivity

class SymptomsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lung_symptoms, container, false)

        val cbCough = view.findViewById<CheckBox>(R.id.cbCough)
        val cbChestPain = view.findViewById<CheckBox>(R.id.cbChestPain)
        val cbShortBreath = view.findViewById<CheckBox>(R.id.cbShortBreath)
        val cbSwallowDifficulty = view.findViewById<CheckBox>(R.id.cbSwallowDifficulty)
        val cbFatigue = view.findViewById<CheckBox>(R.id.cbFatigue)
        val cbWheezing = view.findViewById<CheckBox>(R.id.cbWheezing)
        val btnNext = view.findViewById<Button>(R.id.btnNextSymptoms)

        val activity = requireActivity() as LungActivity

        btnNext.setOnClickListener {
            activity.lungViewModel.coughing = if (!cbCough.isChecked) 1 else 2
            activity.lungViewModel.chestPain = if (!cbChestPain.isChecked) 1 else 2
            activity.lungViewModel.shortnessOfBreath = if (!cbShortBreath.isChecked) 1 else 2
            activity.lungViewModel.swallowingDifficulty = if (!cbSwallowDifficulty.isChecked) 1 else 2
            activity.lungViewModel.fatigue = if (!cbFatigue.isChecked) 1 else 2
            activity.lungViewModel.wheezing = if (!cbWheezing.isChecked) 1 else 2

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ResultsFragmentLung())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
