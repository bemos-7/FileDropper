package com.bemos.filedrop.firebase.impl

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.repository.FirebaseRepository
import com.bemos.filedrop.screens.util.Constants.API_KEY
import com.bemos.filedrop.screens.util.Constants.COLLECTION
import com.bemos.filedrop.screens.util.Constants.PROJECT_ID
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FirebaseDesktopStorageImpl : FirebaseRepository{
    override fun uploadFile(fileUri: PlatformUriRepository, fileName: String, onComplete: () -> Unit) {

    }

    override suspend fun fetchFiles(onComplete: (List<Document>) -> Unit): String {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }

        val url = "https://firestore.googleapis.com/v1/projects/$PROJECT_ID/databases/(default)/documents/$COLLECTION?key=$API_KEY"

        return try {
            val response: HttpResponse = client.get(url)
            response.bodyAsText()
        } catch (e: Exception) {
            e.printStackTrace()
            "Error"
        } finally {
            client.close()
        }
    }
}