package com.example.nav_sample.ui.characters

import com.example.nav_sample.models.characters.Character

sealed class CharacterState {
    object StateLoading : CharacterState()
    class StateError(error: String?) : CharacterState(){
        val error = error
    }
    class StateShowCharacters(characters : List<Character>) : CharacterState(){
        val characters = characters
    }
}