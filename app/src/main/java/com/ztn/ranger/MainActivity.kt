package com.ztn.ranger

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.ztn.common.DelegatesExt
import com.ztn.common.ToastHelper
import com.ztn.common.customs.CustomProgressDialog
import com.ztn.common.utils.*
import com.ztn.common.utils.animation.viewClick
import com.ztn.common.utils.wayutils.DialogUtils
import com.ztn.common.version.supportsM
import com.ztn.common.version.supportsO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private var aa: ArrayList<String> by DelegatesExt.notNullSingleValue()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        aa = ArrayList()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        Thread {
            ToastHelper.showToast("创建了一个activity")
        }.start()

        1f.dip2px.show("单位转换")
        8.sp2px.show("单位转换")

        getVersionName().show("版本名")
        getVersionCode().show("版本code")

        val email = "1458369273@qq.com"
        email.isEmail.show("是否是邮箱")
        val phone = "18304011507"
        phone.isPhoneNumber.show("是否是手机号")

        log("我是一个简单的日志")
        commonTag = "滴滴滴"
        log("我是另一个简单的日志")

        getMonthFristDate().show("当月日期")

        val num = "5.44445"
        num.getNum(3).show("获取到的小数")
        num.getNum(4).show("获取到的小数")
        num.getNum(8).show("获取到的小数")

        createDialog.setOnClickListener {
            DialogUtils.creat(this@MainActivity, false, "!(*^*)!")
        }

        CustomProgressDialog(this)

        message.setOnClickListener {
            viewClick(MainActivity::class.java)
        }

        supportsO {
            print("这个机器在O以上")
        }

        supportsM {
            print("这个机器在M以上")
        }

        try {
            aa = ArrayList()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}

