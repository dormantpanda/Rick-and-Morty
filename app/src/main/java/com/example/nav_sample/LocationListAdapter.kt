package com.example.nav_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_sample.models.locations.Location
import kotlinx.android.synthetic.main.item_location.view.*

class LocationListAdapter : PagedListAdapter<Location, LocationListAdapter.LocationItemViewHolder>(LOCATION_COMPARATOR) {

    class LocationItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(location : Location){
            itemView.tvLocationName.text = location.name
            itemView.tvLocationType.text = location.type
        }
    }

    companion object{
        private val LOCATION_COMPARATOR = object : DiffUtil.ItemCallback<Location>(){
            override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location, parent, false)

        return LocationItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationItemViewHolder, position: Int) {
        val location = getItem(position)
        location?.let { holder.bind(location) }
    }
}