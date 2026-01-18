package interfaces

import enums.BoardEntityType

interface BoardEntity {
    val boardEntityType: BoardEntityType
    val from: Int
    val to: Int
    fun display()
}