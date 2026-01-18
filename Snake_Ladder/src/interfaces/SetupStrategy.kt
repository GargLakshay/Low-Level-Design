package interfaces

import entities.Board

interface SetupStrategy {
    fun setupBoard(board: Board)
}