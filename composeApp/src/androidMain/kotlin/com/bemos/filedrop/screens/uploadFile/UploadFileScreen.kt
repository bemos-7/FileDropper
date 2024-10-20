package com.bemos.filedrop.screens.uploadFile

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
import com.bemos.filedrop.firebase.impl.FirebaseAndroidStorageImpl

@Composable
fun UploadFileScreen() {

    val context = LocalContext.current
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        selectedFileUri = uri
        FirebaseAndroidStorageImpl().uploadFile(selectedFileUri!!, fileName = getFileName(context,
            selectedFileUri!!
        ).toString())
    }

    UploadFileContent(
        onUploadClick = {
            filePickerLauncher.launch(arrayOf("*/*"))
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