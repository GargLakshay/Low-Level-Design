package entities

import entities.StandardRules
import enums.Color
import enums.STATUS
import interfaces.ChessRules
import interfaces.Colleague
import interfaces.Mediator
import model.Message
import model.Move
import model.Position

class Match(private val user1: Colleague, private val user2: Colleague) : Mediator {
    private var matchId = 0
    var board: Board
    private var turn = Color.White//Black turn
    private val chessRules: ChessRules = StandardRules()
    private val messageList = arrayListOf<Message>()
    private val moveList = arrayListOf<Move>()
    private var status = STATUS.NOTSTARTED

    init {
        status = STATUS.PROGRESSING
        matchId = ++idCounter
        board = Board()
        user1.setMediator(this)
        user2.setMediator(this)

        //set piece color of players
        user1.setColor(Color.Black)
        user2.setColor(Color.White)
    }

    companion object {
        private var idCounter = 0
    }

    override fun sendMessage(sender: Colleague, msg: String) {
        val receiver = if (sender.getUserColor() == user1.getUserColor()) user2 else user1
        val message = Message(sender, msg)
        receiver.receiveMessage(message)
        messageList.add(message)
    }

    private fun setTurn(turn: Color) {
        this.turn = turn
    }

    private fun getTurn() = this.turn


    fun makeMove(from: Position, to: Position, user: Colleague) {
        //is this user hasn't its turn
        if (turn != user.getUserColor()) {
            println("Invalid user turn")
        }

        //check is it valid move
        val isValid = chessRules.isValidMove(from, to, board)

        if (!isValid) {
            println("Invalid move by ${user.getUserName()}")
            return
        }

        //its valid move
        //make the move, update the board
        val currentPiece = board.getPiece(from)
        val capturedPiece = board.getPiece(to)
        val move = Move(from, to, currentPiece, capturedPiece)
        moveList.add(move)
        board.remove(from)
        board.addPiece(to, currentPiece)

        //update turn
        turn = if (turn == Color.Black) Color.White
        else Color.Black

        //after making the move , check the other user isInCheck, checkmate, or stalemate

        val opponentUser = if (turn == user1.getUserColor()) user1 else user2
        if (chessRules.isCheckMate(turn, board)) {
            println("${opponentUser.getUserName()} is in checkMate ")
            //opponent loses, update
            quitGame(opponentUser)
            status = STATUS.COMPLETED
        } else if (chessRules.isInCheck(turn, board)) {
            println("${opponentUser.getUserName()} is in check ")
        } else if (chessRules.isStaleMate(turn, board)) {
            println("${opponentUser.getUserName()} is in stalemate ")
            // no one wins, update status of match Completed
            status = STATUS.COMPLETED
        }

        board.display()

    }

    private fun quitGame(user: Colleague) {
        //make the other user win, and update the score
        val opponentUser = if (user.getUserColor() == user1.getUserColor()) user2 else user1
        println("${opponentUser.getUserName()} wins")
        opponentUser.updateUserScore(10)
        user.updateUserScore(-10)
        //update status of match, Completed
        status = STATUS.COMPLETED

    }

    fun getUser1() = user1
    fun getUser2() = user2
    fun getStatus() = status
//    fun getStatus() = status
}