package com.example.oncopredict.services

import com.example.oncopredict.data.prediction.LungPatientData
import com.example.oncopredict.data.prediction.PredictionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LungApi {
    @POST("predict-lung")
    fun predictLung(@Body request: LungPatientData, @Header("Authorization") token: String): Call<PredictionResponse>
}
