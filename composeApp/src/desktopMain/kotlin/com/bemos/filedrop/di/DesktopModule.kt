package com.bemos.filedrop.di

import com.bemos.filedrop.firebase.impl.FirebaseDesktopStorageImpl
import com.bemos.filedrop.repository.FirebaseRepository
import org.koin.dsl.module

val desktopModule = module {
    single<FirebaseRepository> { FirebaseDesktopStorageImpl() }
}