package com.abdullahakcakil.abdullahakcakilodev.data.datarepository

import com.abdullahakcakil.abdullahakcakilodev.data.dataapi.RetrofitBuilder

class MainRepository {
    suspend fun getUsers() = RetrofitBuilder.api.getUsers()
}