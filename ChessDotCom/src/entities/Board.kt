package entities

import model.Piece
import enums.Color
import enums.PieceType
import model.Position

class Board {
    val rows = 8
    val columns = 8
    val map = hashMapOf<Position, Piece>()

    // Initialize a 3x4 array of CustomObject
    val board: Array<Array<Piece>> =
        Array(rows) { i ->
            Array(columns) { j ->
                PieceFactory.getPiece(PieceType.None, Color.None, Position(i, j))
            }
        }

    init {
        //initialise the board using pieceFactory
        //DIRECTION = 1 //BLACK

        setupPieces(Color.Black)
        setupPieces(Color.White)

        for (i in 0 until 8) {
            for (j in 0 until 8) {
                map[Position(i, j)] = board[i][j]
            }
        }
    }

    private fun setupPieces(color: Color) {

        val pawnsRows = if (color == Color.Black) 1 else 6
        val startingRow = if (color == Color.Black) 0 else 7

        //setup pawns
        for (col in 0 until 8) {
            board[pawnsRows][col] = PieceFactory.getPiece(PieceType.Pawn, color, Position(pawnsRows, col))
        }

        //rooks
        board[startingRow][0] = PieceFactory.getPiece(PieceType.Rook, color, Position(startingRow, 0))
        board[startingRow][7] = PieceFactory.getPiece(PieceType.Rook, color, Position(startingRow, 7))
        //knights
        board[startingRow][1] = PieceFactory.getPiece(PieceType.Knight, color, Position(startingRow, 1))
        board[startingRow][6] = PieceFactory.getPiece(PieceType.Knight, color, Position(startingRow, 6))

        //bishops
        board[startingRow][2] = PieceFactory.getPiece(PieceType.Bishop, color, Position(startingRow, 2))
        board[startingRow][5] = PieceFactory.getPiece(PieceType.Bishop, color, Position(startingRow, 5))

        //Queen
        board[startingRow][3] = PieceFactory.getPiece(PieceType.Queen, color, Position(startingRow, 3))

        //KING
        board[startingRow][4] = PieceFactory.getPiece(PieceType.King, color, Position(startingRow, 4))
    }

    fun addPiece(pos: Position, piece: Piece) {
        map[pos] = piece
        board[pos.row][pos.col] = piece
    }

    fun remove(pos: Position) {
        map[pos] = PieceFactory.getPiece(PieceType.None, Color.None, pos)
        board[pos.row][pos.col] = PieceFactory.getPiece(PieceType.None, Color.None, pos)
    }

    fun isOccupied(pos: Position) = board[pos.row][pos.col].getPieceType() != PieceType.None

    fun getPiece(pos: Position) = board[pos.row][pos.col]

    fun display() {
        //Display the complete board
        for (i in 0 until 8) {
            for (j in 0 until 8) {
                print(board[i][j].getSymbol() + " ")
            }
            print("\n")
        }
    }

    fun isValid(pos: Position): Boolean {
        return !(pos.row < 0 || pos.col < 0 || pos.row >= 8 || pos.col >= 8)
    }

    fun getAllPieces(color: Color): HashMap<Position, Piece> {
        val piecesList = HashMap<Position, Piece>()

        for (keyValue in map) {
            val piece = keyValue.value

            if (piece.getColor() == color) {
                piecesList[keyValue.key] = keyValue.value
            }
        }
        return piecesList
    }

    fun getKingPosition(color: Color): Position {
        var position: Position? = null
        for (keyValue in map) {
            val piece = keyValue.value

            if (piece.getColor() == color && piece.getPieceType() == PieceType.King) {
                position = keyValue.key
            }
        }
        return position!!
    }

//    fun getBoard() = board


}