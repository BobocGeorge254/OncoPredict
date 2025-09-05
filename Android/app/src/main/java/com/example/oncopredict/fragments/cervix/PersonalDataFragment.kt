package com.example.oncopredict.fragments.cervix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.oncopredict.R
import com.example.oncopredict.activities.prediction.cervix.CervixActivity
import com.example.oncopredict.utils.PreferenceHelper

class PersonalDataFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cervix_personal_data, container, false)

        val etAge = view.findViewById<EditText>(R.id.etAge)
        val etSexPartners = view.findViewById<EditText>(R.id.etSexPartners)
        val etFirstSex = view.findViewById<EditText>(R.id.etFirstSex)
        val etPregnancies = view.findViewById<EditText>(R.id.etPregnancies)
        val btnNext = view.findViewById<Button>(R.id.btnNext)

        val savedAge = PreferenceHelper.getAge(requireContext())
        if (savedAge != -1) etAge.setText(savedAge.toString())

        val activity = requireActivity() as CervixActivity

        btnNext.setOnClickListener {
            val age = etAge.text.toString().toInt()
            activity.cervixViewModel.age = age

            activity.cervixViewModel.numberOfSexualPartners = etSexPartners.text.toString().toInt()
            activity.cervixViewModel.firstSexualIntercourse = etFirstSex.text.toString().toInt()
            activity.cervixViewModel.numOfPregnancies = etPregnancies.text.toString().toInt()

            PreferenceHelper.saveAge(requireContext(), age)

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SmokingFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
