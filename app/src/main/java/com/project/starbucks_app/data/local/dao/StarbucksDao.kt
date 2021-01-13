package com.project.starbucks_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.starbucks_app.data.local.entity.MenuItem
import io.reactivex.Single

@Dao
abstract class StarbucksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMenu(characterList: List<MenuItem>)

    @Query("SELECT * FROM starbucks WHERE id = :id")
    abstract fun getMenuFromDb(id: Int): Single<List<MenuItem>>
}