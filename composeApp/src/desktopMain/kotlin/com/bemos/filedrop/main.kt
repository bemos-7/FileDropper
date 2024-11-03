package com.bemos.filedrop

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.bemos.filedrop.di.commonModule
import com.bemos.filedrop.di.desktopModule
import com.bemos.filedrop.di.platform.DesktopPlatformScreensImpl
import com.bemos.filedrop.screens.listOfFiles.ListOfFilesScreen
import io.kanro.compose.jetbrains.expui.theme.DarkTheme
import io.kanro.compose.jetbrains.expui.theme.LightTheme
import io.kanro.compose.jetbrains.expui.window.JBWindow
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.github_mark_white
import org.jetbrains.compose.resources.painterResource
import org.koin.core.context.startKoin
import java.awt.Desktop
import java.net.URI

fun main() = application {
    startKoin {
        modules(commonModule, desktopModule)
    }
    JBWindow(
        title = "FileDropper",
        showTitle = true,
        theme = DarkTheme,
        state = rememberWindowState(
            width = 1100.dp,
            height = 700.dp
        ),
        onCloseRequest = {
            exitApplication()
        },
        mainToolBar = {
            Row(
                Modifier.mainToolBarItem(
                    Alignment.End,
                    true
                )
            ) {
                Icon(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(Res.drawable.github_mark_white),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    ) {
        AppUi(
            uploadFileScreen = DesktopPlatformScreensImpl(),
            onDownloadClick = { url ->
                openLink(url)
            }
        )
    }
}

private fun openLink(url: String) {
    if (!Desktop.isDesktopSupported()) {
        println("Desktop is not supported")
    } else {
        val uri = URI.create(url)
        Desktop.getDesktop().browse(uri)
    }
}