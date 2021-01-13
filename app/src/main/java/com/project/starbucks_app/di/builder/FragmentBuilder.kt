package com.project.starbucks_app.di.builder

import com.project.starbucks_app.view.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

}