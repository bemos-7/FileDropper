package com.bemos.filedrop.firebase.impl

import com.bemos.filedrop.di.platform.PlatformUriRepository
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.repository.FirebaseRepository
import com.bemos.filedrop.screens.util.Constants.API_KEY
import com.bemos.filedrop.screens.util.Constants.BUCKET_NAME
import com.bemos.filedrop.screens.util.Constants.COLLECTION
import com.bemos.filedrop.screens.util.Constants.PROJECT_ID
import com.google.gson.JsonParser
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.File
import java.io.IOException
import java.net.URLEncoder

class FirebaseDesktopStorageImpl() : FirebaseRepository {
    override fun uploadFile(fileUri: PlatformUriRepository, fileName: String, onComplete: () -> Unit) {
        val filePath = File(fileUri.getUri())

        val url = "https://firebasestorage.googleapis.com/v0/b/$BUCKET_NAME/o?uploadType=media&name=uploads/${filePath.name}&key=$API_KEY"

        val requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), filePath)

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .addHeader("Content-Type", "application/octet-stream")
            .build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Upload failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val jsonResponse = response.body()?.string()
                    val downloadUrl = extractDownloadUrlFromResponse(jsonResponse)

                    if (downloadUrl != null) {
                        saveFileToFirebaseFireStore(downloadUrl, filePath.name) {
                            onComplete()
                        }
                    } else {
                        println("DownloadUrl is null")
                    }
                    println("File uploaded successfully: ${response.body()?.string()}")
                } else {
                    println("Upload failed with code ${response.code()}: ${response.body()?.string()}")
                }
            }

        })
    }

    fun extractDownloadUrlFromResponse(response: String?): String? {
        return response?.let {
            val jsonObject = JsonParser.parseString(it).asJsonObject
            val downloadToken = jsonObject.get("downloadTokens")?.asString
            val fileName = jsonObject.get("name")?.asString
            val bucketName = jsonObject.get("bucket")?.asString

            if (downloadToken != null && fileName != null && bucketName != null) {
                val encodedFileName = URLEncoder.encode(fileName, "UTF-8").replace("+", "%20")
                return "https://firebasestorage.googleapis.com/v0/b/$bucketName/o/${encodedFileName}?alt=media&token=$downloadToken"
            }
            null
        }
    }

    fun saveFileToFirebaseFireStore(downloadUrl: String, fileName: String, onComplete: () -> Unit) {
        val firestoreUrl = "https://firestore.googleapis.com/v1/projects/$PROJECT_ID/databases/(default)/documents/$COLLECTION?key=$API_KEY"

        val jsonPayload = """
            {
                "fields": {
                    "fileName": { "stringValue": "$fileName" },
                    "fileUrl": { "stringValue": "$downloadUrl" }
                }
            }
        """.trimIndent()

        val responseBody = RequestBody.create(MediaType.parse("application/json"), jsonPayload)

        val request = Request.Builder()
            .url(firestoreUrl)
            .post(responseBody)
            .addHeader("Content-Type", "application/octet-stream")
            .build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("Error ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    println("URL saved to Firestore successfully")
                } else {
                    println("Failed to save with code ${response.code()}: ${response.body()?.string()}")
                }
            }

        })
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