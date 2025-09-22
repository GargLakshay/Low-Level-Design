#include<bits/stdc++.h>
using namespace std;
#include "Piece.h"

class Board {
private:
	int size;
	vector<vector<Piece>> board;
public:
	Board(int size) {
		this->size = size;
		board.clear();
		board.resize(size, vector<Piece> (size, Piece::None));
	}

	void printBoard() {
		for (auto i : board) {
			for (auto j : i) {
				if (j == Piece::Circle) {
					cout << "O ";
				} else if (j == Piece::Cross) {
					cout << "X ";
				} else {
					cout << ". ";
				}
			}
			cout << endl;
		}
	}

	int checkPlayerWin() {
		return checkRowWin() || checkColumnWin() || checkDiagonalWin();
	}

	int checkRowWin() {
		for (int i = 0; i < size; i++) {
			Piece piece = board[i][0];
			if (piece != Piece::None) {
				int f = 1;
				for (int j = 0; j < size; j++) {
					Piece curr = board[i][j];
					if (piece != curr) {
						f = 0;
						break;
					}
				}
				if (f) return 1;
			}
		}
		return 0;
	}

	int checkColumnWin() {
		for (int j = 0; j < size; j++) {
			Piece piece = board[0][j];
			if (piece != Piece::None) {
				int f = 1;
				for (int i = 0; i < size; i++) {
					Piece curr = board[i][j];
					if (piece != curr) {
						f = 0;
						break;
					}
				}
				if (f) return 1;
			}
		}
		return 0;
	}

	int checkDiagonalWin() {
		Piece piece = board[0][0];
		if (piece != Piece::None) {
			if (piece == board[1][1] && piece == board[2][2]) {
				return 1;
			}
		}
		piece = board[0][2];
		if (piece != Piece::None) {
			if (piece == board[1][1] && piece == board[2][0]) {
				return 1;
			}
		}
		return 0;
	}

	int checkForDraw() {
		for (auto i : board) {
			int f = 1;
			for (auto j : i) {
				if (j == Piece::None) {
					f = 0;
					break;
				}
			}
			if (f == 0) {
				return 0;
			}
		}
		return 1;
	}

	int checkValidRowColumn(int r, int c) {
		if (r < 0 || c < 0 || r >= size || c >= size) return 0;
		return 1;
	}
	
	int alreadOccupied(int r, int c) {
		if (board[r][c] != Piece::None) return 1;
		return 0;
	}
	
	void addPiece(Piece piece, int r, int c) {
		board[r][c] = piece;
	}
};
