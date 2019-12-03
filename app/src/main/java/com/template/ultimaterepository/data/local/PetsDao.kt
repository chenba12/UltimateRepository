package com.template.ultimaterepository.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.template.ultimaterepository.data.Pet

/**
 * Data Access Object for the tasks table.
 */
@Dao
interface PetsDao {

    @Query("SELECT * FROM Pets")
    fun observePets(): LiveData<List<Pet>>

    @Query("SELECT * FROM Pets WHERE id = :taskId")
    fun observePetById(taskId: String): LiveData<Pet>

    @Query("SELECT * FROM Pets")
    suspend fun getPets(): List<Pet>

    @Query("SELECT * FROM Pets WHERE id = :taskId")
    suspend fun getPetById(taskId: String): Pet?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(task: Pet)

    @Update
    suspend fun updatePet(task: Pet): Int

    @Query("UPDATE Pets SET adopted = :adopted WHERE id = :taskId")
    suspend fun updateAdopted(taskId: String, adopted: Boolean)

    @Query("DELETE FROM Pets WHERE id = :petId")
    suspend fun deletePetById(petId: String): Int

    @Query("DELETE FROM Pets")
    suspend fun deletePets()

    @Query("DELETE FROM Pets WHERE adopted = 1")
    suspend fun deleteAdoptedPets(): Int
}
