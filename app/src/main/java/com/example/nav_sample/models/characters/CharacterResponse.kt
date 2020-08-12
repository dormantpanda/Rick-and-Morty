package com.example.nav_sample.models.characters

import com.google.gson.annotations.SerializedName

class CharacterResponse {

    @SerializedName("results")
    var results: List<Character>? = null
}