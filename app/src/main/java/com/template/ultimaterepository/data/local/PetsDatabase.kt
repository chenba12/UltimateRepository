
package com.template.ultimaterepository.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.template.ultimaterepository.data.Pet

@Database(entities = [Pet::class], version = 1, exportSchema = false)
abstract class PetsDatabase : RoomDatabase() {

    abstract fun petDao(): PetsDao
}
