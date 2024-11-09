package com.bemos.filedrop.screens.listOfFiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.screens.util.theme.Colors.Black
import com.bemos.filedrop.screens.util.theme.ui.PullToRefreshLazyColumn

@Composable
fun ListOfFilesContent(
    filesList: List<Document>,
    onDownloadClick: (String) -> Unit,
    onRefresh: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isRefreshing by remember {
            mutableStateOf(false)
        }
//        LazyColumn(
//            modifier = Modifier.padding(10.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            item {
//                Spacer(modifier = Modifier.height(20.dp))
//            }
//            items(
//                items = filesList
//            ) {
//                FileListItem(
//                    file = it,
//                    onDownloadClick
//                )
//            }
//        }
        PullToRefreshLazyColumn(
            items = filesList,
            isRefreshing = isRefreshing,
            onRefresh = {
                isRefreshing = true
                onRefresh()
                isRefreshing = false
            },
            onDownloadClick
        )
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