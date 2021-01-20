package com.project.starbucks_app.util

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.project.starbucks_app.R
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.view.fragment.detail.DetailFragment
import com.project.starbucks_app.view.fragment.home.HomeViewAllFragment

inline fun FragmentManager.transact(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun FragmentManager.transactAnimate(view : ImageView, item:MenuItem){
    beginTransaction()
            .addSharedElement(view, view.transitionName)
            .replace(R.id.container, DetailFragment.newInstance(item))
            .addToBackStack(null)
            .commit()
}

fun FragmentManager.transactSwipe(item:MenuItem){
    beginTransaction()
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left,R.anim.exit_to_right)
            .replace(R.id.container, DetailFragment.newInstance(item))
            .addToBackStack(null)
            .commit()
}

inline fun <reified T:Fragment> FragmentManager.transactSlide() {
    beginTransaction()
        .setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down)
        .replace(R.id.container, T::class.java.newInstance())
        .addToBackStack(null)
        .commit()
}

//inline fun <reified T : Fragment> transactSlide2() = T::class.java.newInstance()
//R.anim.slide_in_down, R.anim.slide_out_down