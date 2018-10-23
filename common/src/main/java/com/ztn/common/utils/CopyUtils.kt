package com.ztn.common.utils

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by 冒险者ztn on 2018/9/6.
 * Parcelable 类型深度拷贝
 */

fun Parcelable.deepCopy(): Parcelable {
    var parcel: Parcel? = null

    try {
        parcel = Parcel.obtain()
        parcel!!.writeParcelable(this, 0)

        parcel.setDataPosition(0)
        return parcel.readParcelable<Parcelable>(javaClass.classLoader)
    } finally {
        parcel?.recycle()
    }
}