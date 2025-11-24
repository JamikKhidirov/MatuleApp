package com.example.network.service

import com.example.network.data.shopdata.Product
import com.example.network.data.shopdata.ResponseProducts
import com.example.network.data.shopdata.ResponsesNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



//Интерфейс для действий с магазином
interface ApiShopService {

    //Получение акций и новостей
    @GET("collections/news/records")
    suspend fun getNews(): Response<ResponsesNews>


    //Получение списка продуктов с поиском
    @GET("collections/products/records")
    suspend fun getListProductSearch(
        @Query("filter")
        filter: String
    ): Response<ResponseProducts>


    //Получение описания продукта
    @GET("collections/products/records/{id_product}")
    suspend fun getDescriptionProduct(
        @Path("id_product")
        //ID продукта которого хотим получить описание
        id: String
    ): Response<Product>


}