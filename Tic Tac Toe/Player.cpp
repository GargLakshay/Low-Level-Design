#include <string>
#include "Piece.h"
using namespace std;

class Player {
private:
	string name;
	Piece piece;
public:

	Player(){

	}

	Player(string name, Piece piece) {
		this->name = name;
		this->piece = piece;
	}

	Piece getPiece() {
		return piece;
	}

	string getName() {
		return name;
	}
};