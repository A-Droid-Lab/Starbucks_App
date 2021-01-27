package com.project.starbucks_app.data.remote

import com.project.starbucks_app.data.local.entity.MenuItem
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("menus")
    fun getAllMenus(): Single<List<MenuItem>>

}