package entities

import enums.Status
import interfaces.Dice
import interfaces.GameRules
import interfaces.SetupStrategy
import java.util.Deque

class Game(faces: Int, private val boardSize: Int, setupStrategy: SetupStrategy) {


    private var dice: Dice = XFaceDice(faces)
    private val board: Board
    private var winsPlace = 1

    val gameRules: GameRules = StandardRules()
    var status = Status.NOT_STARTED
    val movesList = ArrayList<Move>()

    val usersList = ArrayList<User>()

    init {
        dice = XFaceDice(faces)
        board = Board(boardSize, setupStrategy)
    }

    fun createUser(name: String): User {
        return User(name)
    }

    fun addUser(user: User) {
        //add check if already game started, not to add user in list
        usersList.add(user)
    }

    fun startGame() {
        val dequeList = ArrayDeque<User>()
        for (user in usersList) dequeList.add(user)

        if (dequeList.size == 1) {
            println("There is only one user, need more users")
            return
        }
        status = Status.STARTED

        while (dequeList.size != 1) {
            val currUser = dequeList.first()
            val currPos = currUser.getPos()

            //remove the user from the list
            dequeList.removeFirst()

            val diceNo = dice.rollDice()

            //check if this move is valid
            if (!gameRules.isValidMove(currPos + diceNo, boardSize)) {
                //add the user into list
                val finalPosition = currPos + diceNo
                movesList.add(Move(currUser, currPos, currPos + diceNo, finalPosition))
                dequeList.add(currUser)
                println("Turn ${currUser.name}, from: ${currPos},to :${currPos}")
                continue
            }

            //now move is valid
            val finalPos = gameRules.calFinalPosition(currPos + diceNo, board)
            movesList.add(Move(currUser, currPos, currPos + diceNo, finalPos))
            println("Turn ${currUser.name}, from: ${currPos},to :${finalPos}")
            currUser.updatePos(finalPos)


            //now check if this user wins
            if (gameRules.isWin(finalPos, boardSize)) {
                //no need to add into queue , as this user has reached to target
                println(currUser.name + " wins !!, comes at $winsPlace place")
                winsPlace++
                continue
            }

            //now user reaches to some final pos, add into last of queue
            dequeList.add(currUser)
        }

        status = Status.GAME_OVER
    }
}