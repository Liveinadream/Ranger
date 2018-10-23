package com.ztn.common.framework

import android.app.Application

/**
 * Created by 冒险者ztn on 2018/8/7.
 * application
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //出事化一个全局的 context
        AppManager.context = this


    }

}