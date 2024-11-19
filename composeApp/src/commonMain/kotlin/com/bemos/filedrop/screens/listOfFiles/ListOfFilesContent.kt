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
}