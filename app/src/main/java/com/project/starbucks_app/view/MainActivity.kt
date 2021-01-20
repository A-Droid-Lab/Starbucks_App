package com.project.starbucks_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.project.starbucks_app.R
import com.project.starbucks_app.databinding.ActivityMainBinding
import com.project.starbucks_app.util.transact
import com.project.starbucks_app.view.base.BaseActivity
import com.project.starbucks_app.view.fragment.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(HomeFragment.newInstance())
    }

    fun replaceFragment(fragment : Fragment){
        supportFragmentManager.transact {
            replace(R.id.container, fragment).addToBackStack(fragment.tag)
        }
    }

    fun replaceElement(fragment: Fragment){
        supportFragmentManager.transact {
            replace(R.id.container, fragment).addToBackStack(fragment.tag)
        }
    }
}