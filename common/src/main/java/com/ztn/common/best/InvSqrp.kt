package com.ztn.common.best

/**
 * Created by 冒险者ztn on 2018/12/20.
 * 开根快速算法
 */

fun InvSqrt(m: Float): Float {
    if (m == 0f) {
        return 0f
    }

    var i = 0f
    var x1: Float
    var x2 = 0f
    while (i * i <= m) {
        i += 0.1f
    }
    x1 = i
    for (j in 0..9) {
        x2 = m
        x2 /= x1
        x2 += x1
        x2 /= 2f
        x1 = x2
    }
    return x2
}

fun getFloat(x: Float): Int {
    return ((x % 1) * Math.pow(10.0, 23.0)).toInt()
}