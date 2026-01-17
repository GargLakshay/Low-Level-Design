package model

import model.Piece

data class Move(
    private val from: Position,
    private val to: Position,
    private val pieceType: Piece,
    private val capturedPiece: Piece
)
