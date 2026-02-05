package com.example.network.di

import com.example.data.datastore.TokenDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


val BASE_URL = "http://64.188.89.182:4010/api/"



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttp(dataStore: TokenDataStore): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
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
    fun retrofirCreate(okHttpClient: OkHttpClient): Retrofit {
         return Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
    }


}