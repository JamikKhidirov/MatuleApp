package com.example.network.service


import com.example.network.data.projectdata.Project
import com.example.network.data.projectdata.ResponsesProject
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap


interface ApiProjectService {

    @GET("/collections/project/records")
    suspend fun getListProject(): Response<ResponsesProject>

    @Multipart
    @POST("/collections/project/records")
    suspend fun createProject(@PartMap parts: Map<String, RequestBody>): Response<Project>


}