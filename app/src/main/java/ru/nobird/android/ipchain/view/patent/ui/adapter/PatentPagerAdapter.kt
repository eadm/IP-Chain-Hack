package ru.nobird.android.ipchain.view.patent.ui.adapter

import android.support.annotation.LayoutRes
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nobird.android.ipchain.R

class PatentPagerAdapter : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, index: Int): Any {
        @LayoutRes
        val layoutRes =
            when(index) {
                0 -> R.layout.view_patent_tab_1
                1 -> R.layout.view_patent_tab_2
                2 -> R.layout.view_patent_tab_3
                else -> R.layout.view_patent_tab_1
            }

        val v = LayoutInflater.from(container.context).inflate(layoutRes, container, false)
        container.addView(v)
        v.tag = index
        return v
    }

    override fun destroyItem(container: ViewGroup, pos: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int = 3
}