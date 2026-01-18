package entities

import interfaces.BoardEntity
import interfaces.SetupStrategy

class Board(size: Int, setupStrategy: SetupStrategy) {
    val boardEntityList = arrayListOf<BoardEntity>()
    val boardMap = HashMap<Int, BoardEntity>() // from , Snake/Ladder

    init {
        setupBoard(this, setupStrategy)
    }

    fun setupBoard(board: Board, setupStrategy: SetupStrategy) {
        setupStrategy.setupBoard(board)
    }

    fun addBoardEntity(boardEntity: BoardEntity) {
        if (canAddBoardEntity(boardEntity)) {
            boardEntityList.add(boardEntity)
            boardMap[boardEntity.from] = boardEntity
        } else {
            println("Can't add, already there is ${boardMap[boardEntity.from]?.boardEntityType} at position: ${boardEntity.from}")
        }
    }

    fun displayBoard() {
        for (boardEntity in boardEntityList) {
            println(boardEntity.boardEntityType.toString() + "${boardEntity.from} + ${boardEntity.to}")
        }
    }

    fun canAddBoardEntity(boardEntity: BoardEntity): Boolean {
        return boardMap.containsKey(boardEntity.from)
    }
}