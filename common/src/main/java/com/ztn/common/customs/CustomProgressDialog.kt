package com.ztn.common.customs

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.TextView
import com.ztn.common.R

/**
 * Created by 冒险者ztn on 2018/8/20.
 * 自定义进度
 */
class CustomProgressDialog(context: Context, themeResId: Int = 0, message: String? = null) : Dialog(context, themeResId) {
    init {
        setContentView(R.layout.x_progressdialog_custom_view)
        val textView = findViewById<View>(R.id.x_progress_tv_message) as TextView
        message?.let {
            textView.text = it
        }
    }

    fun destroy() {
        if (isShowing) {
            cancel()
        }
    }
}
