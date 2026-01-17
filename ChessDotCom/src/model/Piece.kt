package model

import enums.Color
import enums.PieceType
import interfaces.PieceInterface

abstract class Piece(
    private val pieceType: PieceType,
    private val color: Color,
    private val pos: Position,
    private var isMovingFirstTime: Boolean
) : PieceInterface {
    override fun getPieceType() = pieceType
    override fun getColor() = color
    override fun getSymbol() = symbol
    override fun getPosition() = pos
    override fun getIsMovingFirstTime() = isMovingFirstTime

    val DIRECTION = if (color == Color.Black) 1 else -1
    private var symbol = ""
    fun setSymbol(symbol: String) {
        this.symbol = symbol
    }

    fun isValid(pos: Position): Boolean {
        return !(pos.row < 0 || pos.col < 0 || pos.row >= 8 || pos.col >= 8)
    }

    fun isOccupiedWithSameColor(color: Color): Boolean {
        return color == this.getColor()
    }

    override fun setIsMovingFirstTime(isMovingFirstTime: Boolean) {
        this.isMovingFirstTime = isMovingFirstTime
    }
}