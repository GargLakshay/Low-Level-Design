import enums.Color
import enums.PieceType
import model.Piece
import model.Position
import pieces.Bishop
import pieces.King
import pieces.Knight
import pieces.None
import pieces.Pawn
import pieces.Queen
import pieces.Rook

object PieceFactory {

    fun getPiece(pieceType: PieceType, color: Color, pos: Position): Piece {
        var piece: Piece?
        when (pieceType) {
            PieceType.King -> {
                piece = King(pieceType, color, pos, true)
            }

            PieceType.Queen -> {
                piece = Queen(pieceType, color, pos, true)
            }

            PieceType.Rook -> {
                piece = Rook(pieceType, color, pos, true)
            }

            PieceType.Bishop -> {
                piece = Bishop(pieceType, color, pos, true)
            }

            PieceType.Knight -> {
                piece = Knight(pieceType, color, pos, true)
            }

            PieceType.Pawn -> {
                piece = Pawn(pieceType, color, pos, true)
            }

            else -> {
                piece = None(pieceType, color, pos, true)

            }
        }
        return piece
    }
}