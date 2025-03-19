package edu.ucsc.cse118.assignment3.ui.message

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import edu.ucsc.cse118.assignment3.data.Message
import edu.ucsc.cse118.assignment3.databinding.FragmentMessageBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent
import java.text.SimpleDateFormat
import java.util.Locale

class MessageFragment : Fragment() {

    private lateinit var binding: FragmentMessageBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    // Chat GPT Inspired
    @SuppressLint("SetTextI18n")
    private val messageObserver = Observer<ViewModelEvent<Message>> { event ->
        val message = event.getUnhandledContent()
        if (message != null) {
            (activity as AppCompatActivity?)!!.supportActionBar!!.title = message.member

            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
            val outputFormat = SimpleDateFormat("MMM d, yyyy, hh:mm:ss a", Locale.US)

            try {
                val parsedDate = message.posted.let { inputFormat.parse(it) }
                val formattedDate = parsedDate?.let { outputFormat.format(it) }
                binding.date.text = formattedDate
            } catch (e: Exception) {
                e.printStackTrace()
                binding.date.text = "Invalid Date"
            }

            binding.content.text = message.content
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
        sharedViewModel.message.observe(this, messageObserver)
    }
    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
        sharedViewModel.message.removeObserver(messageObserver)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.getMessages()
    }
}