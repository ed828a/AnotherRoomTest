package com.dew.edward.anotherroom.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
 * Created by Edward on 5/26/2018.
 */

@Entity(tableName = "pets")
class Pet(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo
        var name: String,

        @ColumnInfo
        var breed: String,

        @ColumnInfo
        var gender: String,

        @ColumnInfo
        var weight: Int)