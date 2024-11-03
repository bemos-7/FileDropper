package com.bemos.filedrop.screens.listOfFiles.vm

import androidx.lifecycle.ViewModel
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.models.DocumentAndroid
import com.bemos.filedrop.use_cases.FetchFilesUseCase
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ListOfFilesViewModel(
    private val fetchFilesUseCase: FetchFilesUseCase
) : ViewModel() {

    val extractedFiles = MutableStateFlow<List<Document>>(listOf())
    val extractedFilesAndroid = MutableStateFlow<List<DocumentAndroid>>(listOf())

    suspend fun fetchFiles() {
        val json = fetchFilesUseCase.execute(
            onComplete = { files ->
                extractedFilesAndroid.update {
                    files
                }
            }
        )
        if (json.isNotEmpty()) {
            val documents = fromJsonToDocuments(json)
            extractedFiles.update {
                documents
            }
        }
    }

    private fun fromJsonToDocuments(json: String) : List<Document> {
        val jsonObject = Gson().fromJson(json, JsonObject::class.java)
        val documentJsonArray = jsonObject.getAsJsonArray("documents")
        val listType = object : TypeToken<List<Document>>() {}.type
        val documents: List<Document> = Gson().fromJson(documentJsonArray, listType)
        return documents
    }
}