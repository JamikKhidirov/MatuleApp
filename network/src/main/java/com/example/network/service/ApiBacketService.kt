package com.example.network.service

import com.example.network.data.backetdata.RequestCart
import com.example.network.data.backetdata.ResponseCart
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.Path


interface ApiBacketService {


    @POST("/collections/cart/records")
    suspend fun createBucket(@Body requestCart: RequestCart): Response<ResponseCart>


    @Multipart
    @PATCH("/collections/cart/records/{id_bucket}")
    suspend fun updateUserBacket(
        @Path("id_bucket") id: String,
        //Принимает данные в RequestCart
        @PartMap parts: Map<String, @JvmSuppressWildcards RequestBody>
    ): Response<ResponseCart>


}