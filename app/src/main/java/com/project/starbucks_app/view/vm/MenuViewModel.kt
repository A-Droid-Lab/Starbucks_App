package com.project.starbucks_app.view.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.repository.StarbucksRepository
import com.project.starbucks_app.view.base.BaseViewModel
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val repo : StarbucksRepository) : BaseViewModel(){

    private val _coffeeLiveData = MutableLiveData<List<MenuItem>>()
    val coffeeLiveData : LiveData<List<MenuItem>>
        get() = _coffeeLiveData

    private val _frapuccinoLiveData = MutableLiveData<List<MenuItem>>()
    val frapuccinoLiveData : LiveData<List<MenuItem>>
        get() = _frapuccinoLiveData

    private val _blendedLiveData = MutableLiveData<List<MenuItem>>()
    val blendedLiveData : LiveData<List<MenuItem>>
        get() = _blendedLiveData


    fun getCoffeeMenu(){
        addDisposable(
            repo.getCoffeeMenu()
                .subscribe({
                    _coffeeLiveData.postValue(it)
                    it.forEach { Log.d("커피 :: ", it.name) }
                },{
                    Log.d("Error Response ", it.localizedMessage)
                })
        )
    }

    fun getFrapuccinoMenu(){
        addDisposable(
            repo.getFrapuccino()
                .subscribe({
                    _frapuccinoLiveData.postValue(it)
                    it.forEach { Log.d("프라푸치노 :: ", it.name) }
                },{
                    Log.d("Error Response ", it.localizedMessage)
                })
        )
    }

    fun getBlendedMenu(){
        addDisposable(
            repo.getBlended()
                .subscribe({
                    _blendedLiveData.postValue(it)
                    it.forEach { Log.d("블랜디드 :: ", it.name) }
                },{
                    Log.d("Error Response ", it.localizedMessage)
                })
        )
    }

    fun getBakeryMenu(){

    }




}