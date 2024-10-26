package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.screens.listOfFiles.listItem.FileListItem
import com.bemos.filedrop.screens.util.theme.Colors.Black
import com.bemos.filedrop.screens.util.theme.Colors.Light_Black
import com.bemos.filedrop.screens.util.theme.Colors.White
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ListOfFilesContent(
    filesList: List<Document>,
    onDownloadClick: (String) -> Unit
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
                    file = it,
                    onDownloadClick
                )
            }
        }
    }
//    Row(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalAlignment = Alignment.Bottom
//    ) {
//        Column {
//            Spacer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(1.dp)
//                    .background(White)
//            )
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(15.dp)
//                    .background(Light_Black),
//                horizontalArrangement = Arrangement.End
//            ) {
//                Text(
//                    text = "v1.0.0  ",
//                    color = White
//                )
//            }
//        }
//    }
}