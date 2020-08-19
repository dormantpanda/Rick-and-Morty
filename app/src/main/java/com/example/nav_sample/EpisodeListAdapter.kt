package com.example.nav_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_sample.models.episodes.Episode
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeListAdapter : PagedListAdapter<Episode, EpisodeListAdapter.EpisodeItemViewHolder>(EPISODE_COMPARATOR) {

    class EpisodeItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(episode : Episode){
            itemView.tvEpisodeName.text = episode.name
            itemView.tvEpisode.text = episode.episode
        }
    }

    companion object{
        private val EPISODE_COMPARATOR = object : DiffUtil.ItemCallback<Episode>(){
            override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false)

        return EpisodeListAdapter.EpisodeItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeItemViewHolder, position: Int) {
        val episode = getItem(position)
        episode?.let { holder.bind(episode) }
    }
}