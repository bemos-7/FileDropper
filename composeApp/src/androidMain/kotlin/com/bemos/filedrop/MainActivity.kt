package com.bemos.filedrop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bemos.filedrop.di.platform.AndroidPlatformScreenImpl
import com.bemos.filedrop.screens.uploadFile.UploadFileScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppUi(
                uploadFileScreen = AndroidPlatformScreenImpl(),
                onDownloadClick = {}
            )
        }
    }
}