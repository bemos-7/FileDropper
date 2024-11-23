package com.bemos.filedrop.use_cases

import com.bemos.filedrop.repository.FirebaseRepository

class DeleteFileUseCase(
    private val repository: FirebaseRepository
) {
    fun execute(fileName: String, onComplete: () -> Unit) {
        repository.deleteFile(fileName, onComplete)
    }
}