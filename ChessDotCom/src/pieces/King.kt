package pieces

import model.Piece
import entities.Board
import enums.Color
import enums.PieceType
import model.Position

class King(
    pieceType: PieceType,
    color: Color,
    private val pos: Position,
    private var isMovingFirstTime: Boolean
) :
    Piece(pieceType, color, pos, isMovingFirstTime) {

    init {
        setSymbol(
            if (color == Color.Black) {
                "B"
            } else {
                "W"
            } + "K"
        )
    }

    override fun getPossibleMoves(from: Position, board: Board): ArrayList<Position> {
        val posArrayList = arrayListOf<Position>()

        val dr = arrayListOf(1, -1, 0, 0, 1, -1, 1, -1)
        val dc = arrayListOf(0, 0, -1, 1, 1, -1, -1, 1)

        for (i in 0 until 8) {

            val row = from.row + dr[i]
            val col = from.col + dc[i]

            val newPos = Position(row, col)

            //if not valid
            if (!isValid(newPos)) continue

            //means valid box

            //check not occupied by same color
            if (isOccupiedWithSameColor(board.getPiece(newPos).getColor())) continue

            posArrayList.add(newPos)
        }
        return posArrayList
    }


}