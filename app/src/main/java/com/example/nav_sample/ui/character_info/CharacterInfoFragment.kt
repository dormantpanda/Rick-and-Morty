package com.example.nav_sample.ui.character_info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.nav_sample.R
import com.example.nav_sample.models.characters.Character
import kotlinx.android.synthetic.main.fragment_character_info.*
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterInfoFragment : Fragment(R.layout.fragment_character_info) {
    companion object {
        private const val EXTRA_CHARACTER = "extra_character"

        fun getBundle(character: Character): Bundle {
            return Bundle().apply {
                putParcelable(EXTRA_CHARACTER, character)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character: Character? = arguments?.getParcelable(EXTRA_CHARACTER)

        character?.let{
            Glide.with(ivCharacterAvatarInfo.context)
                .load(character.image)
                .into(ivCharacterAvatarInfo)

            tvCharacterNameInfo.text = it.name
            tvCharacterStatusInfo.text = "(${it.status})"
            tvCharacterSpeciesInfo.text = it.species
            if (it.type != "") tvCharacterTypeInfo.text = "(${it.type})"
            tvCharacterGenderInfo.text = it.gender
            tvCharacterLocationInfo.text = it.location?.name


        }
    }
}