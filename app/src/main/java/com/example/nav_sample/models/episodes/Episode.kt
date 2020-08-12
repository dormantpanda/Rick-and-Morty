package com.example.nav_sample.models.episodes

import com.example.nav_sample.models.characters.Character
import com.google.gson.annotations.SerializedName

class Episode {

    var id: Int? = null

    var name: String? = null

    @SerializedName("air_date")
    var airDate: String? = null

    var episode: String? = null

    var characters: List<Character>? = null

    var url: String? = null

    var created: String? = null
}