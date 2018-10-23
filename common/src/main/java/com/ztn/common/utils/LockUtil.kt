package com.ztn.common.utils

/**
 * Created by 冒险者ztn on 2018/8/29.
 * 同步
 */

inline fun <T> Any.lock(body: () -> T): T {
    synchronized(this) {
        return body()
    }
}

fun Any.notify() {
    val `object` = this as Object
    `object`.notify()
}

fun Any.notifyAll() {
    val `object` = this as Object
    `object`.notifyAll()
}

fun Any.wait(long: Long = 0) {
    val `object` = this as Object
    `object`.wait(long)
}
