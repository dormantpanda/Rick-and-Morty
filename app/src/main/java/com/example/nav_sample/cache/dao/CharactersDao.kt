package com.example.nav_sample.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.nav_sample.cache.models.CharactersDB
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Observable<List<CharactersDB>>

    @Insert
    fun insert(character: List<CharactersDB>): Completable

    @Delete
    fun delete(character: CharactersDB): Completable
}