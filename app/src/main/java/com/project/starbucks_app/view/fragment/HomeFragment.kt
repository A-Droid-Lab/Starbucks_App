package com.project.starbucks_app.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeBinding
import com.project.starbucks_app.view.adapter.HomeMenuAdapter
import com.project.starbucks_app.view.adapter.HomeVPAdapter
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.MenuViewModel

class HomeFragment : BaseFragment<MenuViewModel, FragmentHomeBinding>() {

    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun beforeViewCreated() {
        initTab()
    }

    override fun afterViewCreated() {
    }

    private fun initTab(){
        dataBinding.vpMenuFragment.apply {
            adapter = HomeVPAdapter(requireActivity())
            currentItem = 0
            offscreenPageLimit = 4
            isUserInputEnabled = false
        }
        TabLayoutMediator(dataBinding.tbMenu, dataBinding.vpMenuFragment){ tab: TabLayout.Tab, position: Int ->
            tab.customView = setItem(position)
        }.attach()
    }

    private fun setItem(position: Int) : View{
        val maptabView = LayoutInflater.from(requireContext()).inflate(R.layout.item_tab, null)
        val tv_tab_item = maptabView.findViewById<TextView>(R.id.tv_tab_item)
        maptabView.apply {
            tv_tab_item.apply {
                textSize = 14.0f
                setBackgroundColor(resources.getColor(R.color.grayscale_100_white))
                setTextColor(resources.getColor(R.color.grayscale_700))
            }
        }
        return when (position) {
            0 -> {
                tv_tab_item.text = getString(R.string.coffee)
                maptabView
            }
            1 -> {
                tv_tab_item.text = getString(R.string.beverage)
                maptabView
            }
            2 -> {
                tv_tab_item.text = getString(R.string.bakery)
                maptabView
            }
            else -> {
                tv_tab_item.text = getString(R.string.gift)
                maptabView
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}