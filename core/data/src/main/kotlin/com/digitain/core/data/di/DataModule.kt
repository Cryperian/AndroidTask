package com.digitain.core.data.di

import com.digitain.core.data.datasource.JackpotRemoteDataSource
import com.digitain.core.data.datasource.JackpotRemoteDataSourceImpl
import com.digitain.core.data.repository.DefaultJackpotRepository
import com.digitain.core.domain.repository.JackpotRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsJackpotRemoteDataSource(
        jackpotRemoteDataSourceImpl: JackpotRemoteDataSourceImpl
    ): JackpotRemoteDataSource

    @Binds
    abstract fun bindsJackpotRepository(
        defaultJackpotRepository: DefaultJackpotRepository
    ): JackpotRepository

}