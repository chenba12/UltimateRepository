package com.template.ultimaterepository.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

data class PetsNetwork constructor(
    var uid: String = UUID.randomUUID().toString(),
    var name: String = "",
    var breed: String = "",
    var age: Int = 0,
    var isAdopted: Boolean = false
) {
    fun fromNetworkToLocal(pet:PetsNetwork):Pet {
        return Pet(pet.uid,pet.name,pet.breed,pet.age,pet.isAdopted)
    }
}



