package com.project.starbucks_app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.starbucks_app.di.ViewModelKey
import com.project.starbucks_app.view.vm.CoffeeViewModel
import com.project.starbucks_app.view.vm.MenuViewModel
import com.project.starbucks_app.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindsMenuViewModel(menuViewModel: MenuViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CoffeeViewModel::class)
    abstract fun bindsCoffeeViewModel(coffeeViewModel: CoffeeViewModel): ViewModel

}