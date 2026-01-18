package entities

data class User(val name: String) {
    private var userId = 0
    private var position = 0

    companion object {
        var idCounter = 0
    }

    init {
        userId = ++idCounter
    }

    fun updatePos(pos: Int) {
        position = pos
    }

    fun getPos() = position
}