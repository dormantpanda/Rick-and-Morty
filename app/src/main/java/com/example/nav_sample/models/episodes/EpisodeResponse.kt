package com.example.nav_sample.models.episodes

import com.google.gson.annotations.SerializedName

class EpisodeResponse {

    @SerializedName("results")
    var results: List<Episode>? = null
}