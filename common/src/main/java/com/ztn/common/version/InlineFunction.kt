package com.ztn.common.version

import android.os.Build

/**
 * Created by 冒险者ztn on 2018/11/6.
 * 在高于某个版本的机器上执行某段代码
 */


inline fun supportsLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}

inline fun supportsLollipopMr(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
        code()
    }
}

inline fun supportsM(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        code()
    }
}

inline fun supportsN(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        code()
    }
}

inline fun supportsNMR(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
        code()
    }
}

inline fun supportsO(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        code()
    }
}