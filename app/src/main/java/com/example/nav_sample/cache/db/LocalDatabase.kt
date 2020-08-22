package com.example.nav_sample.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nav_sample.cache.dao.CharactersDao
import com.example.nav_sample.cache.db.LocalDatabase.Companion.DATABASE_VERSION
import com.example.nav_sample.cache.models.CharactersDB

@Database(entities = arrayOf(CharactersDB::class), version = DATABASE_VERSION)
abstract class LocalDatabase : RoomDatabase(){
    abstract fun charactersDao(): CharactersDao

    companion object{
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Room"
        fun buildDataSource(context: Context): LocalDatabase =
            Room.databaseBuilder(context, LocalDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}