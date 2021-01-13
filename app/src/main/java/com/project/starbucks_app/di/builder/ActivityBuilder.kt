package com.project.starbucks_app.di.builder

import com.project.starbucks_app.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract fun contributeMainActivity() : MainActivity
}