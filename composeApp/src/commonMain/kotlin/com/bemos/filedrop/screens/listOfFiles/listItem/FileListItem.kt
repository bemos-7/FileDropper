package com.bemos.filedrop.screens.listOfFiles.listItem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.models.Document
import com.bemos.filedrop.screens.util.theme.Colors.Light_Black
import com.bemos.filedrop.screens.util.theme.Colors.White
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.outline_file_download
import kotlinproject.composeapp.generated.resources.outline_insert_drive_file
import org.jetbrains.compose.resources.painterResource

@Composable
fun FileListItem(
    file: Document,
    onDownloadClick: (String) -> Unit
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
                    painter = painterResource(Res.drawable.outline_insert_drive_file),
                    tint = White,
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
                Icon(
                    modifier = Modifier.size(32.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable {
                        onDownloadClick(file.fields.fileUrl.stringValue)
                    },
                    painter = painterResource(Res.drawable.outline_file_download),
                    tint = White,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}