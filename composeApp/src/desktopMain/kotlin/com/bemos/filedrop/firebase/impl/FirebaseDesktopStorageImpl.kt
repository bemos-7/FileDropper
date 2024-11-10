package com.bemos.filedrop.firebase.impl

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.repository.FirebaseRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.io.File

private const val projectId = "filedropper-37014"
private const val collection = "files"
private const val apiKey = "AIzaSyCDmIntxsjQ-5JCuJZNAxSD2LZ00wHspv4"

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

        val url = "https://firestore.googleapis.com/v1/projects/$projectId/databases/(default)/documents/$collection?key=$apiKey"

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