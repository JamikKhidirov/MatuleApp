package com.example.network.di

import com.example.data.TokenDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


val BASE_URL = "http://10.0.2.2:4010/"



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkhttp(dataStore: TokenDataStore): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()

                val token = runBlocking {
                    dataStore.tokenFlow.firstOrNull()
                }

                val newRequest = originalRequest.newBuilder().apply {
                    token?.let {
                        header("Authorization", "Bearer $it")
                    }
                }.build()
                chain.proceed(newRequest)
            }
            .build()
    }

    @Provides
    @Singleton
    fun retrofirCreate(okHttpClient: OkHttpClient): Retrofit{
         return Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()

    }


}