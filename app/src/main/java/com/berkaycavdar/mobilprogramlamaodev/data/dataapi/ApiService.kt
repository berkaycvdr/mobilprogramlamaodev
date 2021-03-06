package com.berkaycavdar.mobilprogramlamaodev.data.dataapi

import com.berkaycavdar.mobilprogramlamaodev.data.modeldata.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():Response<MutableList<User>>
}