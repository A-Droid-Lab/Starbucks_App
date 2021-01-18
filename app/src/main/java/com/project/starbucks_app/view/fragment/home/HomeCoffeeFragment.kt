package com.project.starbucks_app.view.fragment.home

import android.util.Log
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeCoffeeBinding
import com.project.starbucks_app.view.adapter.HomeMenuAdapter
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.MenuViewModel


class HomeCoffeeFragment : BaseFragment<MenuViewModel, FragmentHomeCoffeeBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeCoffeeFragment()
    }

    private val menuAdapter = HomeMenuAdapter()

    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home_coffee

    override fun beforeViewCreated() {
        viewModel.getCoffeeMenu()
        viewModel.getFrapuccinoMenu()
        viewModel.getBlendedMenu()
    }

    override fun afterViewCreated() {
        initCoffeeMenu()
        initFrapuccino()
        initBlended()
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

    private fun initBlended(){
        dataBinding.rcvMainBlended.apply {
            adapter = menuAdapter
            setHasFixedSize(true)
        }
        viewModel.blendedLiveData.observe(viewLifecycleOwner){
            it.forEach {t ->
                Log.d("블렌디드 ", t.name)
            }
            menuAdapter.setItem(it)
        }
    }

}