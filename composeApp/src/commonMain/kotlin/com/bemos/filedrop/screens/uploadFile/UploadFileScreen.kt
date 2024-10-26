package com.bemos.filedrop.screens.uploadFile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bemos.filedrop.di.platform.PlatformScreensRepository

@Composable
fun UploadFileScreen(
    uploadFileScreen: PlatformScreensRepository
) {
    uploadFileScreen.UploadFileScreen()
}