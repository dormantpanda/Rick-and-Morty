package com.example.nav_sample.models.locations

import android.os.Parcelable
import com.example.nav_sample.models.characters.Character
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location (

    var id: Int? = null,

    var name: String? = null,

    var type: String? = null,

    var dimension: String? = null,

    var residents: List<String>? = null,

    var url: String? = null,

    var created: String? = null
) : Parcelable