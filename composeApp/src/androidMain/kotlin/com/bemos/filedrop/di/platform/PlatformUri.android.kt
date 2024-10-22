package com.bemos.filedrop.di.platform

import android.net.Uri

actual class PlatformUri(
    private val uri: Uri
) {
    actual fun getUri(): String {
        return uri.toString()
    }
}