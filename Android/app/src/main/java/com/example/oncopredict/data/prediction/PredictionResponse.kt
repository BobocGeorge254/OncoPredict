package com.example.oncopredict.data.prediction

data class PredictionResponse(
    val lung_cancer_risk: String,
    val probability_yes: Double,
    val probability_no: Double
)
