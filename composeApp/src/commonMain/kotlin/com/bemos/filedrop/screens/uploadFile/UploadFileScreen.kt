package com.bemos.filedrop.screens.uploadFile

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bemos.filedrop.di.platform.PlatformScreensRepository

@Composable
fun UploadFileScreen(
    navController: NavController,
    uploadFileScreen: PlatformScreensRepository
) {
    uploadFileScreen.UploadFileScreen(navController)
}