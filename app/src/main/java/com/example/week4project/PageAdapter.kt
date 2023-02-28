package com.example.week4project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return Image1Fragment()
            1 -> return Image3Fragment()
            2 -> return Image2Fragment()
            else -> return Image1Fragment()
        }
    }

}





