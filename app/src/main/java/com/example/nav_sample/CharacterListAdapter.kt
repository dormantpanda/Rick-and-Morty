package com.example.nav_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nav_sample.models.characters.Character
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterListAdapter : PagedListAdapter<Character, CharacterListAdapter.CharacterItemViewHolder>(CHARACTER_COMPARATOR) {
    var onItemClick: ((Character) -> Unit) = {}

    class CharacterItemViewHolder(
        itemView: View,
        private var onItemClick: ((Character) -> Unit)
    ) : RecyclerView.ViewHolder(itemView){

        fun bind(character : Character){
            itemView.setOnClickListener {
                onItemClick.invoke(character)
            }

            itemView.tvCharacterName.text = character.name
            itemView.tvCharacterSpecies.text = character.species

            Glide.with(itemView.ivAvatarImage.context)
                .load(character.image)
                .into(itemView.ivAvatarImage)
        }

    }

    companion object{

        private val CHARACTER_COMPARATOR = object : DiffUtil.ItemCallback<Character>(){
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return CharacterItemViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.bind(character) }
    }

}