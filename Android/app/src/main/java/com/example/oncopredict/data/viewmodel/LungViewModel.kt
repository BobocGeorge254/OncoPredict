package com.example.oncopredict.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.oncopredict.data.prediction.LungPatientData

class LungViewModel : ViewModel() {
    var gender: Int = 0
    var age: Int = 0
    var smoking: Int = 0
    var yellowFingers: Int = 0
    var chronicDisease: Int = 0
    var fatigue: Int = 0
    var wheezing: Int = 0
    var alcoholConsuming: Int = 0
    var coughing: Int = 0
    var shortnessOfBreath: Int = 0
    var swallowingDifficulty: Int = 0
    var chestPain: Int = 0

    fun toRequest(): LungPatientData {
        return LungPatientData(
            GENDER = gender,
            AGE = age,
            SMOKING = smoking,
            YELLOW_FINGERS = yellowFingers,
            CHRONIC_DISEASE = chronicDisease,
            FATIGUE = fatigue,
            WHEEZING = wheezing,
            ALCOHOL_CONSUMING = alcoholConsuming,
            COUGHING = coughing,
            SHORTNESS_OF_BREATH = shortnessOfBreath,
            SWALLOWING_DIFFICULTY = swallowingDifficulty,
            CHEST_PAIN = chestPain
        )
    }
}
