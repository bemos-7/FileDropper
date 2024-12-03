package com.bemos.filedrop.screens.util.theme.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.round_delete_outline_24
import org.jetbrains.compose.resources.painterResource

@Composable
fun CustomDeleteDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onYesClick: () -> Unit,
    onNoClick: () -> Unit
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = {
                onDismissRequest()
            },
            content = {
                CustomDeleteDialogUi(
                    onYesClick,
                    onNoClick
                )
            }
        )
    }
}

@Composable
fun CustomDeleteDialogUi(
    onYesClick: () -> Unit,
    onNoClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Colors.White),
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Colors.Black)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Want to move a file to the trash?",
                color = Colors.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Icon(
                modifier = Modifier.size(128.dp),
                painter = painterResource(
                    resource = Res.drawable.round_delete_outline_24
                ),
                contentDescription = null,
                tint = Colors.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                FButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onNoClick()
                    },
                    content = {
                        Text(
                            text = "No",
                            color = Colors.White
                        )
                    }
                )

                Spacer(modifier = Modifier.width(20.dp))

                FButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onYesClick()
                    },
                    content = {
                        Text(
                            text = "Yes",
                            color = Colors.White
                        )
                    }
                )
            }
        }
    }
}