package com.project.starbucks_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.starbucks_app.data.local.dao.StarbucksDao
import com.project.starbucks_app.data.local.entity.MenuItem

@Database(entities = [MenuItem::class], version = 1, exportSchema = false)
abstract class StarbucksDatabase: RoomDatabase() {
    abstract fun starbucksDao(): StarbucksDao
}