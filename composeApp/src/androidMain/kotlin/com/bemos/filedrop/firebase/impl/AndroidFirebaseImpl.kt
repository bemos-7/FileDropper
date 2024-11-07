package com.bemos.filedrop.firebase.impl

import android.util.Log
import androidx.core.net.toUri
import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.models.File
import com.bemos.filedrop.repository.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage

class AndroidFirebaseImpl : FirebaseRepository {
    override fun uploadFile(fileUri: PlatformUriRepository, fileName: String, onComplete: () -> Unit) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val fileRef = storageRef.child("uploads/${fileName}")
        val uploadTask = fileRef.putFile((fileUri.getUri()).toUri())
        uploadTask
            .addOnSuccessListener { taskSnapshot ->
                Log.d("UploadFileFirebase", "successfully")

                fileRef.downloadUrl.addOnSuccessListener { uri ->
                    saveFileUrlToFireStore(uri.toString(), fileName)
                }
                onComplete()
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

    override suspend fun fetchFiles(onComplete: (List<Document>) -> Unit): String {
        val firestore = FirebaseFirestore.getInstance()
        val fileRef = firestore.collection("files")
        fileRef.get()
            .addOnSuccessListener { documents ->
                val uniqueModels = documents.map { it.toObject<Document>() }
                Log.d("FirebaseFetchFiles", uniqueModels.toString())
                onComplete(uniqueModels)
            }
        return ""
    }
}