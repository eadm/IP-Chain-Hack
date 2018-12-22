package ru.nobird.android.ipchain.view.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class NoScrollViewPager
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean =
        false

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean =
        false

    override fun canScrollHorizontally(direction: Int): Boolean =
        false
}