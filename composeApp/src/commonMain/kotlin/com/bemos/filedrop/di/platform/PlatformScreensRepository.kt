package com.bemos.filedrop.di.platform

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

interface PlatformScreensRepository {
    @Composable
    fun UploadFileScreen(navController: NavController)
}