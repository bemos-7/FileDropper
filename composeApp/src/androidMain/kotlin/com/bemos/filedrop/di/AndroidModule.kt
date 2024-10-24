package com.bemos.filedrop.di

import android.net.Uri
import com.bemos.filedrop.di.platform.AndroidPlatformUriImpl
import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.firebase.impl.FirebaseAndroidStorageImpl
import com.bemos.filedrop.repository.FirebaseRepository
import org.koin.dsl.module

val androidModule = module {
    single<PlatformUriRepository> { (uri: Uri) -> AndroidPlatformUriImpl(uri = uri) }

    single<FirebaseRepository> { FirebaseAndroidStorageImpl() }
}