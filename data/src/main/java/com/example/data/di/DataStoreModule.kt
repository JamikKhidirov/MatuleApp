package com.example.data.di

import android.content.Context
import com.example.data.PincodeDataStore
import com.example.data.TokenDataStore
import com.example.domain.AuthRepository
import com.example.domain.PinCodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {


    @Provides
    @Singleton
    fun providePinCodeReposytory(
        @ApplicationContext context: Context
    ): PinCodeRepository = PincodeDataStore(context)


    @Provides
    @Singleton
    fun provideAuthRepository(
        @ApplicationContext context: Context
    ): AuthRepository = TokenDataStore(context)
    
}