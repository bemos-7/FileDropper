@file:OptIn(ExperimentalMaterialApi::class)

package com.bemos.filedrop.screens.util.theme.ui

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.screens.listOfFiles.listItem.FileListItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PullToRefreshLazyColumn(
    items: List<Document>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    onDownload: (String) -> Unit,
    onLongClick: (String) -> Unit,
    lazyListState: LazyListState = rememberLazyListState()
) {
    val pullToRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            onRefresh()
        }
    )
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullToRefreshState)
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .padding(10.dp)
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        coroutineScope.launch {
                            lazyListState.scrollBy(-delta)
                        }
                    }
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(
                items = items
            ) {
                FileListItem(
                    file = it,
                    onDownload,
                    onLongClick = onLongClick
                )
            }
        }

        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullToRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}