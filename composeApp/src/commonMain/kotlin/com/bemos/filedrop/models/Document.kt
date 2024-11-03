package com.bemos.filedrop.models

data class Document(
    val name: String = "",
    val fields: Fields = Fields(
        fileName = FileName(
            stringValue = "test"
        ),
        fileUrl = FileUrl(
            stringValue = ""
        )
    ),
    val createTime: String = "",
    val updateTime: String = "",
)

data class Fields(
    val fileName: FileName,
    val fileUrl: FileUrl,
)

data class FileName(
    val stringValue: String = "",
)

data class FileUrl(
    val stringValue: String = "",
)