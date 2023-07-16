package com.example.netflixClone.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movie::class, Category::class, MovieCategoryCrossRef::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}