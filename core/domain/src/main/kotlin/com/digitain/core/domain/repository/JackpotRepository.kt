package com.digitain.core.domain.repository

import com.digitain.core.domain.model.JackpotData
import kotlinx.coroutines.flow.Flow

interface JackpotRepository {
    fun getData(): Flow<Result<JackpotData>>
}