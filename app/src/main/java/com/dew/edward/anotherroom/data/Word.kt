package com.dew.edward.anotherroom.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "words")
class Word (@PrimaryKey val word: String)