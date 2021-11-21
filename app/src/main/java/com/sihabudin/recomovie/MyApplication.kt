package com.sihabudin.recomovie

import android.app.Application
import com.sihabudin.recomovie.core.di.databaseModule
import com.sihabudin.recomovie.core.di.networkModule
import com.sihabudin.recomovie.core.di.repositoryModule
import com.sihabudin.recomovie.di.useCaseModule
import com.sihabudin.recomovie.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}