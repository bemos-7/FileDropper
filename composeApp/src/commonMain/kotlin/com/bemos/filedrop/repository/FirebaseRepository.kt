package com.bemos.filedrop.repository

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.models.Document

interface FirebaseRepository {

    fun uploadFile(fileUri: PlatformUriRepository, fileName: String, onComplete: () -> Unit)

    suspend fun fetchFiles(onComplete: (List<Document>) -> Unit): String

}