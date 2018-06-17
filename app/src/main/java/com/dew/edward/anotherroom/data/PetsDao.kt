package com.dew.edward.anotherroom.data

import android.arch.persistence.room.*

/*
 * Created by Edward on 5/26/2018.
 */

@Dao
interface PetsDao {
    @Query("SELECT * FROM pets")
    fun getAllPets(): List<Pet>

    @Query("SELECT * FROM pets WHERE name = :name")
    fun getPetByName(name: String): Pet

    @Query("DELETE FROM pets WHERE name = :name")
    fun deletePet(name: String): Boolean

    @Insert
    fun insetPet(pet: Pet): Boolean

    @Update
    fun updatePet(pet: Pet) : Boolean

    @Delete
    fun deleteAllPets()

}