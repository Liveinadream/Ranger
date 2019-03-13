package com.ztn.common

import android.content.Context
import android.os.Looper
import android.widget.Toast
import com.ztn.common.framework.AppManager

/**
 * Created by 冒险者ztn on 2017/11/15.
 * toast帮助类
 */
object ToastHelper {

    private var mToast: Toast? = null

    val currentContext: Context
        get() = AppManager.get().currentContext()

    fun getToast(resId: Int): Toast {
        return Toast.makeText(currentContext, resId, Toast.LENGTH_SHORT)
    }

    fun getToast(text: String): Toast {
        return Toast.makeText(currentContext, text, Toast.LENGTH_SHORT)
    }

    fun getLongToast(resId: Int): Toast {
        return Toast.makeText(currentContext, resId, Toast.LENGTH_LONG)
    }

    fun getLongToast(text: String): Toast {
        return Toast.makeText(currentContext, text, Toast.LENGTH_LONG)
    }

    fun getSingletonToast(resId: Int): Toast {
        if (mToast == null) {
            mToast = getToast(resId)
        } else {
            mToast!!.setText(resId)
        }
        return mToast as Toast
    }

    fun getSingletonToast(text: String): Toast {
        if (mToast == null) {
            mToast = getToast(text)
        } else {
            mToast!!.setText(text)
        }
        return mToast as Toast
    }

    fun getSingleLongToast(resId: Int): Toast {
        if (mToast == null) {
            mToast = getLongToast(resId)
        } else {
            mToast!!.setText(resId)
        }
        return mToast as Toast
    }

    fun getSingleLongToast(text: String): Toast {
        if (mToast == null) {
            mToast = getLongToast(text)
        } else {
            mToast!!.setText(text)
        }
        return mToast as Toast
    }


    fun showSingletonToast(resId: Int) {
        getSingletonToast(resId).show()
    }


    fun showSingletonToast(text: String) {
        getSingletonToast(text).show()
    }

    fun showSingleLongToast(resId: Int) {
        getSingleLongToast(resId).show()
    }


    @JvmStatic
    fun showSingleLongToast(text: String) {
        getSingleLongToast(text).show()
    }

    fun showToast(resId: Int) {
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            Looper.prepare()
            getToast(resId).show()
            Looper.loop()
        } else {
            getToast(resId).show()
        }
    }

    fun showToast(text: String) {
        val toast = ToastHelper.getToast("")
        toast.setText(text)
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            Looper.prepare()
            toast.show()
            Looper.loop()
        } else {
            toast.show()
        }
    }

    fun showLongToast(resId: Int) {
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            Looper.prepare()
            getLongToast(resId).show()
            Looper.loop()
        } else {
            getLongToast(resId).show()

        }
    }

    fun showLongToast(text: String) {
        val toast = ToastHelper.getLongToast("")
        toast.setText(text)
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            Looper.prepare()
            toast.show()
            Looper.loop()
        } else {
            toast.show()
        }
    }
}
