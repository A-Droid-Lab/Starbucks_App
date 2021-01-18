package com.project.starbucks_app.view.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeBeverageBinding
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.MenuViewModel

class HomeBeverageFragment : BaseFragment<MenuViewModel,FragmentHomeBeverageBinding>() {


    companion object {
        @JvmStatic
        fun newInstance() = HomeBeverageFragment()
    }

    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home_beverage

    override fun beforeViewCreated() {
    }

    override fun afterViewCreated() {
    }


}