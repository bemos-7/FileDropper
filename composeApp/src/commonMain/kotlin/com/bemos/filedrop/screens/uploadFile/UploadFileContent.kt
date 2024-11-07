package com.bemos.filedrop.screens.uploadFile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.screens.util.theme.Colors
import com.bemos.filedrop.screens.util.theme.buttons.FButton
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.outline_upload_file_24
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UploadFileContent(
    onUploadClick: () -> Unit,
    onFilesClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FButton(
            modifier = Modifier,
            onClick = {
                onUploadClick()
            },
            content = {
                Icon(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(
                        resource = Res.drawable.outline_upload_file_24
                    ),
                    contentDescription = null,
                    tint = Colors.White
                )
            }
        )

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End
    ) {
        FButton(
            modifier = Modifier.padding(10.dp),
            onClick = {
                onFilesClick()
            },
            content = {
                Text(
                    text = "files",
                    color = Colors.White
                )
            }
        )
    }
}