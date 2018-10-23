package com.ztn.common.utils

import com.ztn.common.framework.AppManager

/**
 * Created by 冒险者ztn on 2018/8/7.
 * 数字间单位转化的拓展属性
 */

//dp 转 px
val Int.dip2px: Float
    get() = this * AppManager.context.resources.displayMetrics.density + 0.5f

val Float.dip2px: Float
    get() = this * AppManager.context.resources.displayMetrics.density + 0.5f

val Double.dip2px: Float
    get() = (this * AppManager.context.resources.displayMetrics.density + 0.5f).toFloat()

//px 转 dp
val Int.px2dp: Float
    get() = this / AppManager.context.resources.displayMetrics.density + 0.5f

val Float.px2dp: Float
    get() = this / AppManager.context.resources.displayMetrics.density + 0.5f

val Double.px2dp: Float
    get() = ((this / AppManager.context.resources.displayMetrics.density + 0.5f).toFloat())

//px 转 sp
val Int.px2sp: Float
    get() = this / AppManager.context.resources.displayMetrics.scaledDensity + 0.5f


val Float.px2sp: Float
    get() = this / AppManager.context.resources.displayMetrics.scaledDensity + 0.5f


val Double.px2sp: Float
    get() = ((this / AppManager.context.resources.displayMetrics.scaledDensity + 0.5f).toFloat())

//sp 转 px
val Int.sp2px: Float
    get() = (this * AppManager.context.resources.displayMetrics.scaledDensity + 0.5f)

val Float.sp2px: Float
    get() = (this * AppManager.context.resources.displayMetrics.scaledDensity + 0.5f)

val Double.sp2px: Float
    get () = (this * AppManager.context.resources.displayMetrics.scaledDensity + 0.5f).toFloat()



