package com.project.starbucks_app.view.fragment.home

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.transition.TransitionInflater
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeCoffeeBinding
import com.project.starbucks_app.util.ViewType.Companion.BLENDED
import com.project.starbucks_app.util.ViewType.Companion.COFFEE
import com.project.starbucks_app.util.ViewType.Companion.FRAPUCCINO
import com.project.starbucks_app.view.adapter.CoffeeMenuAdapter
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.fragment.detail.DetailFragment
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
        exitTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.fade)
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
        coffeeAdapter.setOnItemClickListener {item, view, ivName ->
            fragmentManager.let {
                it!!.beginTransaction()
                    .addSharedElement(view, ivName)
                    .replace(R.id.container, DetailFragment.newInstance(item))
                    .addToBackStack("icon_android")
                    .commit()
            }
            Log.d("고유값 !? :: ", ivName)
        }

        frapuccinoAdapter.setOnItemClickListener {item, view, ivName ->
            fragmentManager.let {
                it!!.beginTransaction()
                    .addSharedElement(view, ivName)
                    .replace(R.id.container, DetailFragment.newInstance(item))
                    .addToBackStack("icon_android")
                    .commit()
            }
            Log.d("고유값 !? :: ", ivName)
        }

        blendedAdapter.setOnItemClickListener {item, view, ivName ->
            fragmentManager.let {
                it!!.beginTransaction()
                    .addSharedElement(view, ivName)
                    .replace(R.id.container, DetailFragment.newInstance(item))
                    .addToBackStack("icon_android")
                    .commit()
            }
            Log.d("고유값 !? :: ", ivName)
        }
    }

}