package com.ztn.common.utils.animation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.view.View
import com.ztn.common.R

/**
 * Created by 冒险者ztn on 2018/8/20.
 * 界面跳转拓展方法
 */

fun Activity.viewClick(v: View, intent: Intent, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    val startX = v.width / 2
    val startY = v.height / 2
    val bundle = ActivityOptionsCompat.makeScaleUpAnimation(v, startX, startY, 0, 0).toBundle()
    ActivityCompat.startActivity(this, intent, bundle)
   overridePendingTransition(start, end)
}

fun Activity.viewClick(cls: Class<*>, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    val intent = Intent(this, cls)
    ActivityCompat.startActivity(this, intent, null)
    overridePendingTransition(start, end)
}

fun Activity.viewClick(intent: Intent, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    ActivityCompat.startActivity(this, intent, null)
    overridePendingTransition(R.anim.slide_pop_in, R.anim.slide_pop_out)
}

fun Activity.viewClick(intent: Intent, requestCode: Int, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    ActivityCompat.startActivityForResult(this, intent, requestCode, null)
    overridePendingTransition(start, end)
}

fun Fragment.viewClick(v: View, intent: Intent, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    val startX = v.width / 2
    val startY = v.height / 2
    val bundle = ActivityOptionsCompat.makeScaleUpAnimation(v, startX, startY, 0, 0).toBundle()
    activity?.let {
        ActivityCompat.startActivity(it, intent, bundle)
        it.overridePendingTransition(start, end)
    }
}

fun Fragment.viewClick(cls: Class<*>, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    activity?.let {
        val intent = Intent(it, cls)
        ActivityCompat.startActivity(it, intent, null)
        it.overridePendingTransition(start, end)
    }
}

fun Fragment.viewClick(intent: Intent, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    activity?.let {
        ActivityCompat.startActivity(it, intent, null)
        it.overridePendingTransition(start, end)
    }
}

fun Fragment.viewClick(intent: Intent, requestCode: Int, start: Int = R.anim.slide_pop_in, end: Int = R.anim.slide_pop_out) {
    activity?.let {
        ActivityCompat.startActivityForResult(it, intent, requestCode, null)
        it.overridePendingTransition(start, end)
    }
}

fun Context.viewClick(intent: Intent) {
    ActivityCompat.startActivity(this, intent, null)
}


