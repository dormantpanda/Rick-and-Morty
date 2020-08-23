package com.example.nav_sample.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")

data class CharactersDB (
    @PrimaryKey val id: Int,

    val name: String? = null,

    val status: String? = null,

    val species: String? = null,

    val type: String? = null,

    val gender: String? = null,

    val origin: String? = null,

    val location: String? = null,

    val image: String? = null,

    val episode: String? = null,

    val url: String? = null,

    val created: String? = null
)
