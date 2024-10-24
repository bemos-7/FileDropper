package com.bemos.filedrop.screens.uploadFile.vm

import androidx.lifecycle.ViewModel
import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.use_cases.UploadFileUseCase

class UploadFileViewModel(
    private val uploadFileUseCase: UploadFileUseCase
) : ViewModel() {

    fun uploadFile(
        fileUri: PlatformUriRepository,
        fileName: String
    ) {
        uploadFileUseCase.execute(
            fileUri = fileUri,
            fileName = fileName
        )
    }

}