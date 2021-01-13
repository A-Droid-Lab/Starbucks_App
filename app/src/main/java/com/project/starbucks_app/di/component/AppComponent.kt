package com.project.starbucks_app.di.component

import android.app.Application
import com.project.starbucks_app.StarbucksApp
import com.project.starbucks_app.di.builder.ActivityBuilder
import com.project.starbucks_app.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class
    ])
interface AppComponent : AndroidInjector<StarbucksApp> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }
}