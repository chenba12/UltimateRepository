package com.template.ultimaterepository.data.remote

import com.template.ultimaterepository.data.PetsNetwork
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PetsService {

    @GET("pets")
    fun getPets(): Deferred<Response<List<PetsNetwork>>>
}