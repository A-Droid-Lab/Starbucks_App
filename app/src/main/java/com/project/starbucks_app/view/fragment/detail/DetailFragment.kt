package com.project.starbucks_app.view.fragment.detail

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.*
import com.project.starbucks_app.R
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.databinding.FragmentDetailBinding
import com.project.starbucks_app.view.base.BaseFragment
import com.project.starbucks_app.view.vm.MenuViewModel


class DetailFragment : BaseFragment<MenuViewModel, FragmentDetailBinding>() {

    lateinit var data : MenuItem

    companion object {
        @JvmStatic
        fun newInstance(param1: MenuItem) =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_PARAM1, param1)
                    }
                }
        const val ARG_PARAM1 = "param1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {data = it.getParcelable(ARG_PARAM1)!! }
        //postponeEnterTransition()
        //this.sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move).setDuration(100)
    }

    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_detail

    override fun beforeViewCreated() {
        dataBinding.item = data
    }

    override fun afterViewCreated() {
    }


}