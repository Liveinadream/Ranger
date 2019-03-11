package com.ztn.common.utils.animation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.view.View
import com.ztn.common.R

/**
 * Created by 冒险者ztn on 2018/8/20.
 * 界面跳转拓展方法
 */
class SceneChangeExtensions {
    companion object {
        var entryAnim = R.anim.left_in
        var exitAnim = R.anim.left_out
    }
}

fun Activity.viewClick(
    v: View,
    intent: Intent,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    val startX = v.width / 2
    val startY = v.height / 2
    val bundle = ActivityOptionsCompat.makeScaleUpAnimation(v, startX, startY, 0, 0).toBundle()
    ActivityCompat.startActivity(this, intent, bundle)
    overridePendingTransition(start, end)
}

fun Activity.viewClick(
    cls: Class<*>,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    val intent = Intent(this, cls)
    ActivityCompat.startActivity(this, intent, null)
    overridePendingTransition(start, end)
}

fun Activity.viewClick(
    intent: Intent,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    ActivityCompat.startActivity(this, intent, null)
    overridePendingTransition(start, end)
}

fun Activity.viewClick(
    intent: Intent,
    requestCode: Int,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    ActivityCompat.startActivityForResult(this, intent, requestCode, null)
    overridePendingTransition(start, end)
}

fun Fragment.viewClick(
    v: View,
    intent: Intent,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    val startX = v.width / 2
    val startY = v.height / 2
    val bundle = ActivityOptionsCompat.makeScaleUpAnimation(v, startX, startY, 0, 0).toBundle()
    activity?.let {
        ActivityCompat.startActivity(it, intent, bundle)
        it.overridePendingTransition(start, end)
    }
}

fun Fragment.viewClick(
    cls: Class<*>,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    activity?.let {
        val intent = Intent(it, cls)
        ActivityCompat.startActivity(it, intent, null)
        it.overridePendingTransition(start, end)
    }
}

fun Fragment.viewClick(
    intent: Intent,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    activity?.let {
        ActivityCompat.startActivity(it, intent, null)
        it.overridePendingTransition(start, end)
    }
}

fun Fragment.viewClick(
    intent: Intent,
    requestCode: Int,
    start: Int = SceneChangeExtensions.entryAnim,
    end: Int = SceneChangeExtensions.exitAnim
) {
    activity?.let {
        ActivityCompat.startActivityForResult(it, intent, requestCode, null)
        it.overridePendingTransition(start, end)
    }
}

fun Context.viewClick(intent: Intent) {
    ActivityCompat.startActivity(this, intent, null)
}


inline fun <reified F : Fragment> Context.newFragment(vararg args: Pair<String, String>): F {
    val bundle = Bundle()
    args.let {
        for (arg in args) {
            bundle.putString(arg.first, arg.second)
        }
    }
    return Fragment.instantiate(this, F::class.java.name, bundle) as F
}

