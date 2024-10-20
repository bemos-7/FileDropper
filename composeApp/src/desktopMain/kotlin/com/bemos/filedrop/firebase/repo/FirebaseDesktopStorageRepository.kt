package com.bemos.filedrop.firebase.repo

interface FirebaseDesktopStorageRepository {
    suspend fun fetchFiles(): String
}