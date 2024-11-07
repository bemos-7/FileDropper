package com.bemos.filedrop

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bemos.filedrop.di.platform.PlatformScreensRepository
import com.bemos.filedrop.screens.listOfFiles.ListOfFilesScreen
import com.bemos.filedrop.screens.uploadFile.UploadFileScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppUi(
    modifier: Modifier = Modifier,
    uploadFileScreen: PlatformScreensRepository,
    onDownloadClick: (String) -> Unit
) {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = "uploadFile"
        ) {
            uploadFile(
                uploadFileScreen
            )
            listOfFiles(
                onDownloadClick
            )
        }
    }
}

private fun NavGraphBuilder.uploadFile(
    uploadFileScreen: PlatformScreensRepository
) {
    composable(
        route = "uploadFile"
    ) {
        UploadFileScreen(
            uploadFileScreen = uploadFileScreen
        )
    }
}

private fun NavGraphBuilder.listOfFiles(
    onDownloadClick: (String) -> Unit
) {
    composable(
        route = "listOfFiles"
    ) {
        ListOfFilesScreen(
            onDownloadClick =  onDownloadClick
        )
    }
}