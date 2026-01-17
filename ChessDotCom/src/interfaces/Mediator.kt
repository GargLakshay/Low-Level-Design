package interfaces

interface Mediator {
    fun sendMessage(sender: Colleague, msg: String)
}