package com.dew.edward.anotherroom.data

import android.arch.persistence.room.*


@Dao
interface WordDao {

    @Query("SELECT * FROM words")
    fun allWords(): List<Word>

    @Query("DELETE FROM words")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: Word)

    @Delete
    fun deleteWord(word: Word)

    @Update
    fun updateWord(word: Word)
}