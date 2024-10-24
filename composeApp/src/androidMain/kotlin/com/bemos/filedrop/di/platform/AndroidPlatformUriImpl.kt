package com.bemos.filedrop.di.platform

import android.net.Uri


class AndroidPlatformUriImpl(
    private val uri: Uri
) : PlatformUriRepository {
    override fun getUri(): String {
        return uri.toString()
    }
}