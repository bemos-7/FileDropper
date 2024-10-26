package com.bemos.filedrop

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.bemos.filedrop.di.commonModule
import com.bemos.filedrop.di.desktopModule
import com.bemos.filedrop.di.platform.DesktopPlatformScreensImpl
import com.bemos.filedrop.screens.listOfFiles.ListOfFilesScreen
import org.koin.core.context.startKoin
import java.awt.Desktop
import java.net.URI

fun main() = application {
    startKoin {
        modules(commonModule, desktopModule)
    }
    val state = rememberWindowState(
        width = 1100.dp,
        height = 700.dp
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "FileDropper",
        resizable = false,
        state = state
    ) {
//        ListOfFilesScreen(
//            onDownloadClick = {
//                openLink(it)
//            }
//        )
        AppUi(
            uploadFileScreen = DesktopPlatformScreensImpl(),
            onDownloadClick = { url ->
                openLink(url)
            }
        )
    }
}

fun openLink(url: String) {
    if (!Desktop.isDesktopSupported()) {
        println("Desktop is not supported")
    } else {
        val uri = URI.create(url)
        Desktop.getDesktop().browse(uri)
    }
}