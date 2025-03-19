package edu.ucsc.cse118.assignment3.repo

import android.util.Log
import edu.ucsc.cse118.assignment3.data.Channel
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.data.Message
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MessageRepository {

    fun getAllMessages(member: Member?, channel: Channel?): ArrayList<Message> {
        val url = "https://cse118.com/api/v2/channel/${channel?.id}/message"
        with(URL(url).openConnection() as HttpsURLConnection) {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "text/html; charset=UTF-8n")
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Authorization", "Bearer ${member?.accessToken}")
            val response = StringBuffer()
            BufferedReader(InputStreamReader(inputStream)).use {
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
            }
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                return sortMessagesByDateDescending(Json.decodeFromString(response.toString()))
            }
            throw Exception("Failed to GET HTTP $responseCode")
        }
    }

    private fun sortMessagesByDateDescending(messages: ArrayList<Message>): ArrayList<Message> {
        messages.sortByDescending { message -> message.posted }
        return messages
    }

   // TA Tongze helped
    fun createOne(member: Member?, channel: Channel?, message: Message?): Message {
        val url = "https://cse118.com/api/v2/channel/${channel?.id}/message"
        with(URL(url).openConnection() as HttpsURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Authorization", "Bearer ${member?.accessToken}")
            outputStream.write(("{\"content\":\"" + message?.content + "\"}").toByteArray())
            if (responseCode == HttpsURLConnection.HTTP_CREATED) {
                return Json.decodeFromString(inputStream.bufferedReader().use { it.readText() })
            }
            throw Exception("Failed to PUT HTTP $responseCode")
        }
    }
    fun deleteOne(member: Member?, message: Message?) {
        val url = "https://cse118.com/api/v2/message/${message?.id}"
        with(URL(url).openConnection() as HttpsURLConnection) {
            requestMethod = "DELETE"
            setRequestProperty("Content-Type", "application/json")
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Authorization", "Bearer ${member?.accessToken}")
            if (responseCode != HttpsURLConnection.HTTP_OK) {
                throw Exception("Failed to DELETE HTTP $responseCode")
            }
        }
    }
}