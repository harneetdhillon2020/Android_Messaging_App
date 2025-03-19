package edu.ucsc.cse118.assignment3.ui.channels

import android.annotation.SuppressLint
import android.view.LayoutInflater
import edu.ucsc.cse118.assignment3.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.data.Channel

class ChannelsAdapter(private val channels: ArrayList<Channel>, private val listener: ChannelsListener) :
    RecyclerView.Adapter<ChannelsAdapter.ChannelViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_workspaces, parent, false)
        return ChannelViewHolder(view)
    }
    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(channels[position])
        holder.itemView.setOnClickListener { listener.onClick(channels[position]) }
    }
    override fun getItemCount(): Int {
        return channels.size
    }
    class ChannelViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val messages : TextView = itemView.findViewById(R.id.channels)

        @SuppressLint("SetTextI18n")
        fun bind(channel: Channel) {
            name.text = channel.name
            messages.text = channel.messages.toString()+" Messages"
        }
    }
}