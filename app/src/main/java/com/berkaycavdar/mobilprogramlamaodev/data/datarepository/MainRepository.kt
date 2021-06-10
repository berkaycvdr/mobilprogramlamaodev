package com.berkaycavdar.mobilprogramlamaodev.data.datarepository

import com.berkaycavdar.mobilprogramlamaodev.data.dataapi.RetrofitBuilder

class MainRepository {
    suspend fun getUsers() = RetrofitBuilder.api.getUsers()
}