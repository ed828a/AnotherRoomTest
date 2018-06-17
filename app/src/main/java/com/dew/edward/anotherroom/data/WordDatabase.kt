package com.dew.edward.anotherroom.data

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

abstract class WordDatabase(context: Context): RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase =
                INSTANCE ?: synchronized(WordDatabase::class){
                    INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                            WordDatabase::class.java, "words_database")
                            .build()
                            .also { INSTANCE = it }
                }
    }
}