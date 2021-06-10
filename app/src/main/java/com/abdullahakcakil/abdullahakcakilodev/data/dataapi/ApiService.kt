package com.abdullahakcakil.abdullahakcakilodev.data.dataapi

import com.abdullahakcakil.abdullahakcakilodev.data.modeldata.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():Response<MutableList<User>>
}