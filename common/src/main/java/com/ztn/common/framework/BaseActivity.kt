package com.ztn.common.framework

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by 冒险者ztn on 2018/8/7.
 * activity 基类
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.get().addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.get().removeActivity(this)
    }

    /**
     * 使用应用本身字体
     */
    override fun getResources(): Resources {
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        createConfigurationContext(config)
        res.updateConfiguration(config, res.displayMetrics)
        return res

    }

    //TODO updateConfiguration 方法已过期，是否使用以下方法，有待测试
//    override fun getBaseContext(): Context {
//        val config = Configuration()
//        config.setToDefaults()
//        createConfigurationContext(config)
//        return super.getBaseContext()
//    }

}