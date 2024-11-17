package com.bemos.filedrop.di.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.bemos.filedrop.screens.uploadFile.UploadFileContent
import com.bemos.filedrop.screens.uploadFile.vm.UploadFileViewModel
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import org.koin.compose.viewmodel.koinViewModel
import java.io.File

class DesktopPlatformScreensImpl : PlatformScreensRepository {

    @Composable
    override fun UploadFileScreen(navController: NavController) {
        var showFilePicker by remember {
            mutableStateOf(false)
        }
        val viewModel: UploadFileViewModel = koinViewModel()
        FilePicker(show = showFilePicker) { platformFile ->
            showFilePicker = false
            val pathFile = platformFile?.path ?: ""
            val file = File(pathFile)
            viewModel.uploadFile(
                fileUri = DesktopPlatformUriImpl(pathFile),
                fileName = file.name,
                onComplete = {}
            )
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