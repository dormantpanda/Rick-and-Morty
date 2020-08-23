package com.example.nav_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_sample.models.episodes.Episode
import kotlinx.android.synthetic.main.item_episode.view.*

class CharacterEpisodeListAdapter : RecyclerView.Adapter<CharacterEpisodeListAdapter.EpisodeItemViewHolder>() {

    private var episodes: List<Episode>? = null

    class EpisodeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(episode: Episode){
            itemView.tvEpisodeName.text = episode.name
            itemView.tvEpisode.text = episode.episode
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false)
        return EpisodeItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        episodes?.let {
            return episodes!!.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: EpisodeItemViewHolder, position: Int) {
        episodes?.let {
            holder.bind(episodes!![position])
        }
    }

    fun setEpisodes(episodes: List<Episode>){
        this.episodes = episodes
        notifyDataSetChanged()
    }
}