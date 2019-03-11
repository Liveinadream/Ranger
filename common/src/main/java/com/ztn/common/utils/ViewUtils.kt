package com.ztn.common.utils

import android.graphics.Bitmap
import android.graphics.Canvas
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

val View.bitmap: Bitmap
    get() {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        val canvas = Canvas(bitmap)
        layout(left, top, right, bottom)
        val drawable = background
        drawable.draw(canvas)
        draw(canvas)

        return bitmap
    }


