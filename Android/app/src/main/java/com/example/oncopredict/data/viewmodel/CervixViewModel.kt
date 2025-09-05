package com.example.oncopredict.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.oncopredict.data.prediction.CervixPatientData

class CervixViewModel : ViewModel() {
    var age: Int = 0
    var numberOfSexualPartners: Int = 0
    var firstSexualIntercourse: Int = 0
    var numOfPregnancies: Int = 0
    var smokes: Int = 0
    var smokesYears: Int = 0
    var smokesPacksYear: Int = 0
    var hormonalContraceptives: Int = 0
    var hormonalContraceptivesYears: Int = 0
    var iud: Int = 0
    var iudYears: Int = 0
    var stds: Int = 0
    var stdsNumber: Int = 0
    var stdsHPV: Int = 0

    fun toRequest(): CervixPatientData {
        return CervixPatientData(
            age,
            numberOfSexualPartners,
            firstSexualIntercourse,
            numOfPregnancies,
            smokes,
            smokesYears,
            smokesPacksYear,
            hormonalContraceptives,
            hormonalContraceptivesYears,
            iud,
            iudYears,
            stds,
            stdsNumber,
            stdsHPV
        )
    }
}
