package com.bemos.filedrop.di

import com.bemos.filedrop.di.platform.DesktopPlatformScreensImpl
import com.bemos.filedrop.di.platform.DesktopPlatformUriImpl
import com.bemos.filedrop.di.platform.PlatformScreensRepository
import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.firebase.impl.FirebaseDesktopStorageImpl
import com.bemos.filedrop.repository.FirebaseRepository
import com.bemos.filedrop.screens.uploadFile.vm.UploadFileViewModel
import com.bemos.filedrop.use_cases.UploadFileUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val desktopModule = module {
    single<PlatformUriRepository> { (uri: String) -> DesktopPlatformUriImpl(uri = uri) }

    single<PlatformScreensRepository> { DesktopPlatformScreensImpl() }

    single<FirebaseRepository> { FirebaseDesktopStorageImpl() }

    single { UploadFileUseCase(get()) }

    viewModel { UploadFileViewModel(get()) }
}