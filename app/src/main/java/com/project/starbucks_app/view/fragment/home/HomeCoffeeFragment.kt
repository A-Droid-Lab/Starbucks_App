package com.project.starbucks_app.view.fragment.home

import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeCoffeeBinding
import com.project.starbucks_app.util.ViewType.Companion.BLENDED
import com.project.starbucks_app.util.ViewType.Companion.COFFEE
import com.project.starbucks_app.util.ViewType.Companion.FRAPUCCINO
import com.project.starbucks_app.util.transactSlide
import com.project.starbucks_app.util.transactSwipe
import com.project.starbucks_app.view.adapter.CoffeeMenuAdapter
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.CoffeeViewModel


class HomeCoffeeFragment : BaseFragment<CoffeeViewModel, FragmentHomeCoffeeBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeCoffeeFragment()
    }

    private val coffeeAdapter = CoffeeMenuAdapter(COFFEE)
    private val frapuccinoAdapter = CoffeeMenuAdapter(FRAPUCCINO)
    private val blendedAdapter = CoffeeMenuAdapter(BLENDED)

    override fun getViewModel(): Class<CoffeeViewModel> = CoffeeViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home_coffee

    override fun beforeViewCreated(){
        dataBinding.fragment = this
        viewModel.getCoffeeMenu()
        viewModel.getFrapuccinoMenu()
        viewModel.getBlendedMenu()
    }

    override fun afterViewCreated() {
        initObserve()
        initOnClick()
    }

    private fun initObserve(){
        initCoffeeMenu()
        initFrapuccino()
        initBlended()
    }

    private fun initCoffeeMenu(){
        dataBinding.rcvMainCoffee.apply {
            adapter = coffeeAdapter
            setHasFixedSize(true)
        }
        viewModel.coffeeLiveData.observe(viewLifecycleOwner){
            coffeeAdapter.setItem(it)
        }
    }

    private fun initFrapuccino(){
        dataBinding.rcvMainFrapuccino.apply {
            adapter = frapuccinoAdapter
            setHasFixedSize(true)
        }
        viewModel.frapuccinoLiveData.observe(viewLifecycleOwner){
            frapuccinoAdapter.setItem(it)
        }
    }

    private fun initBlended(){
        dataBinding.rcvMainBlended.apply {
            adapter = blendedAdapter
            setHasFixedSize(true)
        }
        viewModel.blendedLiveData.observe(viewLifecycleOwner){
            blendedAdapter.setItem(it)
        }
    }

    private fun initOnClick(){
        coffeeAdapter.setOnItemClickListener {item, view->
            fragmentManager?.transactSwipe(item)
        }

        frapuccinoAdapter.setOnItemClickListener {item, view->
            fragmentManager?.transactSwipe(item)
        }

        blendedAdapter.setOnItemClickListener {item, view->
            fragmentManager?.transactSwipe(item)
        }
    }

    fun onViewAll(){
        fragmentManager?.transactSlide<HomeViewAllFragment>()
    }

}