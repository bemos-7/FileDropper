package com.bemos.filedrop.models

data class Document(
    val name: String,
    val fields: Fields,
    val createTime: String,
    val updateTime: String,
)

data class Fields(
    val fileName: FileName,
    val fileUrl: FileUrl,
)

data class FileName(
    val stringValue: String,
)

data class FileUrl(
    val stringValue: String,
)