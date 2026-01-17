package interfaces

import entities.Board
import enums.Color
import model.Position

interface ChessRules {
    fun isValidMove(from: Position, to: Position, board: Board): Boolean
    fun isInCheck(color: Color, board: Board): Boolean
    fun isCheckMate(color: Color, board: Board): Boolean
    fun wouldCauseCheck(from: Position, to: Position, board: Board): Boolean
    fun isStaleMate(color: Color, board: Board): Boolean
}