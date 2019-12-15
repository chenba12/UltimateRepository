package com.template.ultimaterepository.ui.main

import androidx.lifecycle.MutableLiveData
import com.template.ultimaterepository.data.AppRepository
import com.template.ultimaterepository.data.Pet
import com.template.ultimaterepository.ui.base.BaseViewModel
import kotlinx.coroutines.*

class MainFragmentViewModel(val appRepository: AppRepository) : BaseViewModel() {


    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _pets = MutableLiveData<List<Pet>>()
    val pets
    get() = _pets

    init {
        getPets()
    }


    fun getPets() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
               val request=appRepository.getPetsFromServer().await()
                if (request.isSuccessful) {
                    val data=request.body()
                    data?.let {
                        withContext(Dispatchers.Main) {
                            _pets.value=it.map {pet->
                                pet.fromNetworkToLocal(pet)
                            }
                        }
                    }
                }
            }
        }
    }
}
