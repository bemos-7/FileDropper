package com.bemos.filedrop.screens.util.theme.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.pixelfyfont
import org.jetbrains.compose.resources.Font

object Fonts {
    @Composable
    fun GetPixelFyFont() = FontFamily(Font(Res.font.pixelfyfont))
}