package interfaces

import entities.Board
import enums.Color
import enums.PieceType
import model.Position

interface PieceInterface {
    fun getPossibleMoves(from: Position, board: Board): ArrayList<Position>
    fun setIsMovingFirstTime(isMovingFirstTime: Boolean)

    fun getPieceType(): PieceType
    fun getColor(): Color
    fun getSymbol(): String
    fun getPosition(): Position
    fun getIsMovingFirstTime(): Boolean

}