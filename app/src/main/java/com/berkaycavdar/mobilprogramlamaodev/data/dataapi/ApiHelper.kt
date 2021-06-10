package com.berkaycavdar.mobilprogramlamaodev.data.dataapi

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers()=apiService.getUsers()
}
