package com.bemos.filedrop.di.platform

import java.net.URI

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class PlatformUri(
    private val uri: URI
) {
    actual fun getUri(): String {
        return uri.toString()
    }
}