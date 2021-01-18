package com.project.starbucks_app.di.builder

import com.project.starbucks_app.view.fragment.HomeFragment
import com.project.starbucks_app.view.fragment.home.HomeBakeryFragment
import com.project.starbucks_app.view.fragment.home.HomeBeverageFragment
import com.project.starbucks_app.view.fragment.home.HomeCoffeeFragment
import com.project.starbucks_app.view.fragment.home.HomeGiftFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeCoffeeFragment() : HomeCoffeeFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeBeverageFragment() : HomeBeverageFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeBakeryFragment() : HomeBakeryFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeGiftFragment() : HomeGiftFragment
}