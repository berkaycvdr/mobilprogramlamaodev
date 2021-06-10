package com.abdullahakcakil.abdullahakcakilodev.data.dataapi

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers()=apiService.getUsers()
}
