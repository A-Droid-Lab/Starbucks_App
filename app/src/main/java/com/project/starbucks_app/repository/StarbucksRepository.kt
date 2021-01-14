package com.project.starbucks_app.repository

import com.project.starbucks_app.data.local.dao.StarbucksDao
import com.project.starbucks_app.data.local.entity.MenuItem
import com.project.starbucks_app.data.remote.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StarbucksRepository @Inject constructor(private val apiService: ApiService, private val starbucksDao: StarbucksDao) {

    fun getCoffeeMenu() : Single<List<MenuItem>> {
        return apiService.getAllMenus()
            .subscribeOn(Schedulers.io()) //Observable이 발행되는 스레드를 지정한다.
            .observeOn(AndroidSchedulers.mainThread()) //처리된 결과를 전달하는 스레드 지정한다.
            .toObservable()
            .flatMapIterable {
                it.filter { t -> t.id in 249..295 }
            }
            .toList()
    }

    fun getFrapuccino() : Single<List<MenuItem>> {
        return apiService.getAllMenus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
            .flatMapIterable {
                it.filter { t -> t.id in 296..311 }
            }
            .toList()
    }

    fun getBlended(): Single<List<MenuItem>> {
        return apiService.getAllMenus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
            .flatMapIterable {
                it.filter { t -> t.id in 312..320 }
            }
            .toList()
    }


}