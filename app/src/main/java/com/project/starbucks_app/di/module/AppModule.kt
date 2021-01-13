package com.project.starbucks_app.di.module

import android.app.Application
import androidx.room.Room
import com.project.starbucks_app.data.local.StarbucksDatabase
import com.project.starbucks_app.data.local.dao.StarbucksDao
import com.project.starbucks_app.data.remote.ApiService
import com.project.starbucks_app.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.apply {
            addInterceptor(httpLoggingInterceptor)
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideStarbucksDatabase(application: Application): StarbucksDatabase =
        Room.databaseBuilder(application, StarbucksDatabase::class.java, "starbucks.db").build()

    @Provides
    @Singleton
    fun provideStarbucksDao(starbucksDatabase: StarbucksDatabase): StarbucksDao =
        starbucksDatabase.starbucksDao()

}