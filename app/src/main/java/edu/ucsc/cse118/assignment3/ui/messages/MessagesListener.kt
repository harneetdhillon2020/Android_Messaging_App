package edu.ucsc.cse118.assignment3.ui.messages

import edu.ucsc.cse118.assignment3.data.Message

interface MessagesListener {
    fun onClick(message: Message)
}