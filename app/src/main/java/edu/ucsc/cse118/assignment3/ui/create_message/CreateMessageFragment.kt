package edu.ucsc.cse118.assignment3.ui.create_message

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import edu.ucsc.cse118.assignment3.data.Channel
import edu.ucsc.cse118.assignment3.data.Message
import edu.ucsc.cse118.assignment3.databinding.FragmentCreateMessageBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent

class CreateMessageFragment : Fragment() {

    private lateinit var binding: FragmentCreateMessageBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val messageObserver = Observer<ViewModelEvent<Message>> { event ->
        val message = event.getUnhandledContent()
        if (message != null) {
            super.getActivity()?.onBackPressed()
            // https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar
            val snack = Snackbar.make(binding.root, "Message Created", Snackbar.LENGTH_LONG)
            snack.show()
        }
    }

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
            binding.label.text = error // FIX THIS
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.add.isEnabled =
                (binding.content.text.length > 15)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.message.observe(this, messageObserver)
        sharedViewModel.error.observe(this, errorObserver)
    }
    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.message.removeObserver(messageObserver)
        sharedViewModel.error.observe(this, errorObserver)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateMessageBinding.inflate(inflater, container, false)
        binding.add.isEnabled = false
        binding.content.addTextChangedListener(textWatcher)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createMessageFragment = this
    }
    //CHAT GPT inspired
    fun add() {
        val content = binding.content.text.toString()
        val channel = sharedViewModel.channel.value!!.getRawContent()
        val message = Message(id = "", member = "", posted = "", content = content)
        sharedViewModel.createMessage(message, channel)
    }
}