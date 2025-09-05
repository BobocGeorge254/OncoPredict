package com.example.oncopredict.data.prediction

data class CervixPatientData (
    val AGE: Int,
    val NUMBER_OF_SEXUAL_PARTNERS: Int,
    val FIRST_SEXUAL_INTERCOURSE: Int,
    val NUM_OF_PREGNANCIES: Int,
    val SMOKES: Int,
    val SMOKES_YEARS: Int,
    val SMOKES_PACKS_YEAR: Int,
    val HORMONAL_CONTRACEPTIVES: Int,
    val HORMONAL_CONTRACEPTIVES_YEARS: Int,
    val IUD: Int,
    val IUD_YEARS: Int,
    val STDS: Int,
    val STDS_NUMBER: Int,
    val STDS_HPV: Int
)