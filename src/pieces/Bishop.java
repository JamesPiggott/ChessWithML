package pieces;

import chess.Pieces;

public class Bishop implements Pieces {
	
	boolean isWhite;
	String pieceName = "Bishop";
	
	public Bishop(boolean colour) {
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
