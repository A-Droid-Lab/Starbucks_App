package com.project.starbucks_app.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "starbucks")
data class MenuItem(
    val description: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val kcal: Int,
    val name: String,
    val price: Int
) : Parcelable