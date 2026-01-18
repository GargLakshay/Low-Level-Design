package entities

import enums.BoardEntityType
import interfaces.BoardEntity

class Snake(override val boardEntityType: BoardEntityType, override val from: Int, override val to: Int) : BoardEntity {
    override fun display() {
        println(boardEntityType.toString() + "from: $from, to: $to")
    }
}