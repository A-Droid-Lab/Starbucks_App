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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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