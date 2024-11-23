package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.bemos.filedrop.screens.listOfFiles.vm.ListOfFilesViewModel
import com.bemos.filedrop.screens.util.theme.ui.CustomDeleteDialog
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListOfFilesScreen(
    onDownloadClick: (String) -> Unit
) {
    var openDialog by remember {
        mutableStateOf(false)
    }

    var intentFileName by remember {
        mutableStateOf("")
    }

    val viewModel: ListOfFilesViewModel = koinViewModel()
    val extractedFiles by viewModel.extractedFiles.collectAsState()

    CustomDeleteDialog(
        openDialog = openDialog,
        onDismissRequest = {
            openDialog = false
        },
        onNoClick = {
            openDialog = false
        },
        onYesClick = {
            openDialog = false
            viewModel.deleteFile(
                intentFileName
            )
        }
    )

    LaunchedEffect(Unit) {
        viewModel.fetchFiles()
    }

    ListOfFilesContent(
        filesList = extractedFiles,
        onDownloadClick = {
            onDownloadClick(it)
        },
        onRefresh = {
            viewModel.fetchFilesScope()
        },
        onLongClick = {
            openDialog = true
            intentFileName = it
        }
    )
}