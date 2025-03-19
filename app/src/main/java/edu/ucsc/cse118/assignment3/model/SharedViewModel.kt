package edu.ucsc.cse118.assignment3.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucsc.cse118.assignment3.data.Workspace
import edu.ucsc.cse118.assignment3.repo.WorkspaceRepository
import edu.ucsc.cse118.assignment3.data.Channel
import edu.ucsc.cse118.assignment3.repo.ChannelRepository
import edu.ucsc.cse118.assignment3.data.Message
import edu.ucsc.cse118.assignment3.repo.MessageRepository
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.repo.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    private val _workspaces = MutableLiveData<ArrayList<Workspace>>()
    val workspaces: LiveData<ArrayList<Workspace>> = _workspaces

    private val _workspace = MutableLiveData<ViewModelEvent<Workspace>>()
    val workspace : LiveData<ViewModelEvent<Workspace>> = _workspace

    private val _channels = MutableLiveData<ArrayList<Channel>>()
    val channels: LiveData<ArrayList<Channel>> = _channels

    private val _channel = MutableLiveData<ViewModelEvent<Channel>>()
    val channel : LiveData<ViewModelEvent<Channel>> = _channel

    private val _messages = MutableLiveData<ArrayList<Message>>()
    val messages: LiveData<ArrayList<Message>> = _messages

    private val _message = MutableLiveData<ViewModelEvent<Message>>()
    val message : LiveData<ViewModelEvent<Message>> = _message

    private val _member = MutableLiveData<Member>()
    val member : LiveData<Member> = _member

    private var members : ArrayList<Member>? = null

    private val _error = MutableLiveData<ViewModelEvent<String>>()
    val error : LiveData<ViewModelEvent<String>> = _error

    fun setWorkspace(value: Workspace) {
        _workspace.value = ViewModelEvent(value)
    }
    fun setChannel(value: Channel) {
        _channel.value = ViewModelEvent(value)
    }
    fun setMessage(value: Message) {
        _message.value = ViewModelEvent(value)
    }
    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _member.postValue(MemberRepository().login(email, password))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
    fun getWorkspaces() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _workspaces.postValue(WorkspaceRepository().getAllWorkspaces(member.value))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
    fun getChannels() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _channels.postValue(ChannelRepository().getAllChannels(member.value, workspace.value?.getRawContent()))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
    fun getMessages() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _messages.postValue(MessageRepository().getAllMessages(member.value, channel.value?.getRawContent()))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
    fun getMembers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                members = member.value?.let { MemberRepository().getAllMembers(it) }
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
    // Tongze helped me with this
    fun getMemberbyID(id: String) : String {
        for (i in members!!) {
            if (id == i.id) {
                return i.name
            }
        }
        return ""
    }
    fun createMessage(message: Message, channel: Channel) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                MessageRepository().createOne(member.value,channel,message)
                _message.postValue(ViewModelEvent(message))
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
    fun deleteMessage(message: Message) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                MessageRepository().deleteOne(member.value,message)
            } catch (e: Exception) {
                _error.postValue(ViewModelEvent(e.message.toString()))
            }
        }
    }
}
