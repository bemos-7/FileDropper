package com.bemos.filedrop.repository

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.models.DocumentAndroid

interface FirebaseRepository {

    fun uploadFile(fileUri: PlatformUriRepository, fileName: String, onComplete: () -> Unit)

    suspend fun fetchFiles(onComplete: (List<DocumentAndroid>) -> Unit): String

}