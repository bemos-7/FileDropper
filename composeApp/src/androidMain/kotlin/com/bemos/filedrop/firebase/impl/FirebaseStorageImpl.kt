package com.bemos.filedrop.firebase.impl

import android.net.Uri
import android.util.Log
import com.bemos.filedrop.firebase.repo.FirebaseStorageRepository
import com.google.firebase.storage.FirebaseStorage

class FirebaseStorageImpl : FirebaseStorageRepository {
    override fun uploadFile(fileUri: Uri, fileName: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val fileRef = storageRef.child("uploads/${fileName}")
        fileRef.putFile(fileUri)
            .addOnSuccessListener { taskSnapshot ->
                Log.d("UploadFileFirebase", "successfully")
            }
            .addOnFailureListener {
                Log.d("UploadFileFirebase", "error")
            }
    }
}