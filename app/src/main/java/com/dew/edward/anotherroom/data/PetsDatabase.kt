package com.dew.edward.anotherroom.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.content.Context


/*
 * Created by Edward on 5/26/2018.
 */

@Database(entities = [Pet::class], version = 1, exportSchema = false)
abstract class PetsDatabase: RoomDatabase() {

     abstract fun mPetsDao(): PetsDao

    // make this class a singleton
    companion object {
        private var SingletonPetsDb: PetsDatabase? = null

        // factory method
        fun getPetsDb(context: Context): PetsDatabase? {
            if (SingletonPetsDb == null) {
                synchronized(PetsDatabase::class) {
                    if (SingletonPetsDb == null) {
                        // Create database here
                        SingletonPetsDb = Room.databaseBuilder(context.applicationContext,
                                PetsDatabase::class.java, "pets_database")
//                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return SingletonPetsDb
        }

        fun destroyInstance(){
            SingletonPetsDb = null
        }
    }
}