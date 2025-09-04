package com.example.oncopredict.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.oncopredict.R
import com.example.oncopredict.activities.prediction.lung.LungActivity

class PersonalDataFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_personal_data, container, false)

        val etAge = view.findViewById<EditText>(R.id.etAge)
        val btnNext = view.findViewById<Button>(R.id.btnNext)

        val spinnerGender: Spinner = view.findViewById(R.id.spinnerGender)
        val genderOptions = listOf("Select Gender", "Male", "Female")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter

        val activity = requireActivity() as LungActivity

        btnNext.setOnClickListener {
            activity.lungViewModel.age = etAge.text.toString().toInt()
            activity.lungViewModel.gender = spinnerGender.selectedItemPosition //to fix
        }

        return view
    }
}
