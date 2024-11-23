package com.bemos.filedrop.di

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.repository.FirebaseRepository
import com.bemos.filedrop.screens.listOfFiles.vm.ListOfFilesViewModel
import com.bemos.filedrop.use_cases.DeleteFileUseCase
import com.bemos.filedrop.use_cases.FetchFilesUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val commonModule = module {
    single<PlatformUriRepository> { throw NotImplementedError("Platform-specific implementation required") }

    single { FetchFilesUseCase(repository = get()) }

    single { DeleteFileUseCase(repository = get()) }

    factory { ListOfFilesViewModel(fetchFilesUseCase = get(), deleteFileUseCase = get()) }

    viewModel { ListOfFilesViewModel(fetchFilesUseCase = get(), deleteFileUseCase = get()) }
}