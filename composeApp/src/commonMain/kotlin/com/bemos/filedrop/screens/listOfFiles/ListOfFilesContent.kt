package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.screens.listOfFiles.listItem.FileListItem
import com.bemos.filedrop.screens.util.theme.Colors.Black
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ListOfFilesContent(
    filesList: List<Document>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
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