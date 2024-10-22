package com.bemos.filedrop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bemos.filedrop.di.commonModule
import com.bemos.filedrop.screens.listOfFiles.ListOfFilesScreen
import com.bemos.filedrop.screens.uploadFile.UploadFileScreen
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(commonModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "FileDropper",
        resizable = false,
    ) {
        ListOfFilesScreen()
    }
}