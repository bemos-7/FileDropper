package com.bemos.filedrop.use_cases

import com.bemos.filedrop.models.Document
import com.bemos.filedrop.repository.FirebaseRepository

class FetchFilesUseCase(
    private val repository: FirebaseRepository
) {
    suspend fun execute(onComplete: (List<Document>) -> Unit) : String {
        return repository.fetchFiles(onComplete)
    }
}