package pieces

import model.Piece
import entities.Board
import enums.Color
import enums.PieceType
import model.Position

class Queen(pieceType: PieceType, color: Color, pos: Position, private var isMovingFirstTime: Boolean) :
    Piece(pieceType, color, pos, isMovingFirstTime) {

    init {
        setSymbol(
            if (color == Color.Black) {
                "B"
            } else {
                "W"
            } + "Q"
        )
    }

    override fun getPossibleMoves(from: Position, board: Board): ArrayList<Position> {
        val posArrayList = arrayListOf<Position>()

        val dr = arrayListOf(1, -1, 0, 0, 1, -1, 1, -1)
        val dc = arrayListOf(0, 0, -1, 1, 1, -1, -1, 1)

        for (i in 0 until 8) {
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