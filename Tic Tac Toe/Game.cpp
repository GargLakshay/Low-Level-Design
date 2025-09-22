#include<bits/stdc++.h>
using namespace std;
#include "Player.cpp"
#include "Board.cpp"
#include "Piece.h"

class Game {
private:
	vector<Player*> playerList;
	Board* board = NULL;
public:

	void startGame() {

		cout << "Enter no. of players want to play Tick-Toe" << endl;
		int noOfPlayers;
		cin >> noOfPlayers;

		cout << "Enter board size" << endl;
		int boardSize;
		cin >> boardSize;

		playerList.resize(noOfPlayers);
		board = new Board(boardSize);

		set<string> st;
		st.insert("Circle");
		st.insert("Cross");
		for (int i = 0; i < noOfPlayers; i++) {

			cout << "Enter " << i + 1 << " Player name" << endl;
			string name;
			cin >> name;
			while (1) {
				cout << "Enter " << i + 1 << " Player playing piece : Cross or Circle" << endl;
				string pieceName;
				cin >> pieceName;
				if (pieceName == "Cross" || pieceName == "Circle") {
					if (st.find(pieceName) != st.end()) {
						st.erase(pieceName);
						Piece piece = Piece::None;
						if (pieceName == "Cross") piece = Piece::Cross;
						else piece = Piece::Circle;

						Player* player = new Player(name, piece);
						playerList[i] = player;
						break;
					} else {
						cout << "This pieceName already taken by other person, try again" << endl;
					}
				} else {
					cout << "Invalid piece Name, write exact Name" << endl;
				}
			}
		}


		int playerTurn = 0;
		while (1) {
			//read input from user
			cout << playerList[playerTurn]->getName() << " turns, Input row and column " << endl;
			int r, c;
			cin >> r >> c;
			if (!board->checkValidRowColumn(r, c)) {
				cout << "Please try again, Input row and column are not valid " << endl;
				continue;
			}
			if (board->alreadOccupied(r, c)) {
				cout << "Please try again, Input row and column are already occupied " << endl;
				continue;
			}

			board->addPiece(playerList[playerTurn]->getPiece(), r, c);

			board->printBoard();

			if (board->checkPlayerWin()) {
				cout << "Player " << playerList[playerTurn]->getName() << " Wins.!!" << endl;
				break;
			}

			if (board->checkForDraw()) {
				cout << "Draw" << endl;
				break;
			}

			playerTurn = 1 - playerTurn;
		}
	}
};