package com.ztn.common

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by 冒险者ztn on 2018/11/7.
 * 一个只能被初始化依次的变量
 */
private class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException(
            "${property.name} " +
                    "not initialized"
        )
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}

object DelegatesExt {
    fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}