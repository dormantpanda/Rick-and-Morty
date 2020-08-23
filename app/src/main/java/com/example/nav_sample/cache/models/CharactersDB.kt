package com.example.nav_sample.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")

data class CharactersDB (
    @PrimaryKey val id: Int,

    val data: String? = null
)
