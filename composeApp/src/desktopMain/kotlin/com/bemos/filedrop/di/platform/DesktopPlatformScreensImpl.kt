package com.bemos.filedrop.di.platform

import androidx.compose.runtime.Composable
import com.bemos.filedrop.screens.uploadFile.UploadFileContent

class DesktopPlatformScreensImpl() : PlatformScreensRepository {

    @Composable
    override fun UploadFileScreen() {
        UploadFileContent(
            onUploadClick = {

            },
            onFilesClick = {

            }
        )
    }
}