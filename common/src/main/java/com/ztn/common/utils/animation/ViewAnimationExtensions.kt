package com.ztn.common.utils.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import com.ztn.common.utils.gone

/**
 * Created by 冒险者ztn on 2018/8/20.
 * view 的动画拓展方法
 */


/**
 * 从控件所在位置移动到控件底部
 */
fun View.moveToViewBottom():TranslateAnimation{
    val mHiddenAction = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            0.0f, Animation.RELATIVE_TO_SELF, 1.0f)
    mHiddenAction.duration = 500
    return mHiddenAction
}

/**
 * 从控件的底部移动到控件所在位置
 */
fun View.moveToViewLocation():TranslateAnimation{
    val mHiddenAction = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            1.0f, Animation.RELATIVE_TO_SELF, 0.0f)
    mHiddenAction.duration = 500
    return mHiddenAction
}

/**
 * 从控件所在位置移动到某个位置
 *
 * 返回这个view
 */
fun View.moveToXY(x: Float, y: Float):View{
    val animX = ObjectAnimator.ofFloat(this, "scaleX", 0.5f, 1f)
    val animXTrans = ObjectAnimator.ofFloat(this, "translationX", this.translationX, x)
    val animY = ObjectAnimator.ofFloat(this, "scaleY", 0.5f, 1f)
    val animYTrans = ObjectAnimator.ofFloat(this, "translationY", this.translationY, y)

    val viewAlpha = ObjectAnimator.ofFloat(this, "alpha", 0.5f, 1f)

    //组合动画
    val animSet = AnimatorSet()

    //回弹效果
    animSet.interpolator = BounceInterpolator()
    animSet.play(animX)
            .with(animXTrans)
            .with(animY)
            .with(animYTrans)
            .with(viewAlpha)

    animSet.duration = 500
    animSet.start()

    return this
}

/**
 * 将view移回原位置，并缩小至不可见
 *
 * 返回这个view
 */
fun View.moveFromXY(): View {

    val animX = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0.1f)
    val animXTrans = ObjectAnimator.ofFloat(this, "translationX", this.translationX, 0f)
    val animY = ObjectAnimator.ofFloat(this, "scaleY", 1f, 0.1f)
    val animYTrans = ObjectAnimator.ofFloat(this, "translationY", this.translationY, 0f)

    val viewAlpha = ObjectAnimator.ofFloat(this, "alpha", 0.5f, 1f)

    //组合动画
    val animSet = AnimatorSet()

    //回弹效果
    animSet.interpolator = BounceInterpolator()
    animSet.play(animX)
            .with(animXTrans)
            .with(animY)
            .with(animYTrans)
            .with(viewAlpha)

    animSet.duration = 500
    animSet.start()
    this.gone()
    return this
}
