package com.digitain.core.data.repository

import com.digitain.core.data.datasource.JackpotRemoteDataSource
import com.digitain.core.data.di.AppDispatchers
import com.digitain.core.data.di.Dispatcher
import com.digitain.core.data.mapper.toDomain
import com.digitain.core.domain.model.JackpotData
import com.digitain.core.domain.repository.JackpotRepository
import com.digitain.core.network.utils.Constants.JACKPOT_POLLING_INTERVAL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.cancellation.CancellationException

@Singleton
class DefaultJackpotRepository @Inject constructor(
    private val remoteDataSource: JackpotRemoteDataSource,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    @Dispatcher(AppDispatchers.Default) private val defaultDispatcher: CoroutineDispatcher
) : JackpotRepository {

    override fun getData(): Flow<Result<JackpotData>> = flow {
        while (currentCoroutineContext().isActive) {
            val result = runCatching {
                val responseDto = withContext(ioDispatcher) {
                    remoteDataSource.getData()
                }
                withContext(defaultDispatcher) {
                    responseDto.toDomain()
                }
            }
            emit(result)
            delay(JACKPOT_POLLING_INTERVAL)
        }
    }
}