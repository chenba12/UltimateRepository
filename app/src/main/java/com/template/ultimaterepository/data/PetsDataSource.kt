
package com.template.ultimaterepository.data

import androidx.lifecycle.LiveData

/**
 * Main entry point for accessing tasks data.
 */
interface PetsDataSource {

    fun observePets(): LiveData<Result<List<Pet>>>

    suspend fun getPets(): Result<List<Pet>>

    suspend fun refreshPets()

    fun observePet(petId: String): LiveData<Result<Pet>>

    suspend fun getPet(petId: String): Result<Pet>

    suspend fun refreshPet(petId: String)

    suspend fun savePet(pet: Pet)

    suspend fun completePet(pet: Pet)

    suspend fun completePet(petId: String)

    suspend fun activatePet(pet: Pet)

    suspend fun activatePet(petId: String)

    suspend fun clearCompletedPets()

    suspend fun deleteAllPets()

    suspend fun deletePet(petId: String)
}
