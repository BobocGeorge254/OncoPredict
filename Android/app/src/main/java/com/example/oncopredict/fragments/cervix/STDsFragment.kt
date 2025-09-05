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
import com.example.oncopredict.fragments.lung.ResultsFragmentCervix

class STDsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cervix_stds, container, false)

        val cbSTDs = view.findViewById<CheckBox>(R.id.cbSTDs)
        val etSTDsNumber = view.findViewById<EditText>(R.id.etSTDsNumber)
        val cbHPV = view.findViewById<CheckBox>(R.id.cbHPV)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)

        val activity = requireActivity() as CervixActivity

        btnSubmit.setOnClickListener {
            activity.cervixViewModel.stds = if (cbSTDs.isChecked) 1 else 0
            activity.cervixViewModel.stdsNumber = etSTDsNumber.text.toString().toIntOrNull() ?: 0
            activity.cervixViewModel.stdsHPV = if (cbHPV.isChecked) 1 else 0

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ResultsFragmentCervix())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}


