package entities

import enums.Color
import enums.PieceType
import interfaces.ChessRules
import model.Position
import kotlin.collections.iterator

class StandardRules : ChessRules {
    override fun isValidMove(from: Position, to: Position, board: Board): Boolean {
        //there must be piece in FROM position
        if (!board.isOccupied(from)) return false

        //we also need to check that piece at FROM can move to TO position or not
        val possibleMoves = board.getPiece(from).getPossibleMoves(from, board)
        var validMovement = false
        for (possibleMove in possibleMoves) {
            if (possibleMove == to) {
                validMovement = true
                break
            }
        }

        if (!validMovement) return false

        //TO is valid box && not occupied by same color && moving this piece must not cause check
        if (board.isValid(to) && board.getPiece(from).getColor() != board.getPiece(to).getColor()
            && !wouldCauseCheck(from, to, board)
        ) {
            return true
        }
        return false
    }

    override fun isInCheck(color: Color, board: Board): Boolean {
        //extract all possible moves by all opponent pieces , and check if one of their possible moves
        //matches with king
        val currUserKingPosition = board.getKingPosition(color)
        val opponentColor = if (color == Color.Black) Color.White else Color.Black
        val opponentMap = board.getAllPieces(opponentColor)

        for (keyValue in opponentMap) {
            for (possibleMove in keyValue.value.getPossibleMoves(keyValue.key, board)) {
                if (possibleMove == currUserKingPosition) {
                    return true
                }
            }
        }
        return false
    }

    override fun isCheckMate(color: Color, board: Board): Boolean {
        //king must be in check first
        if (!isInCheck(color, board)) return false

        //there is no option to save king
        //we can't make any move to stop check

        val userMap = board.getAllPieces(color)

        for (keyValue in userMap) {
            for (possibleMove in keyValue.value.getPossibleMoves(keyValue.key, board)) {
                if (!wouldCauseCheck(keyValue.key, possibleMove, board)) {
                    return false
                }
            }
        }
        return true
    }

    override fun wouldCauseCheck(from: Position, to: Position, board: Board): Boolean {
        //if we move piece FROM - TO , there should be no check

        //first we temporarily move this piece FROM-TO, now we check is there CHECK
        //if true return true else false

        val currPiece = board.getPiece(from)
        val capturedPiece = board.getPiece(to)
        //there should be piece at FROM
        if (currPiece.getPieceType() == PieceType.None) return false


        //first we remove FROM , and add TO
        board.remove(from)


        board.addPiece(to, currPiece)

        val isInCheck = isInCheck(currPiece.getColor(), board)

        //restore the move
        board.addPiece(from, currPiece)
        board.addPiece(to, capturedPiece)

        return isInCheck
    }

    override fun isStaleMate(color: Color, board: Board): Boolean {
        if (isInCheck(color, board)) return false

        //there must not possible move to MOVE
        val userMap = board.getAllPieces(color)
        var isStalemate = true
        for (keyValue in userMap) {
            val possibleMoves = keyValue.value.getPossibleMoves(keyValue.key, board)
            if (!possibleMoves.isEmpty()) {
                isStalemate = false
                break
            }
        }
        return isStalemate
    }
}