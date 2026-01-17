package model

import interfaces.Colleague
import java.sql.Timestamp
import java.time.LocalDateTime

data class Message(
    private val sender: Colleague,
    private val message: String
) {
    fun getMessage() = message
    fun getSender() = sender
}
