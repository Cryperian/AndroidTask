package com.digitain.core.network.api

import com.digitain.core.network.dto.JackpotResponseDto
import retrofit2.http.GET

interface JackpotApiService {

    @GET("siteapi/Statistics/GetJackpot")
    suspend fun fetchJackpotData(): JackpotResponseDto
}