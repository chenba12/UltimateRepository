package com.template.ultimaterepository

import android.app.Application
import androidx.room.Room
import com.template.ultimaterepository.data.AppRepository
import com.template.ultimaterepository.data.local.PetsDatabase
import com.template.ultimaterepository.data.remote.ApiCalls
import com.template.ultimaterepository.data.shared.SharedPref
import com.template.ultimaterepository.data.shared.SharedPrefImpl
import com.template.ultimaterepository.ui.main.MainFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        val appModule = module {
            single {
                Room.databaseBuilder(androidContext(),
                    PetsDatabase::class.java, "pets-database").build()
            }
            single { ApiCalls() }
            single {SharedPrefImpl(androidContext())as SharedPref}
            single { AppRepository(get(),get(),get())}
            viewModel { (appRepository: AppRepository) -> MainFragmentViewModel(appRepository) }
        }

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}
