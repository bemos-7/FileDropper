package com.bemos.filedrop.app

import android.app.Application
import com.bemos.filedrop.di.commonModule
import com.google.firebase.Firebase
import com.google.firebase.initialize
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
        startKoin {
            androidContext(this@App)
            modules(commonModule)
        }
    }
}