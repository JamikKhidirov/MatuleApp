package com.example.network.service

import com.example.network.data.userdata.RequestAuth
import com.example.network.data.userdata.RequestRegister
import com.example.network.data.userdata.ResponseAuth
import com.example.network.data.userdata.ResponseRegister
import com.example.network.data.userdata.User
import com.example.network.data.userdata.UsersAuth
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.Path


interface ApiUserService {

    @POST("/collections/users/records")
    suspend fun createUser(@Body requestRegister: RequestRegister): Response<ResponseRegister>


    @GET("/collections/users/records/{id_user}")
    suspend fun getUserInfoById(@Path("id_user") id: String): Response<User>


    @Multipart
    @PATCH("/collections/users/records/{id_user}")
    suspend fun updateUser(
        @Path("id_user") id: String,
        @PartMap params: Map<String, @JvmSuppressWildcards RequestBody>
    ): Response<User>


    @POST("/collections/users/auth-with-password")
    suspend fun logInUser(@Body requestAuth: RequestAuth): Response<ResponseAuth>


    @GET("/collections/_authOrigins/records")
    suspend fun getUserIdToken(): UsersAuth


    @DELETE("/collections/_authOrigins/records/{id_token}")
    suspend fun deleteUser(@Path("id_token") idToken: String)
}