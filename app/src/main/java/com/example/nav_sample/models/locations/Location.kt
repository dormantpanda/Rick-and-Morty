package com.example.nav_sample.models.locations

import com.example.nav_sample.models.characters.Character

class Location {

    var id: Int? = null

    var name: String? = null

    var type: String? = null

    var dimension: String? = null

    var residents: List<Character>? = null

    var url: String? = null

    var created: String? = null
}