package com.example.network.statenetworkmodel

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class NetworkInstance(
    val networkState: NetworkState
)
