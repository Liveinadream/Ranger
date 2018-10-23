package com.ztn.common.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by 冒险者ztn on 2018/8/7.
 * 关于时间的通用方法
 */

/**
 * 获取当前日期
 *
 * @return 当前日期
 */
fun getDate(date: String): String {
    val a = date.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    //        Logger.d("-当前时间-》" + date);
    return a[0] + "-" + Integer.valueOf(a[1]) + "-" + a[2]
}


//根据年月得到月份第一天和最后一天的数组
fun getFirstAndLastDayOfMonth(year: Int, month: Int): ArrayList<String> {
    val str = ArrayList<String>()
    //格式化日期
    val sdf = SimpleDateFormat("yyyyMMdd", Locale.CHINA)
    val cal = Calendar.getInstance()
    //设置年份
    cal.set(Calendar.YEAR, year)
    //设置月份
    cal.set(Calendar.MONTH, month - 1)
    //获取某月最小天数
    val firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH)
    //设置日历中月份的最小天数
    cal.set(Calendar.DAY_OF_MONTH, firstDay)

    str.add(sdf.format(cal.time))

    val cal2 = Calendar.getInstance()
    //设置年份
    cal2.set(Calendar.YEAR, year)
    //设置月份
    cal2.set(Calendar.MONTH, month - 1)
    //获取某月最大天数
    val lastDay = cal2.getActualMaximum(Calendar.DAY_OF_MONTH)
    //设置日历中月份的最大天数
    cal2.set(Calendar.DAY_OF_MONTH, lastDay)
    str.add(sdf.format(cal2.time))
    return str
}

// 将时间戳转换为时间
fun stampToDate(s: String): String {
    val res: String
    val simpleDateFormat = SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA)
    //        HH时mm分ss秒
    val lt: Long = try {
        s.toLong() * 1000
    } catch (e: NumberFormatException) {
        0
    }

    val date = Date(lt)
    res = simpleDateFormat.format(date)
    return res
}

/**
 * 获取过去的时间
 *
 * @param date 过去几天
 * @return 过去的时间
 */
fun getOldTime(date: Int): String {
    val c = Calendar.getInstance() // 当时的日期和时间
    val day: Int//需要改变的天数
    day = c.get(Calendar.DAY_OF_MONTH) - date
    c.set(Calendar.DAY_OF_MONTH, day)
    val mYear = c.get(Calendar.YEAR)
    val mMonth = c.get(Calendar.MONTH)
    val mDay = c.get(Calendar.DAY_OF_MONTH)
    val strForwardDate = StringBuilder().append(mYear).append("-").append(
            if (mMonth + 1 < 10) "0" + (mMonth + 1) else mMonth + 1).append("-").append(
            if (mDay < 10) "0$mDay" else mDay)
    println("strDate------->" + strForwardDate + "-" + c.timeInMillis)
    return getDate(strForwardDate.toString())
}

/**
 * 获取当前时间
 *
 * @return 当前时间
 */
fun getNowTime2(): String {
    val simpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())//可根据不同样式请求显示不同日期格式，要显示星期可以添加E参数
    return simpleDateFormat.format(Date())
}

/**
 * 将当前时间转化为毫秒
 *
 * @param time 毫秒
 * @return 毫秒
 */
fun getNowTime2Long(time: String): Long {
    var nowtime: Long = 0
    val a = time.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (a.size == 3) {
        try {
            val b = java.lang.Long.parseLong(a[0])
            nowtime += b * 60 * 60 * 1000
            val c = java.lang.Long.parseLong(a[1])
            nowtime += c * 60 * 1000
            val d = java.lang.Long.parseLong(a[2])
            nowtime += d * 1000
        } catch (e: ClassCastException) {
            e.printStackTrace()
        } catch (e: ArrayIndexOutOfBoundsException) {
            e.printStackTrace()
        }

    }
    return nowtime
}

/**
 * 获取当前日期
 *
 * @return 当前日期
 */
fun getTodayDate2(): String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())//可根据不同样式请求显示不同日期格式，要显示星期可以添加E参数
    val time = simpleDateFormat.format(Date())

    val a = time.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    //        Logger.d("-当前时间-》" + date);
    return a[0] + "-" + Integer.valueOf(a[1]) + "-" + a[2]
}

/**
 * 获取当月日期
 *
 * @return 当月日期
 */
fun getMonthFristDate(): String {
    val today = getTodayDate2()
    val tadays = today.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

    var year = Integer.parseInt(tadays[0])
    var month = Integer.parseInt(tadays[1])
    val day = Integer.parseInt(tadays[2])

    if (month == 1) {
        year -= 1
        month = 12
    } else if (day == 1) {
        month -= 1
    }


    //        Logger.d(today + "<-初始化时间->" + month);
    return year.toString() + "-" + month + "-1"
}
