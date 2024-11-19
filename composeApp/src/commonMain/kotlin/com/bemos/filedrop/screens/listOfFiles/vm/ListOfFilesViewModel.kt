package com.bemos.filedrop.screens.listOfFiles.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.filedrop.models.DocumentJson
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.screens.util.Constants.DOCUMENTS
import com.bemos.filedrop.use_cases.FetchFilesUseCase
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListOfFilesViewModel(
    private val fetchFilesUseCase: FetchFilesUseCase
) : ViewModel() {

    val extractedFiles = MutableStateFlow<List<Document>>(listOf())

    suspend fun fetchFiles() {
        val json = fetchFilesUseCase.execute(
            onComplete = { files ->
                extractedFiles.update {
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

    fun fetchFilesScope() = viewModelScope.launch {
        extractedFiles.update {
            listOf()
        }
        fetchFiles()
    }

    private fun fromJsonToDocuments(json: String?) : List<Document> {
        if ((json?.trim() ?: "{}") == "{}") return listOf()
        else {
            val jsonObject = Gson().fromJson(json, JsonObject::class.java)
            val documentJsonArray = jsonObject.getAsJsonArray(DOCUMENTS)
            val listType = object : TypeToken<List<DocumentJson>>() {}.type
            val documentJsons: List<DocumentJson> = Gson().fromJson(documentJsonArray, listType)

            return documentJsons.map { documentJson ->
                Document(
                    fileName = documentJson.fields.fileName.stringValue,
                    fileUrl = documentJson.fields.fileUrl.stringValue
                )
            }
        }
    }
}