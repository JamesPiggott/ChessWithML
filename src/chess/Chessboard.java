package chess;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Chessboard {
	
	private Pieces[] board;
	
	public Chessboard() {
		this.setBoard(new Pieces[64]);
		setPieces();
	}
	
	public void showBoard() {
//		System.out.println("*************************************************************************");
//		System.out.println("* " + this.getBoard()[56].getPiece() + " * " + this.getBoard()[57].getPiece() + " * "  + this.getBoard()[58].getPiece() + " * "  + this.getBoard()[59].getPiece() + " * "  + this.getBoard()[60].getPiece() + " * "  + this.getBoard()[61].getPiece() + " * "  + this.getBoard()[62].getPiece() + " * "  + this.getBoard()[63].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[48].getPiece() + " * " + this.getBoard()[49].getPiece() + " * "  + this.getBoard()[50].getPiece() + " * "  + this.getBoard()[51].getPiece() + " * "  + this.getBoard()[52].getPiece() + " * "  + this.getBoard()[53].getPiece() + " * "  + this.getBoard()[54].getPiece() + " * "  + this.getBoard()[55].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[40].getPiece() + " * " + this.getBoard()[41].getPiece() + " * "  + this.getBoard()[42].getPiece() + " * "  + this.getBoard()[43].getPiece() + " * "  + this.getBoard()[44].getPiece() + " * "  + this.getBoard()[45].getPiece() + " * "  + this.getBoard()[46].getPiece() + " * "  + this.getBoard()[47].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[32].getPiece() + " * " + this.getBoard()[33].getPiece() + " * "  + this.getBoard()[34].getPiece() + " * "  + this.getBoard()[35].getPiece() + " * "  + this.getBoard()[36].getPiece() + " * "  + this.getBoard()[37].getPiece() + " * "  + this.getBoard()[38].getPiece() + " * "  + this.getBoard()[39].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[24].getPiece() + " * " + this.getBoard()[25].getPiece() + " * "  + this.getBoard()[26].getPiece() + " * "  + this.getBoard()[27].getPiece() + " * "  + this.getBoard()[28].getPiece() + " * "  + this.getBoard()[29].getPiece() + " * "  + this.getBoard()[30].getPiece() + " * "  + this.getBoard()[31].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[16].getPiece() + " * " + this.getBoard()[17].getPiece() + " * "  + this.getBoard()[18].getPiece() + " * "  + this.getBoard()[19].getPiece() + " * "  + this.getBoard()[20].getPiece() + " * "  + this.getBoard()[21].getPiece() + " * "  + this.getBoard()[22].getPiece() + " * "  + this.getBoard()[23].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[8].getPiece() + " * " + this.getBoard()[9].getPiece() + " * "  + this.getBoard()[10].getPiece() + " * "  + this.getBoard()[11].getPiece() + " * "  + this.getBoard()[12].getPiece() + " * "  + this.getBoard()[13].getPiece() + " * "  + this.getBoard()[14].getPiece() + " * "  + this.getBoard()[15].getPiece() + " *");
//		System.out.println("* " + this.getBoard()[0].getPiece() + " * " + this.getBoard()[1].getPiece() + " * "  + this.getBoard()[2].getPiece() + " * "  + this.getBoard()[3].getPiece() + " * "  + this.getBoard()[4].getPiece() + " * "  + this.getBoard()[5].getPiece() + " * "  + this.getBoard()[6].getPiece() + " * "  + this.getBoard()[7].getPiece() + " *");
//		System.out.println("**************************************************************************");
	}
	
	public void setPieces() {
		// White
		this.getBoard()[0] = new Rook(true);
		this.getBoard()[1] = new Knight(true);
		this.getBoard()[2] = new Bishop(true);
		this.getBoard()[3] = new Queen(true);
		this.getBoard()[4] = new King(true);
		this.getBoard()[5] = new Bishop(true);
		this.getBoard()[6] = new Knight(true);
		this.getBoard()[7] = new Rook(true);
		
		this.getBoard()[8] = new Pawn(true);
		this.getBoard()[9] = new Pawn(true);
		this.getBoard()[10] = new Pawn(true);
		this.getBoard()[11] = new Pawn(true);
		this.getBoard()[12] = new Pawn(true);
		this.getBoard()[13] = new Pawn(true);
		this.getBoard()[14] = new Pawn(true);
		this.getBoard()[15] = new Pawn(true);
		
		// Black
		this.getBoard()[56] = new Rook(false);
		this.getBoard()[57] = new Knight(false);
		this.getBoard()[58] = new Bishop(false);
		this.getBoard()[59] = new Queen(false);
		this.getBoard()[60] = new King(false);
		this.getBoard()[61] = new Bishop(false);
		this.getBoard()[62] = new Knight(false);
		this.getBoard()[63] = new Rook(false);
		
		this.getBoard()[48] = new Pawn(false);
		this.getBoard()[49] = new Pawn(false);
		this.getBoard()[50] = new Pawn(false);
		this.getBoard()[51] = new Pawn(false);
		this.getBoard()[52] = new Pawn(false);
		this.getBoard()[53] = new Pawn(false);
		this.getBoard()[54] = new Pawn(false);
		this.getBoard()[55] = new Pawn(false);
		
		// Empties
		for (int i = 16; i <= 47; i++) {
			this.getBoard()[i] = new Empty();
		}
		
	}
	
	public boolean performMove(String moveFrom, String moveTo, Player player) {
		
		int fromPosition = Integer.parseInt(moveFrom);
		int toPosition = Integer.parseInt(moveTo);;
		
		Pieces from = getBoard()[fromPosition];
		Pieces to = getBoard()[toPosition];
		
		if (!from.checkMoveforCorrectness(fromPosition, toPosition)) {
			System.out.println("This is not an authorized move!");
			
			return true;
		}
		
		// Swap the pieces on the board according to the rules.
		if (from.getColour() == player.getColour()) {
			
			// option 1 - change position with an Empty piece
			if (to.getPiece().equals("      ")) {
				System.out.println("Moving to an empty square");
				getBoard()[fromPosition] = new Empty();
				getBoard()[toPosition] = from;
				
			// option 2 - change position with an Enemy piece
			} else if (from.getColour() != to.getColour()) {
				System.out.println("Moving to an enemy square");
				getBoard()[fromPosition] = new Empty();
				getBoard()[toPosition] = from;
			}

		} else {
			return false;
		}
		return false;
	}

			
	public void boardRules() {
		
	}

	public boolean checkForCheckMate() {
		return false;
	}

	public Pieces[] getBoard() {
		return board;
	}

	public void setBoard(Pieces[] board) {
		this.board = board;
	}

}
