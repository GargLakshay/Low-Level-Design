Requirements:
- we can have multiple users playing at the same time
- score based match making algorithm
- we can have standard chess rules but can be scalable
- users within a match can also send/receive messages
- user can quit the match in between



entities:

Game:
-
- map<matchId,match> matches
- map<userId,user> users

Mediator:
-
- sendMessage(message)
- receiveMessage(message)

Match: Mediator
-
- matchId
- board
- user1
- user2
- isBlackTurn
- chessRules //pending
- list<Moves> moveList
- list<Messages> messageList
* sendMessage(message)
* receiveMessage(message)

Board:
-
- piece [8][8]
- pieceFactory
* initializeBoard()
* getPiece(pos)
* isOccupied(pos)
* addPiece(pos)
* removePiece(pos)
* displayBoard()

Position:
-
- row
- col


Colleague:
-
- Mediator m
* sendMessage(message,this)
* receiveMessage(message)

User: Colleague
-
- userId
- userName
- color
- score
* sendMessage(message,this)
* receiveMessage(message)

Color:
-
- white
- black


PieceType:
-
- {King,Queen,Rook,Bishop,Knight,Pawn}

Symbol:
-
- {K,Q,R,B,N,P}

Piece:
-
- pieceType
- Color
- symbol
- position
- isMovedFirstTime
* getPossibleMoves()

PieceFactory:
- 
* getPiece(pieceType) : Piece
