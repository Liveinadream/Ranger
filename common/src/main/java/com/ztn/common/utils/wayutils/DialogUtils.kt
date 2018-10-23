package com.ztn.common.utils.wayutils

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import com.ztn.common.R
import com.ztn.common.customs.CustomProgressDialog

/**
 * Created by 冒险者ztn on 2018/8/20.
 * 进度提示弹出
 */
class DialogUtils {
    companion object {
        fun creat(context: Context, message: String): ProgressDialog {
            return creat(context, ProgressDialog.STYLE_SPINNER, message, null, -1, true, null)
        }

        fun creat(context: Context, message: String, onCancelListener: DialogInterface.OnCancelListener): ProgressDialog {
            return creat(context, ProgressDialog.STYLE_SPINNER, message, null, -1, true, onCancelListener)
        }


        fun creat(context: Context, isOutCancel: Boolean, message: String): CustomProgressDialog {
            val mypDialog = CustomProgressDialog(context, R.style.Dialog2, message)//实例化
            mypDialog.setCancelable(true)//设置ProgressDialog 是否可以按退回按键取消
            mypDialog.setCanceledOnTouchOutside(isOutCancel)
            mypDialog.show()//让ProgressDialog显示
            return mypDialog
        }

        fun creat(context: Context, isOutCancel: Boolean): CustomProgressDialog {
            val mypDialog = CustomProgressDialog(context, R.style.Dialog2)//实例化
            mypDialog.setCancelable(true)//设置ProgressDialog 是否可以按退回按键取消
            mypDialog.setCanceledOnTouchOutside(isOutCancel)
            mypDialog.show()//让ProgressDialog显示
            return mypDialog
        }

        fun creat(context: Context, style: Int, message: String, title: String?, iconid: Int, isCancel: Boolean, onCancelListener: DialogInterface.OnCancelListener?): ProgressDialog {
            val mypDialog = ProgressDialog(context)//实例化
            mypDialog.setProgressStyle(style)//设置进度条风格，风格为圆形，旋转的
            mypDialog.setMessage(message)//设置ProgressDialog 提示信息
            mypDialog.isIndeterminate = false//设置ProgressDialog 的进度条是否不明确
            mypDialog.setCancelable(isCancel)//设置ProgressDialog 是否可以按退回按键取消

            if (TextUtils.isEmpty(title)) {
                mypDialog.setTitle(title)//设置ProgressDialog 标题
            }
            if (iconid > 0) {
                mypDialog.setIcon(iconid)
            }

            if (onCancelListener != null) {
                mypDialog.setOnCancelListener(onCancelListener)
            }
            mypDialog.show()//让ProgressDialog显示
            return mypDialog
        }

        fun show(context: Context, title: String, message: String, on: String, positiveOnClickListener: DialogInterface.OnClickListener): AlertDialog {
            return show(context, title, message, on, "取消", positiveOnClickListener, null)
        }

        fun show(context: Context, message: String): AlertDialog {
            return show(context, null, message, "确定", null, null, null)
        }

        fun show(context: Context, message: String, positiveOnClickListener: DialogInterface.OnClickListener): AlertDialog {
            return show(context, null, message, "确定", null, positiveOnClickListener, null)
        }

        fun show(context: Context, title: String, message: String): AlertDialog {
            return show(context, title, message, "确定", null, null, null)
        }

        fun show(context: Context, title: String, on: String, positiveOnClickListener: DialogInterface.OnClickListener): AlertDialog {
            return show(context, title, null, on, "取消", positiveOnClickListener, null)
        }

        fun show(context: Context, title: String?, message: String?, on: String, off: String?, positiveOnClickListener: DialogInterface.OnClickListener?, negativeOnClickListener: DialogInterface.OnClickListener?): AlertDialog {
            val builder = AlertDialog.Builder(context)
            if (!TextUtils.isEmpty(title)) {
                builder.setTitle(title)
            }

            if (!TextUtils.isEmpty(message)) {
                builder.setMessage(message)
            }

            if (!TextUtils.isEmpty(on)) {
                builder.setPositiveButton(on, positiveOnClickListener)
            }

            if (!TextUtils.isEmpty(off)) {
                builder.setNegativeButton(off, negativeOnClickListener)
            }

            return builder.show()
        }

        fun show(context: Context, title: String, items: Array<String>, onClickListener: DialogInterface.OnClickListener): AlertDialog {
            val builder = AlertDialog.Builder(context)
            if (!TextUtils.isEmpty(title)) {
                builder.setTitle(title)
            }

            if (items.isNotEmpty()) {
                builder.setItems(items, onClickListener)
            }

            return builder.show()
        }
    }
}