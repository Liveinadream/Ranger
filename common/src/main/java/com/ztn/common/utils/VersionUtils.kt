package com.ztn.common.utils

import com.ztn.common.framework.AppManager

/**
 * Created by 冒险者ztn on 2018/8/7.
 * 获取版本
 */
/**
 * 获取版本名称
 *
 * @return
 * @throws Exception
 */
@Throws(Exception::class)
fun getVersionName(): String {
    // 获取 packageManager 的实例
    val packageManager = AppManager.context.packageManager
    // getPackageName()是你当前类的包名，0代表是获取版本信息
    val packInfo = packageManager.getPackageInfo(AppManager.context.packageName, 0)
    return packInfo.versionName
}

/**
 * 获取版本码
 *
 * @return
 * @throws Exception
 */
@Throws(Exception::class)
fun getVersionCode(): Int {
    // 获取 packageManager 的实例
    val packageManager = AppManager.context.packageManager
    // getPackageName()是你当前类的包名，0代表是获取版本信息
    val packInfo = packageManager.getPackageInfo(AppManager.context.packageName, 0)
    return packInfo.versionCode
}
