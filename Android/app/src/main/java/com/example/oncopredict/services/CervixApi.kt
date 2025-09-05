package com.example.oncopredict.services

import com.example.oncopredict.data.prediction.CervixPatientData
import com.example.oncopredict.data.prediction.PredictionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CervixApi {
    @POST("predict-cervix")
    fun predictCervix(@Body request: CervixPatientData, @Header("Authorization") token: String): Call<PredictionResponse>
}
