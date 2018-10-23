package com.ztn.ranger

import android.app.Application
import com.ztn.common.framework.AppManager

/**
 * Created by 冒险者ztn on 2018/10/23.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppManager.context = this
    }
}