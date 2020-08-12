package com.example.nav_sample.models.locations

import com.google.gson.annotations.SerializedName

class LocationResponse {

    @SerializedName("results")
    var results: List<Location>? = null
}