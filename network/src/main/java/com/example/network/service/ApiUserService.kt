package com.example.network.service

import com.example.network.data.userdata.RequestAuth
import com.example.network.data.userdata.RequestRegister
import com.example.network.data.userdata.ResponseAuth
import com.example.network.data.userdata.ResponseAuthMock
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



//Интерфейс для управления пользователями
interface ApiUserService {

    //Создание пользователя/Регистрация
    @POST("collections/users/records")
    suspend fun createUser(@Body requestRegister: RequestRegister): Response<ResponseRegister>


    //Получения информации о пользователе по его ID
    @GET("collections/users/records/{id_user}")
    suspend fun getUserInfoById(@Path("id_user") id: String): Response<User>



    //Изменения профиля пользователя
    @Multipart
    @PATCH("collections/users/records/{id_user}")
    suspend fun updateUser(
        //ID который нам нужен для того чтобы найти какого пользователя обновить
        @Path("id_user") id: String,
        //поля в RequestUser
        @PartMap params: Map<String, @JvmSuppressWildcards RequestBody>
    ): Response<User>



    //Авторизация пользователя/Вход в свой аккаунт
    @POST("collections/users/auth-with-password")
    suspend fun logInUser(@Body requestAuth: RequestAuth): Response<ResponseAuthMock>



    //Получение ID токена пользователя
    @GET("collections/_authOrigins/records")
    //Нужен Header токен
    suspend fun getUserIdToken(): UsersAuth


    //Удаление аккаунта пользователя
    @DELETE("collections/_authOrigins/records/{id_token}")
    suspend fun deleteUser(@Path("id_token") idToken: String)
}