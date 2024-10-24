package com.bemos.filedrop.screens.listOfFiles.listItem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.models.File
import com.bemos.filedrop.screens.util.theme.Colors.Light_Black
import com.bemos.filedrop.screens.util.theme.Colors.White
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinproject.composeapp.generated.resources.round_insert_drive_file_24
import kotlinproject.composeapp.generated.resources.round_upload_file_24
import org.jetbrains.compose.resources.painterResource

@Composable
fun FileListItem(
    file: Document
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, White)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Light_Black),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(15.dp).weight(1f),
            ) {
                Icon(
                    modifier = Modifier.size(128.dp),
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    tint = Color.White,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = file.fields.fileName.stringValue,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {

                    }
                ) {
                    Text(
                        text = "Download"
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}