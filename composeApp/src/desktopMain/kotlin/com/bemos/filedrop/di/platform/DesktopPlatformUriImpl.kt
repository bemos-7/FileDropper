package com.bemos.filedrop.di.platform

class DesktopPlatformUriImpl(
    private val uri: String
) : PlatformUriRepository {
    override fun getUri(): String {
        return uri
    }

}