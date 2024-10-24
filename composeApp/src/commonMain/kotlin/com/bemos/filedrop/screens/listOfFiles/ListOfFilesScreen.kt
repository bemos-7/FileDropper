package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bemos.filedrop.screens.listOfFiles.vm.ListOfFilesViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListOfFilesScreen() {

    val viewModel: ListOfFilesViewModel = koinViewModel()
    val extractedFiles by viewModel.extractedFiles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchFiles()
    }

    ListOfFilesContent(
        filesList = extractedFiles
    )

}