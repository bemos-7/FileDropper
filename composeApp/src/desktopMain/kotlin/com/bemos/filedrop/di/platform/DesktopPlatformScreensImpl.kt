package com.bemos.filedrop.di.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.bemos.filedrop.screens.uploadFile.UploadFileContent
import com.bemos.filedrop.screens.uploadFile.vm.UploadFileViewModel
import com.bemos.filedrop.screens.util.theme.ui.CustomProgressBarDialog
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import org.koin.compose.viewmodel.koinViewModel
import java.io.File

class DesktopPlatformScreensImpl : PlatformScreensRepository {

    @Composable
    override fun UploadFileScreen(navController: NavController) {
        var showFilePicker by remember {
            mutableStateOf(false)
        }
        var openDialog by remember {
            mutableStateOf(false)
        }
        val viewModel: UploadFileViewModel = koinViewModel()

        FilePicker(show = showFilePicker) { platformFile ->
            openDialog = false
            showFilePicker = false
            val pathFile = platformFile?.path ?: ""
            val file = File(pathFile)
            viewModel.uploadFile(
                fileUri = DesktopPlatformUriImpl(pathFile),
                fileName = file.name,
                onComplete = {
                    openDialog = false
                }
            )
        }

        CustomProgressBarDialog(openDialog)

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