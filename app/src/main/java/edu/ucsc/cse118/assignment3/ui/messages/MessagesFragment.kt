package edu.ucsc.cse118.assignment3.ui.messages

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Message
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.databinding.FragmentMessagesBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent

class MessagesFragment : Fragment(), MessagesListener {
    /* SOURCES:
        https://www.geeksforgeeks.org/android-swipe-to-delete-and-undo-in-recyclerview-with-kotlin/
        James Tutor Help
        Tongze Tutor Help

     */

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }
    private val messagesObserver = Observer<ArrayList<Message>> { messages ->
        for (i in messages) {
            i.member = sharedViewModel.getMemberbyID((i.member))
        }
        recyclerView.adapter = MessagesAdapter(messages, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
        sharedViewModel.messages.observe(this, messagesObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
        sharedViewModel.messages.removeObserver(messagesObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMessagesBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    // Delete function for message
    fun delete(message: Message?) {
        if (message != null) {
            sharedViewModel.deleteMessage(message)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val recyclerViewAdapter = MessagesAdapter(arrayListOf(), this)
        recyclerView.adapter = recyclerViewAdapter
        sharedViewModel.getMessages()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            sharedViewModel.channel.value?.getRawContent()?.name
        val createMessageBtn = view.findViewById<FloatingActionButton>(R.id.fab)
        createMessageBtn.setOnClickListener {
            findNavController().navigate(R.id.action_messagesFragment_to_createMessageFragment)
        }

        // Setup Swipe right
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }
            @SuppressLint("SetTextI18n")
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val messageSwiped = sharedViewModel.messages.value?.get(viewHolder.adapterPosition)
                val swipedName = messageSwiped?.member
                // Create the custom dialog
                val dialog = Dialog(requireContext())
                dialog.setContentView(R.layout.fragment_delete_message)
                // Set the dialog properties
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                dialog.setCancelable(false)
                val messageTextView = dialog.findViewById<TextView>(R.id.dialogue_message)
                messageTextView.text = "Delete Message From\n ${swipedName}?"

                // Set a click listener for the no button
                val noButton = dialog.findViewById<Button>(R.id.no)
                noButton.setOnClickListener {
                    dialog.dismiss()
                    sharedViewModel.messages.value?.removeAt(viewHolder.adapterPosition)
                    // Add the message back to its original position
                    if (messageSwiped != null) {
                        sharedViewModel.messages.value?.add(viewHolder.adapterPosition, messageSwiped)
                    }
                    recyclerView.adapter?.notifyItemChanged(viewHolder.adapterPosition) }
                // Set a click listener for the yes button
                val yesButton = dialog.findViewById<Button>(R.id.yes)
                yesButton.setOnClickListener {
                    // Call delete function
                    delete(messageSwiped)
                    dialog.dismiss()
                    val snack = Snackbar.make(view, "Message Deleted", Snackbar.LENGTH_LONG)
                    snack.show()

                }
                // Show the dialog
                dialog.show()
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onClick(message: Message) {
        sharedViewModel.setMessage(message)
        findNavController().navigate(R.id.action_messagesFragment_to_messageFragment)
    }
}