Requirements

- size of the board should be scalable
- there are standard game rules and should be further extensible
- there can be game setup strategy like Random setup, custom setup , standard setup etc.


Entities:

Game:
-
- userList : deque
- board
- status
- gameRules
* addUserToGame()
* startGame()

GameRules:(standardRules,orAnyCustomRule)
-
- isValidMove(pos,boardSize)
- isWin(pos,boardSize)
- calFinalPosition(currPos, board)

Board:
- 
- listBoardEntity(type,from,to)
- map<from, boardEntity> map
- init { setupBoard(setupStrategy) }
* addBoardEntity(boardEntity)
* canAddBoardEntity()
* displayUserPositions()
* displayAllSnakes()
* displayAllLadders()

setupStrategy:(custom,random,standard)
-
- setupBoard(board)

BoardEntity:
-
- boardEntityType
- from 
- to
* display()

BoardEntityType:ENUM
-
-Snake, Ladder 

Status:(Enum)
-
- NOT_STARTED
- STARTED
- GAME_OVER

User:
-
- userId
- name
- position
* updatePosition()

Dice:
-
- noOfFaces
* rollDice()