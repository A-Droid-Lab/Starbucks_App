package com.project.starbucks_app.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeBinding
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.MenuViewModel

class HomeFragment : BaseFragment<MenuViewModel, FragmentHomeBinding>() {

    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun beforeViewCreated() {
        viewModel.getCoffeeMenu()
        viewModel.getFrapuccinoMenu()
        viewModel.getBlendedMenu()
    }

    override fun afterViewCreated() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}