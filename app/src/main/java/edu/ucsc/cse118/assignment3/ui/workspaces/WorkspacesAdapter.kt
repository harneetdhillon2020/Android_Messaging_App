package edu.ucsc.cse118.assignment3.ui.workspaces

import android.annotation.SuppressLint
import android.view.LayoutInflater
import edu.ucsc.cse118.assignment3.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.data.Workspace

class WorkspacesAdapter(private val workspaces: ArrayList<Workspace>, private val listener: WorkspacesListener) :
    RecyclerView.Adapter<WorkspacesAdapter.WorkspaceViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkspaceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_workspaces, parent, false)
        return WorkspaceViewHolder(view)
    }
    override fun onBindViewHolder(holder: WorkspaceViewHolder, position: Int) {
        holder.bind(workspaces[position])
        holder.itemView.setOnClickListener { listener.onClick(workspaces[position]) }
    }
    override fun getItemCount(): Int {
        return workspaces.size
    }
    class WorkspaceViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val channels : TextView = itemView.findViewById(R.id.channels)

        fun bind(workspace: Workspace) {
            name.text = workspace.name
            val numChannels = workspace.channels
            channels.text = if (numChannels > 1) {
                "$numChannels Channels"
            } else {
                "$numChannels Channel"
            }
        }
    }
}