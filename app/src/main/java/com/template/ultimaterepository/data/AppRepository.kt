package com.template.ultimaterepository.data

import com.template.ultimaterepository.data.local.PetsDatabase
import timber.log.Timber

class AppRepository(database: PetsDatabase) {
    init {
        Timber.wtf("app repo created")
    }
}
