package com.project.starbucks_app.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.starbucks_app.view.fragment.home.HomeBakeryFragment
import com.project.starbucks_app.view.fragment.home.HomeBeverageFragment
import com.project.starbucks_app.view.fragment.home.HomeCoffeeFragment
import com.project.starbucks_app.view.fragment.home.HomeGiftFragment

class HomeVPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int = AUDIO_TAB_ITEM

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> {
                return HomeCoffeeFragment()
            }
            1 -> {
                return HomeBeverageFragment()
            }
            2 -> {
                return HomeBakeryFragment()
            }
            else -> {
                return HomeGiftFragment()
            }
        }
    }


    companion object{
        const val AUDIO_TAB_ITEM = 4
    }
}