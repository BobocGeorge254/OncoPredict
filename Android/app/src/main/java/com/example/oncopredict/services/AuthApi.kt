package com.example.oncopredict.services

import com.example.oncopredict.data.AuthRequest
import com.example.oncopredict.data.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("register")
    fun register(@Body request: AuthRequest): Call<Void>

    @POST("login")
    fun login(@Body request: AuthRequest): Call<AuthResponse>
}