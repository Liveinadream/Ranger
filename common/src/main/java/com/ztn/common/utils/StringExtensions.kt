package com.ztn.common.utils

import java.util.regex.Pattern

/**
 * Created by 冒险者ztn on 2018/8/7.
 * string 的拓展属性
 */


val String.isEmail: Boolean
    get() {
        val pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }

val String.isPhoneNumber: Boolean
    get() {
        val p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")
        val m = p.matcher(this)
        return m.matches()
    }

