package interfaces

import entities.Board

interface GameRules {
    fun isValidMove(pos: Int, boardSize: Int): Boolean
    fun isWin(pos: Int, boardSize: Int): Boolean
    fun calFinalPosition(pos: Int, board: Board): Int
}