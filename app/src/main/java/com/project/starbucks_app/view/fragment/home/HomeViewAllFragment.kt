package com.project.starbucks_app.view.fragment.home

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.lottie.LottieDrawable
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.FragmentHomeViewAllBinding
import com.project.starbucks_app.util.transactAnimate
import com.project.starbucks_app.util.transactSwipe
import com.project.starbucks_app.view.adapter.ViewAllMenuAdapter
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.CoffeeViewModel

class HomeViewAllFragment : BaseFragment<CoffeeViewModel, FragmentHomeViewAllBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeViewAllFragment()
    }

    private val viewAllAdapter = ViewAllMenuAdapter()

    override fun getViewModel(): Class<CoffeeViewModel> = CoffeeViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_home_view_all

    override fun beforeViewCreated() {
        dataBinding.lavCoffee.apply {
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
        viewModel.getAllCoffeeMenu()
        dataBinding.rcvViewAll.apply {
            layoutManager = GridLayoutManager(context,3).apply {
                GridLayoutManager.HORIZONTAL
            }
            adapter = viewAllAdapter
        }
    }

    override fun afterViewCreated() {
        viewModel.allCoffeeMenuLiveData.observe(viewLifecycleOwner){
            viewAllAdapter.setItem(it)
            dataBinding.lavCoffee.visibility = View.GONE
        }
        viewAllAdapter.setOnItemClickListener { view, item ->
            fragmentManager?.transactAnimate(view,item)
        }
    }
}