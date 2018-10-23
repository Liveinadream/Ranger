package com.ztn.common.utils

import android.util.Log

fun log(content: Any?) {
    Log.d("ztn", "$content")
}

fun <T> T.show(varName: String): T {
    log("$varName = $this")
    return this
}