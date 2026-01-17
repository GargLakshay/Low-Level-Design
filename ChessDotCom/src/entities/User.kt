package entities

import enums.Color
import interfaces.Colleague
import interfaces.Mediator
import model.Message

class User(private val name: String) : Colleague {

    private var userId = 0
    private var color = Color.Black
    private var score = 500

    init {
        userId = ++idCounter
    }

    companion object {
        private var idCounter = 0
    }

    private var mediator: Mediator? = null

    override fun sendMessage(message: String) {
        mediator?.sendMessage(this, message)
    }

    override fun receiveMessage(message: Message) {
        println("Message received from ${message.getSender().getUserName()}: $message")
    }

    override fun getUserId() = userId
    override fun getUserScore() = score
    override fun updateUserScore(delta: Int) {
        score += delta
    }

    override fun setColor(color: Color) {
        this.color = color
    }

    override fun getUserColor() = color
    override fun getUserName() = name
    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

}