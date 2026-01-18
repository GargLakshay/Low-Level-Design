package entities

import interfaces.GameRules

class StandardRules : GameRules {
    override fun isValidMove(pos: Int, boardSize: Int): Boolean {
        return pos <= boardSize
    }

    override fun isWin(pos: Int, boardSize: Int): Boolean {
        return pos == boardSize
    }

    override fun calFinalPosition(pos: Int, board: Board): Int {
        var newPos = pos
        while (board.boardMap.containsKey(newPos)) {
            newPos = board.boardMap[pos]!!.to
        }
        return newPos
    }
}