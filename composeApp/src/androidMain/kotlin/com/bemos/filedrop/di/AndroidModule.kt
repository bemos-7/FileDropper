package com.bemos.filedrop.di

import android.net.Uri
import com.bemos.filedrop.di.platform.AndroidPlatformScreenImpl
import com.bemos.filedrop.di.platform.AndroidPlatformUriImpl
import com.bemos.filedrop.di.platform.PlatformScreensRepository
import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.firebase.impl.AndroidFirebaseImpl
import com.bemos.filedrop.repository.FirebaseRepository
import com.bemos.filedrop.screens.listOfFiles.vm.ListOfFilesViewModel
import com.bemos.filedrop.screens.uploadFile.vm.UploadFileViewModel
import com.bemos.filedrop.use_cases.FetchFilesUseCase
import com.bemos.filedrop.use_cases.UploadFileUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single<PlatformUriRepository> { (uri: Uri) -> AndroidPlatformUriImpl(uri = uri) }

    single<FirebaseRepository> { AndroidFirebaseImpl() }

    single<PlatformScreensRepository> { AndroidPlatformScreenImpl() }

    single { UploadFileUseCase(get()) }

    single { FetchFilesUseCase(get()) }

    viewModel { UploadFileViewModel(get()) }

    viewModel { ListOfFilesViewModel(get(), get()) }
}