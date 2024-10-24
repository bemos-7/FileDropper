package com.bemos.filedrop.repository

import com.bemos.filedrop.di.platform.PlatformUriRepository

interface FirebaseRepository {

    fun uploadFile(fileUri: PlatformUriRepository, fileName: String)

    suspend fun fetchFiles(): String

}