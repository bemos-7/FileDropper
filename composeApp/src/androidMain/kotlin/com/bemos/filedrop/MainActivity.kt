package com.bemos.filedrop

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.bemos.filedrop.di.platform.AndroidPlatformScreenImpl
import com.bemos.filedrop.screens.uploadFile.UploadFileScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppUi(
                navController = navController,
                uploadFileScreen = AndroidPlatformScreenImpl(),
                onDownloadClick = { stringUrl ->
                    startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(stringUrl))
                    )
                }
            )
        }
    }
}