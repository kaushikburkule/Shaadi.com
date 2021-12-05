package com.system.assignment.data.api

import com.system.assignment.data.api.RetrofitBuilder.apiService
import com.system.assignment.data.model.ApiUser
import com.system.assignment.data.model.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor() : ApiHelper {

    override suspend fun getUsers(): Response = apiService.getUsers()

}