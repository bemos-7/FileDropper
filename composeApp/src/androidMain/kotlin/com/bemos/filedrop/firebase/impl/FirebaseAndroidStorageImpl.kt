package com.bemos.filedrop.firebase.impl

import android.net.Uri
import android.util.Log
import com.bemos.filedrop.models.File
import com.bemos.filedrop.firebase.repo.FirebaseStorageRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class FirebaseAndroidStorageImpl : FirebaseStorageRepository {
    override fun uploadFile(fileUri: Uri, fileName: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val fileRef = storageRef.child("uploads/${fileName}")
        val uploadTask = fileRef.putFile(fileUri)
        uploadTask
            .addOnSuccessListener { taskSnapshot ->
                Log.d("UploadFileFirebase", "successfully")

                fileRef.downloadUrl.addOnSuccessListener { uri ->
                    saveFileUrlToFireStore(uri.toString(), fileName)
                }
            }
            .addOnFailureListener {
                Log.d("UploadFileFirebase", "error")
            }
    }

    private fun saveFileUrlToFireStore(downloadUrl: String, fileName: String) {
        val firestore = FirebaseFirestore.getInstance()
        val fileData = File(
            fileName = fileName,
            fileUrl = downloadUrl
        )

        firestore.collection("files").add(fileData)
            .addOnSuccessListener {
                Log.d("SaveFileUrlToFireStore", "successfully")
            }
            .addOnFailureListener {
                Log.d("SaveFileUrlToFireStore", "error")
            }
    }
}