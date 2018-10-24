package com.ztn.common.utils

import android.content.Intent
import android.net.Uri
import com.ztn.common.framework.AppManager

/**
 * Created by 冒险者ztn on 2018/8/7.
 * 打电话
 */
class CallPhoneUtils {

    companion object {
        fun startCallPhone(phone: String) {
            //you should requestPermission by yourself
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            phoneIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            AppManager.context.startActivity(phoneIntent)
        }
    }
}