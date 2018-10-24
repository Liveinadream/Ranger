package com.ztn.common.utils

import android.util.Log

var commonTag = "commonTag"

fun log(content: Any?, tag: String = commonTag) {
    Log.d(tag, "$content")
}

fun <T> T.show(varName: String): T {
    log("$varName = $this")
    return this
}