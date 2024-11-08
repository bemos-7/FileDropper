package com.bemos.filedrop

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
    navController: NavHostController,
    uploadFileScreen: PlatformScreensRepository,
    onDownloadClick: (String) -> Unit
) {
    MaterialTheme {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = "uploadFile"
        ) {
            uploadFile(
                navController,
                uploadFileScreen
            )
            listOfFiles(
                onDownloadClick
            )
        }
    }
}

private fun NavGraphBuilder.uploadFile(
    navController: NavController,
    uploadFileScreen: PlatformScreensRepository
) {
    composable(
        route = "uploadFile"
    ) {
        UploadFileScreen(
            navController = navController,
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