package interfaces

import enums.Color
import model.Message

interface Colleague {
    fun setColor(color: Color)
    fun updateUserScore(delta: Int)
    fun getUserScore(): Int
    fun getUserId(): Int
    fun sendMessage(message: String)//to , message
    fun receiveMessage(message: Message)//from , message
    fun getUserColor(): Color
    fun getUserName(): String
    fun setMediator(mediator: Mediator)
}