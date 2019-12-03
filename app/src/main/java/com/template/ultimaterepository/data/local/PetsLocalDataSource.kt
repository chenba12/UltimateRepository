
package com.template.ultimaterepository.data.local

import androidx.lifecycle.LiveData
import com.template.ultimaterepository.data.Pet
import com.template.ultimaterepository.data.PetsDataSource
import com.template.ultimaterepository.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Concrete implementation of a data source as a db.
 */
class PetsLocalDataSource internal constructor(
    private val tasksDao: PetsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PetsDataSource {
    override fun observePets(): LiveData<Result<List<Pet>>> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getPets(): Result<List<Pet>> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun refreshPets() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun observePet(petId: String): LiveData<Result<Pet>> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getPet(petId: String): Result<Pet> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun refreshPet(petId: String) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun savePet(pet: Pet) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun completePet(pet: Pet) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun completePet(petId: String) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun activatePet(pet: Pet) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun activatePet(petId: String) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun clearCompletedPets() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteAllPets() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deletePet(petId: String) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
