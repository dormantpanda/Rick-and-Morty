package com.example.nav_sample.models.characters

import android.os.Parcelable
import com.example.nav_sample.models.episodes.Episode
import com.example.nav_sample.models.locations.Location
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character (

    var id: Int? = null,

    var name: String? = null,

    var status: String? = null,

    var species: String? = null,

    var type: String? = null,

    var gender: String? = null,

    var origin: Location? = null,

    var location: Location? = null,

    var image: String? = null,

    var episode: List<String>? = null,

    var url: String? = null,

    var created: String? = null
) : Parcelable