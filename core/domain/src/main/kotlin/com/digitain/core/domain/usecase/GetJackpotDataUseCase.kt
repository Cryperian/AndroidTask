package com.digitain.core.domain.usecase

import com.digitain.core.domain.model.JackpotData
import com.digitain.core.domain.repository.JackpotRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetJackpotDataUseCase @Inject constructor(
    private val jackpotRepository: JackpotRepository
) {
    operator fun invoke(): Flow<Result<JackpotData>> {
        return jackpotRepository.getData()
    }
}