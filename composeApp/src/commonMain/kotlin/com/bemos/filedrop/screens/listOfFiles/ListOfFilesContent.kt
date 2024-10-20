package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.bemos.filedrop.models.File
import com.bemos.filedrop.screens.listOfFiles.listItem.FileListItem

@Composable
fun ListOfFilesContent(
    filesList: List<File>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(
                items = filesList
            ) {
                FileListItem(
                    file = it
                )
            }
        }
    }
}