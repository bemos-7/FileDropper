package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.bemos.filedrop.firebase.impl.FirebaseDesktopStorageImpl
import com.bemos.filedrop.models.File
import kotlinproject.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun ListOfFilesScreen() {
    var list = ""
    LaunchedEffect(Unit) {
        list = FirebaseDesktopStorageImpl().fetchFiles()
        println(list)
    }

    ListOfFilesContent(
        filesList = listOf(
        )
    )

}