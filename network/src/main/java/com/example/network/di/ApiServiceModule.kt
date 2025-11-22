package com.example.network.di

import com.example.network.service.ApiBacketService
import com.example.network.service.ApiOrderService
import com.example.network.service.ApiProjectService
import com.example.network.service.ApiShopService
import com.example.network.service.ApiUserService
import com.example.network.statenetworkmodel.NetworkInstance
import com.example.network.statenetworkmodel.NetworkState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module()
@InstallIn(SingletonComponent::class)
object ApiServiceModule {


    @NetworkInstance(NetworkState.USERSERVICE)
    @Provides
    @Singleton
    fun providerUserService(retrofit: Retrofit): ApiUserService {
        return retrofit.create(ApiUserService::class.java)
    }


    @NetworkInstance(NetworkState.SHOPSERVICE)
    @Provides
    @Singleton
    fun providerShopService(retrofit: Retrofit): ApiShopService {
        return retrofit.create(ApiShopService::class.java)
    }


    @NetworkInstance(NetworkState.PROJECTSERVICE)
    @Provides
    @Singleton
    fun providerProjectService(retrofit: Retrofit): ApiProjectService {
        return retrofit.create(ApiProjectService::class.java)
    }


    @NetworkInstance(NetworkState.ORDERSERVICE)
    @Provides
    @Singleton
    fun providerOrderService(retrofit: Retrofit): ApiOrderService {
        return retrofit.create(ApiOrderService::class.java)
    }


    @NetworkInstance(NetworkState.BACKETSERVICE)
    @Provides
    @Singleton
    fun providerBacketService(retrofit: Retrofit): ApiBacketService {
        return retrofit.create(ApiBacketService::class.java)
    }


}