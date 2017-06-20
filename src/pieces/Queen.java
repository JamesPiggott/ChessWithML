package pieces;

import chess.Pieces;

public class Queen implements Pieces {
	
	boolean isWhite;
	String pieceName = "Queen ";
	
	public Queen(boolean colour) {
		this.isWhite = colour;
	}
	
	public boolean getColour() {
		return this.isWhite;
	}
	
	public String getPiece() {
		return this.pieceName;
	}

	// Queen has the powers of the Rook and the Bishop
	public boolean checkMoveforCorrectness(int firstPosition, int thirdPosition) {
		
		
		
		

		return false;
	}

}
