
package com.template.ultimaterepository.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "pets")
data class Pet constructor(
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var breed: String = "",
    var age: Int = 0,
    @ColumnInfo(name = "adopted") var isAdopted: Boolean = false
)
