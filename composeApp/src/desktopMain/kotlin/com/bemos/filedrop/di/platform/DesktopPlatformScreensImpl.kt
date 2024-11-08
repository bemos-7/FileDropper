package com.bemos.filedrop.di.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.bemos.filedrop.screens.uploadFile.UploadFileContent
import com.darkrockstudios.libraries.mpfilepicker.DirectoryPicker
import com.darkrockstudios.libraries.mpfilepicker.FilePicker

class DesktopPlatformScreensImpl : PlatformScreensRepository {

    @Composable
    override fun UploadFileScreen(navController: NavController) {
        var showFilePicker by remember {
            mutableStateOf(false)
        }
        FilePicker(show = showFilePicker) { platformFile ->
            showFilePicker = false
            println(platformFile)
        }
        UploadFileContent(
            onUploadClick = {
                showFilePicker = true
            },
            onFilesClick = {
                navController.navigate("listOfFiles")
            }
        )
    }
}