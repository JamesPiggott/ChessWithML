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

	@Override
	public boolean checkMoveforCorrectness(int firstPosition, int thirdPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
