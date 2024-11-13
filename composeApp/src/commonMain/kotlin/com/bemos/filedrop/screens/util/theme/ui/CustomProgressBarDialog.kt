package com.bemos.filedrop.screens.util.theme.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bemos.filedrop.screens.util.theme.Colors

@Composable
fun CustomProgressBarDialog(openDialogCustom: Boolean) {
    if (openDialogCustom) {
        Dialog(
            onDismissRequest = {}
        ) {
            CustomDialogUi()
        }
    }
}

@Composable
fun CustomDialogUi() {
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
            CircularProgressIndicator(
                modifier = Modifier.size(64.dp),
                strokeWidth = 8.dp,
                color = Color.White
            )
        }
    }
}