package com.digitain.core.data.datasource

import com.digitain.core.network.api.JackpotApiService
import com.digitain.core.network.dto.JackpotResponseDto
import javax.inject.Inject

interface JackpotRemoteDataSource {
    suspend fun getData(): JackpotResponseDto
}

class JackpotRemoteDataSourceImpl @Inject constructor(
    private val apiService: JackpotApiService
) : JackpotRemoteDataSource {

    override suspend fun getData(): JackpotResponseDto {
        return apiService.fetchJackpotData()
    }
}