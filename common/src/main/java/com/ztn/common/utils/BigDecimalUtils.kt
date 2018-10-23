package com.ztn.common.utils

import java.math.BigDecimal

/**
 * Created by 冒险者ztn on 2018/8/7.
 * 保留小数点后几位小数
 */

fun String.getNum(position: Int): BigDecimal {
    var bd = BigDecimal(this)
    bd = bd.setScale(position, BigDecimal.ROUND_HALF_UP)
    return bd
}

