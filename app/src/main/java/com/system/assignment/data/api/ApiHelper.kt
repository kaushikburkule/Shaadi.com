package com.system.assignment.data.api

import com.system.assignment.data.model.Response

interface ApiHelper {

    suspend fun getUsers(): Response

}