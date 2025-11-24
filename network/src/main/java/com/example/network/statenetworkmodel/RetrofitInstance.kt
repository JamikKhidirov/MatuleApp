package com.example.network.statenetworkmodel

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RetrofitInstance(
    val networkState: RetrofitNetworkState
)
