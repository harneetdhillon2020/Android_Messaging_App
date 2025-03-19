package edu.ucsc.cse118.assignment3.ui.messages

import android.annotation.SuppressLint
import android.view.LayoutInflater
import edu.ucsc.cse118.assignment3.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.data.Message
import java.text.SimpleDateFormat
import java.util.Locale

class MessagesAdapter(private val messages: ArrayList<Message>, private val listener: MessagesListener) :
    RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_messages, parent, false)
        return MessageViewHolder(view)
    }
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
        holder.itemView.setOnClickListener { listener.onClick(messages[position]) }
    }
    override fun getItemCount(): Int {
        return messages.size
    }
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val user: TextView = itemView.findViewById(R.id.user)
        private val date: TextView = itemView.findViewById(R.id.date)
        private val body: TextView = itemView.findViewById(R.id.body)

        // CHAT GPT Inspired
        fun bind(message: Message) {
            user.text = message.member

            try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
                val outputFormat = SimpleDateFormat("MMM d, yyyy, hh:mm:ss a", Locale.US)
                val postedDate = inputFormat.parse(message.posted)
                val formattedDate = outputFormat.format(postedDate)
                date.text = formattedDate
            } catch (e: Exception) {
                date.text = "Invalid Date"
                e.printStackTrace()
            }

            body.text = message.content
        }
    }
}