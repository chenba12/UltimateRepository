package com.template.ultimaterepository.data

import com.template.ultimaterepository.data.local.PetsDatabase
import com.template.ultimaterepository.data.remote.ApiCalls
import com.template.ultimaterepository.data.remote.PetsService
import com.template.ultimaterepository.data.shared.SharedPref
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import timber.log.Timber

class AppRepository(val database: PetsDatabase,val sharedPref: SharedPref,val apiCalls: ApiCalls) {

    private val petService:PetsService = apiCalls.retrofit()
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend fun getPetsFromServer():Deferred<Response<List<PetsNetwork>>>{
       return petService.getPets()

    }

    init {
        Timber.wtf("app repo created")
    }
}
