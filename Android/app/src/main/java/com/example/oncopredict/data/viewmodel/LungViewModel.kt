package com.example.oncopredict.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.oncopredict.data.prediction.LungPatientData

class LungViewModel : ViewModel() {
    var gender: Int = 1
    var age: Int = 1
    var smoking: Int = 1
    var yellowFingers: Int = 1
    var chronicDisease: Int = 1
    var fatigue: Int = 1
    var wheezing: Int = 1
    var alcoholConsuming: Int = 1
    var coughing: Int = 1
    var shortnessOfBreath: Int = 1
    var swallowingDifficulty: Int = 1
    var chestPain: Int = 1

    fun toRequest(): LungPatientData {
        return LungPatientData(
            gender,
            age,
            smoking,
            yellowFingers,
            chronicDisease,
            fatigue,
            wheezing,
            alcoholConsuming,
            coughing,
            shortnessOfBreath,
            swallowingDifficulty,
            chestPain
        )
    }
}
