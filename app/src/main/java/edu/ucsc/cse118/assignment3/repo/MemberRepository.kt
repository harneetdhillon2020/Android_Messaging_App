package edu.ucsc.cse118.assignment3.repo

import edu.ucsc.cse118.assignment3.data.Channel
import edu.ucsc.cse118.assignment3.data.Member
import edu.ucsc.cse118.assignment3.data.Workspace
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MemberRepository {

    fun login(email: String, password: String): Member {
        val url = "https://cse118.com/api/v2/login"
        with(URL(url).openConnection() as HttpsURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            setRequestProperty("Accept", "application/json")
            outputStream.write(Json.encodeToString(LoginCredentials(email, password)).toByteArray())
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                return Json.decodeFromString(inputStream.bufferedReader().use { it.readText() })
            }
            throw Exception("Failed to login : HTTP $responseCode")
        }
    }

    @Serializable
    data class LoginCredentials(val email: String, val password: String)

    fun getAllMembers(member: Member): ArrayList<Member> {
        val url = "https://cse118.com/api/v2/member"
        with(URL(url).openConnection() as HttpsURLConnection) {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "text/html; charset=UTF-8n")
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Authorization", "Bearer ${member?.accessToken}")
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                return Json.decodeFromString(inputStream.bufferedReader().use { it.readText()})
            }
            throw Exception("Failed to login : HTTP $responseCode")
        }
    }

}