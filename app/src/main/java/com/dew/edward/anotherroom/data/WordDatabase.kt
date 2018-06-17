package com.dew.edward.anotherroom.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordDatabase: RoomDatabase() {

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