package pieces

import model.Piece
import entities.Board
import enums.Color
import enums.PieceType
import model.Position

class Pawn(pieceType: PieceType, color: Color, pos: Position, private var isMovingFirstTime: Boolean) :
    Piece(pieceType, color, pos, isMovingFirstTime) {

    init {
        setSymbol(
            if (color == Color.Black) {
                "B"
            } else {
                "W"
            } + "P"
        )
    }

    override fun getPossibleMoves(from: Position, board: Board): ArrayList<Position> {
        val posArrayList = arrayListOf<Position>()

        //can we move one step ahead
        val newOneStepPosition = Position(from.row + DIRECTION, from.col)
        if (isValid(newOneStepPosition) && !board.isOccupied(newOneStepPosition)) {
            //means the box is empty
            //1st case: one step
            posArrayList.add(newOneStepPosition)

            //2nd case: moving for the first time
            if (this.getIsMovingFirstTime()) {
                //check for 2 step if possible
                val newSecondStepPosition = Position(from.row + 2 * DIRECTION, from.col)

                if (isValid(newSecondStepPosition) && !board.isOccupied(newSecondStepPosition)) {
                    posArrayList.add(newSecondStepPosition)
                }
            }
        }

        //check for captures
        //left capture
        val newLeftCapturePosition = Position(from.row + DIRECTION, from.col - 1)
        if (isValid(newLeftCapturePosition) && board.isOccupied(newLeftCapturePosition)
            && !isOccupiedWithSameColor(board.getPiece(newLeftCapturePosition).getColor())
        ) {
            posArrayList.add(newLeftCapturePosition)
        }

        //right capture
        val newSecondCapturePosition = Position(from.row + DIRECTION, from.col + 1)
        if (isValid(newSecondCapturePosition) && board.isOccupied(newSecondCapturePosition)
            && !isOccupiedWithSameColor(board.getPiece(newSecondCapturePosition).getColor())
        ) {
            posArrayList.add(newSecondCapturePosition)
        }

        isMovingFirstTime = false
        return posArrayList
    }
}