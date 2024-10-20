package com.bemos.filedrop.screens.listOfFiles.listItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.models.File
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun FileListItem(
    file: File
) {
    Card {

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(128.dp),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = file.fileName
            )
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}