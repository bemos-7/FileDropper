package com.bemos.filedrop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bemos.filedrop.screens.listOfFiles.ListOfFilesScreen
import com.bemos.filedrop.screens.uploadFile.UploadFileScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FileDropper",
        resizable = false,
    ) {
        ListOfFilesScreen()
    }
}