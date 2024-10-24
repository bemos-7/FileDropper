package com.bemos.filedrop.use_cases

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.repository.FirebaseRepository

class UploadFileUseCase(
    private val repository: FirebaseRepository
) {
    fun execute(
        fileUri: PlatformUriRepository,
        fileName: String
    ) {
        repository.uploadFile(
            fileUri,
            fileName
        )
    }
}