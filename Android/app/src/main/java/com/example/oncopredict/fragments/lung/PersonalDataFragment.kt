package com.example.oncopredict.fragments.lung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.oncopredict.R
import com.example.oncopredict.activities.prediction.lung.LungActivity
import com.example.oncopredict.utils.PreferenceHelper

class PersonalDataFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lung_personal_data, container, false)

        val etAge = view.findViewById<EditText>(R.id.etAge)
        val cbSmoking = view.findViewById<CheckBox>(R.id.cbSmoking)
        val cbAlcohol = view.findViewById<CheckBox>(R.id.cbAlcohol)
        val cbChronicDisease = view.findViewById<CheckBox>(R.id.cbChronicDisease)
        val cbYellowFingers = view.findViewById<CheckBox>(R.id.cbYellowFingers)
        val btnNext = view.findViewById<Button>(R.id.btnNext)

        val savedAge = PreferenceHelper.getAge(requireContext())
        if (savedAge != -1) etAge.setText(savedAge.toString())

        val spinnerGender: Spinner = view.findViewById(R.id.spinnerGender)
        val genderOptions = listOf("Select Gender", "Male", "Female")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter

        val activity = requireActivity() as LungActivity

        btnNext.setOnClickListener {
            val age = etAge.text.toString().toInt()
            activity.lungViewModel.age = age
            activity.lungViewModel.gender = spinnerGender.selectedItemPosition
            activity.lungViewModel.smoking = if (!cbSmoking.isChecked) 1 else 2
            activity.lungViewModel.alcoholConsuming = if (!cbAlcohol.isChecked) 1 else 2
            activity.lungViewModel.chronicDisease = if (!cbChronicDisease.isChecked) 1 else 2
            activity.lungViewModel.yellowFingers = if (!cbYellowFingers.isChecked) 1 else 2

            PreferenceHelper.saveAge(requireContext(), age)

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SymptomsFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
