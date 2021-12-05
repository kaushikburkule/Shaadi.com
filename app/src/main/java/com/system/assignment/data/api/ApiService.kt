package com.system.assignment.data.api

import com.system.assignment.data.model.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=3")
    suspend fun getUsers(): Response

}