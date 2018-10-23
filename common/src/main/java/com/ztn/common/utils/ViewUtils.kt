package com.ztn.common.utils

import android.view.View

/**
 * Created by 冒险者ztn on 2018/10/22.
 * view 拓展方法
 */
fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}