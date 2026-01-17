package pieces

import model.Piece
import entities.Board
import enums.Color
import enums.PieceType
import model.Position

class None(pieceType: PieceType, color: Color, pos: Position, private var isMovingFirstTime: Boolean) :
    Piece(pieceType, color, pos, isMovingFirstTime) {
    init {
        setSymbol("--")
    }

    override fun getPossibleMoves(from: Position, board: Board): ArrayList<Position> {
        val posArrayList = arrayListOf<Position>()
        return posArrayList
    }
}