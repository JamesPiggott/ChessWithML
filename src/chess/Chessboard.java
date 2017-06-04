package chess;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Chessboard {
	
	Pieces[] board;
	
	public Chessboard() {
		this.board = new Pieces[64];
		setPieces();
	}
	
	public void showBoard() {
		System.out.println("*************************************************************************");
		System.out.println("* " + this.board[56].getPiece() + " * " + this.board[57].getPiece() + " * "  + this.board[58].getPiece() + " * "  + this.board[59].getPiece() + " * "  + this.board[60].getPiece() + " * "  + this.board[61].getPiece() + " * "  + this.board[62].getPiece() + " * "  + this.board[63].getPiece() + " *");
		System.out.println("* " + this.board[48].getPiece() + " * " + this.board[49].getPiece() + " * "  + this.board[50].getPiece() + " * "  + this.board[51].getPiece() + " * "  + this.board[52].getPiece() + " * "  + this.board[53].getPiece() + " * "  + this.board[54].getPiece() + " * "  + this.board[55].getPiece() + " *");
		System.out.println("* " + this.board[40].getPiece() + " * " + this.board[41].getPiece() + " * "  + this.board[42].getPiece() + " * "  + this.board[43].getPiece() + " * "  + this.board[44].getPiece() + " * "  + this.board[45].getPiece() + " * "  + this.board[46].getPiece() + " * "  + this.board[47].getPiece() + " *");
		System.out.println("* " + this.board[32].getPiece() + " * " + this.board[33].getPiece() + " * "  + this.board[34].getPiece() + " * "  + this.board[35].getPiece() + " * "  + this.board[36].getPiece() + " * "  + this.board[37].getPiece() + " * "  + this.board[38].getPiece() + " * "  + this.board[39].getPiece() + " *");
		System.out.println("* " + this.board[24].getPiece() + " * " + this.board[25].getPiece() + " * "  + this.board[26].getPiece() + " * "  + this.board[27].getPiece() + " * "  + this.board[28].getPiece() + " * "  + this.board[29].getPiece() + " * "  + this.board[30].getPiece() + " * "  + this.board[31].getPiece() + " *");
		System.out.println("* " + this.board[16].getPiece() + " * " + this.board[17].getPiece() + " * "  + this.board[18].getPiece() + " * "  + this.board[19].getPiece() + " * "  + this.board[20].getPiece() + " * "  + this.board[21].getPiece() + " * "  + this.board[22].getPiece() + " * "  + this.board[23].getPiece() + " *");
		System.out.println("* " + this.board[8].getPiece() + " * " + this.board[9].getPiece() + " * "  + this.board[10].getPiece() + " * "  + this.board[11].getPiece() + " * "  + this.board[12].getPiece() + " * "  + this.board[13].getPiece() + " * "  + this.board[14].getPiece() + " * "  + this.board[15].getPiece() + " *");
		System.out.println("* " + this.board[0].getPiece() + " * " + this.board[1].getPiece() + " * "  + this.board[2].getPiece() + " * "  + this.board[3].getPiece() + " * "  + this.board[4].getPiece() + " * "  + this.board[5].getPiece() + " * "  + this.board[6].getPiece() + " * "  + this.board[7].getPiece() + " *");
		System.out.println("**************************************************************************");
	}
	
	public void setPieces() {
		// White
		this.board[0] = new Rook(true);
		this.board[1] = new Knight(true);
		this.board[2] = new Bishop(true);
		this.board[3] = new Queen(true);
		this.board[4] = new King(true);
		this.board[5] = new Bishop(true);
		this.board[6] = new Knight(true);
		this.board[7] = new Rook(true);
		
		this.board[8] = new Pawn(true);
		this.board[9] = new Pawn(true);
		this.board[10] = new Pawn(true);
		this.board[11] = new Pawn(true);
		this.board[12] = new Pawn(true);
		this.board[13] = new Pawn(true);
		this.board[14] = new Pawn(true);
		this.board[15] = new Pawn(true);
		
		// Black
		this.board[56] = new Rook(false);
		this.board[57] = new Knight(false);
		this.board[58] = new Bishop(false);
		this.board[59] = new Queen(false);
		this.board[60] = new King(false);
		this.board[61] = new Bishop(false);
		this.board[62] = new Knight(false);
		this.board[63] = new Rook(false);
		
		this.board[48] = new Pawn(false);
		this.board[49] = new Pawn(false);
		this.board[50] = new Pawn(false);
		this.board[51] = new Pawn(false);
		this.board[52] = new Pawn(false);
		this.board[53] = new Pawn(false);
		this.board[54] = new Pawn(false);
		this.board[55] = new Pawn(false);
		
		// Empties
		for (int i = 16; i <= 47; i++) {
			this.board[i] = new Empty();
		}
		
	}
	
	public boolean performMove(String move, Player player) {
		
		char first;
		char second;
		char third;
		char fourth;
		
		if (move.length() != 5) {
			return false;
		} else {
			first = move.charAt(0);
			second = move.charAt(1);
			third = move.charAt(3);
			fourth = move.charAt(4);
			
			System.out.println("Values: " + first + " " + second);
			System.out.println("Values: " + third + " " + fourth);
			
			int sec = Integer.parseInt("" + second);
			int fou = Integer.parseInt("" + fourth);
			
			if (!(sec >= 1 && sec <= 8 && fou >= 1 && fou <= 8)) {
				 return false;
			}
			
			if (!(first == 'a' || first == 'b' || first == 'c' || first == 'd' || first == 'e' || first == 'f' || first == 'g' || first == 'h')) {
				return false;
			}
			
			if (!(third == 'a' || third == 'b' || third == 'c' || third == 'd' || third == 'e' || third == 'f' || third == 'g' || third == 'h')) {
				return false;
			}
		}
		
		int firstPosition = getPosition(first) + ((Integer.parseInt("" + second)-1) * 8) - 1;
		int thirdPosition = getPosition(third) + ((Integer.parseInt("" + fourth)-1) * 8) - 1;
		System.out.println("Coordinate 1 is: " + firstPosition);
		System.out.println("Coordinate 2 is: " + thirdPosition);
		
		Pieces from = board[firstPosition];
		Pieces to = board[thirdPosition];
		
		if (!from.checkMoveforCorrectness(firstPosition, thirdPosition)) {
			System.out.println("This is not an authorized move!");
			
			return true;
		}
		
		
		if (from.getColour() == player.getColour()) {
			if (to.equals(Empty.class)) {
				System.out.println("Same colour");
				board[firstPosition] = to;
				board[thirdPosition] = from;
			} else {
				System.out.println("Not the same colour");
				board[firstPosition] = new Empty();
				board[thirdPosition] = from;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public int getPosition(char alphaposition) {
		int position = 0;
		switch (alphaposition) {
			case 'a':
			position = 1;
			break;
		case 'b':
			position = 2;
			break;
		case 'c':
			position = 3;
			break;
		case 'd':
			position = 4;
			break;
		case 'e':
			position = 5;
			break;
		case 'f':
			position = 6;
			break;
		case 'g':
			position = 7;
			break;
		case 'h':
			position = 8;
			break;
		}
		return position;
	}
			
	public void boardRules() {
		
	}

	public boolean checkForCheckMate() {

		return false;
	}

}
