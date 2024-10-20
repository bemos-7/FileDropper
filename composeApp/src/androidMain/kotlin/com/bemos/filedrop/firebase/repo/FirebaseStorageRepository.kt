package com.bemos.filedrop.firebase.repo

import android.net.Uri

interface FirebaseStorageRepository {

    fun uploadFile(fileUri: Uri, fileName: String)

}