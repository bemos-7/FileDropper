package com.bemos.filedrop.screens.util.theme.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bemos.filedrop.screens.util.theme.Colors

@Composable
fun FButton(
    modifier: Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier,
        border = BorderStroke(1.dp, Colors.White),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Colors.Light_Black),
        shape = RoundedCornerShape(15.dp),
        onClick = {
            onClick()
        }
    ) {
        content()
    }
}