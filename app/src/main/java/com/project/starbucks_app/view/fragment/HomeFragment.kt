package com.project.starbucks_app.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeBinding
import com.project.starbucks_app.view.adapter.HomeMenuAdapter
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.MenuViewModel

class HomeFragment : BaseFragment<MenuViewModel, FragmentHomeBinding>() {

    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home

    private val menuAdapter = HomeMenuAdapter()

    override fun beforeViewCreated() {
        viewModel.getCoffeeMenu()
        viewModel.getFrapuccinoMenu()
        viewModel.getBlendedMenu()
    }

    override fun afterViewCreated() {
        initCoffeeMenu()
        initFrapuccino()
    }

    private fun initCoffeeMenu(){
        dataBinding.rcvMainCoffee.apply {
            adapter = menuAdapter
            setHasFixedSize(true)
        }
        viewModel.coffeeLiveData.observe(viewLifecycleOwner){
            it.forEach {t ->
                Log.d("ㅋㅓ피 ", t.name)
            }
            menuAdapter.setItem(it)
        }
    }

    private fun initFrapuccino(){
        dataBinding.rcvMainFrapuccino.apply {
            adapter = menuAdapter
            setHasFixedSize(true)
        }
        viewModel.frapuccinoLiveData.observe(viewLifecycleOwner){
            it.forEach {t ->
                Log.d("프라푸치노 ", t.name)
            }
            menuAdapter.setItem(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}