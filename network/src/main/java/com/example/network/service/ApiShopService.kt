package com.example.network.service

import com.example.network.data.shopdata.Product
import com.example.network.data.shopdata.ResponseProducts
import com.example.network.data.shopdata.ResponsesNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiShopService {

    @GET("/collections/news/records")
    suspend fun getNews(): Response<ResponsesNews>


    @GET("/collections/products/records")
    suspend fun getListProductSearch(@Query("filter") filter: String): Response<ResponseProducts>

    @GET("/collections/products/records/{id_product}")
    suspend fun getDescriptionProduct(@Path("id_product") id: String): Response<Product>


}