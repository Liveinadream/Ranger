package com.ztn.common.framework

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import java.util.*

/**
 * Created by 冒险者ztn on 2018/8/7.
 * activity管理类
 */
class AppManager private constructor() {

    // 退出栈顶Activity,即结束指定的Activity
    @Synchronized
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activity.finish()
            removeActivity(activity)
        }
    }

    @Synchronized
    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            if (activityStack!!.contains(activity)) {
                activityStack!!.remove(activity)
            }
        }
    }

    // 获得当前栈顶Activity
    @Synchronized
    fun currentActivity(): Activity? {
        var activity: Activity? = null
        if (activityStack != null && activityStack!!.size != 0) {
            activity = activityStack!!.lastElement()
        }
        return activity
    }

    fun currentContext(): Context {
        return context
    }

    // 将当前Activity推入栈中
    @Synchronized
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack!!.add(activity)
    }

    // 除了某个Activity,退出栈中其它所有Activity
    @Synchronized
    fun popAllActivityExceptOne(cls: Class<*>?) {
        if (null == activityStack || activityStack!!.size == 0) {
            return
        }
        val len = activityStack!!.size
        for (i in len - 1 downTo 0) {
            val activity = activityStack!![i]
            if (activity == null || null != cls && activity.javaClass == cls) {
                continue
            }
            finishActivity(activity)
        }
    }

    // 退出栈中当前Activity
    @Synchronized
    fun popUpActivity(cls: Class<*>) {
        if (null == activityStack || activityStack!!.size == 0) {
            return
        }
        val len = activityStack!!.size
        for (i in len - 1 downTo 0) {
            val activity = activityStack!![i] ?: continue
            if (activity.javaClass == cls) {
                finishActivity(activity)
                break
            }
        }
    }

    /**
     * 结束所有activity
     */
    @Synchronized
    fun finishAllActivities() {
        for (activity in activityStack!!) {
            activity.finish()
        }
        activityStack!!.clear()
    }

    companion object {

        var activityStack: Stack<Activity>? = null

        //全局Context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun get(): AppManager {
            return Inner.appManager
        }

        private object Inner{
            @SuppressLint("StaticFieldLeak")
            val appManager = AppManager()
        }
    }
}