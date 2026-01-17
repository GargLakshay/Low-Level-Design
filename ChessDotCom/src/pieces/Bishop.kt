package pieces

import model.Piece
import entities.Board
import enums.Color
import enums.PieceType
import model.Position

class Bishop(
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
            } + "B"
        )
    }

    override fun getPossibleMoves(from: Position, board: Board): ArrayList<Position> {
        val posArrayList = arrayListOf<Position>()

        val dr = arrayListOf(1, -1, 1, -1)
        val dc = arrayListOf(1, -1, -1, 1)

        for (i in 0 until 4) {

            val r = dr[i]
            val c = dc[i]
            var row = from.row
            var col = from.col

            //it is valid box ranged with the board
            while (isValid(Position(row + r, col + c))) {
                row += r;
                col += c;
                val newPos = Position(row, col)
                //is it occupied with same color
                if (isOccupiedWithSameColor(board.getPiece(newPos).getColor())) {
                    break
                }

                //not occupied with same color
                posArrayList.add(newPos)

                //may be empty or may be occupied by opponent color

                //occupied with different color, means capture
                if (board.getPiece(newPos).getPieceType() != PieceType.None) {
                    break
                }
            }
        }
        return posArrayList
    }
}