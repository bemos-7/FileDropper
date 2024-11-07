package com.bemos.filedrop.di.platform

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.bemos.filedrop.screens.uploadFile.UploadFileContent
import com.bemos.filedrop.screens.uploadFile.vm.UploadFileViewModel
import org.koin.compose.viewmodel.koinViewModel

class AndroidPlatformScreenImpl : PlatformScreensRepository {
    @Composable
    override fun UploadFileScreen() {
        val context = LocalContext.current
        var selectedFileUri by remember { mutableStateOf<Uri?>(null) }

        val viewModel: UploadFileViewModel = koinViewModel()

        val filePickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.OpenDocument()
        ) { uri: Uri? ->
            selectedFileUri = uri
            (viewModel.uploadFile(fileUri = AndroidPlatformUriImpl(uri!!), fileName = getFileName(context, selectedFileUri!!)!!, onComplete = {})).toString()
        }
        UploadFileContent(
            onUploadClick = {
                filePickerLauncher.launch(arrayOf("*/*"))
            },
            onFilesClick = {

            }
        )
        if (selectedFileUri != null) {
            Toast.makeText(context, getFileName(context, selectedFileUri!!), Toast.LENGTH_SHORT).show()
        }
    }

    fun getFileName(context: Context, uri: Uri): String? {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        return cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                it.getString(nameIndex)
            } else {
                null
            }
        }
    }
}