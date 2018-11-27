package pieces;

import chess.Pieces;

public class Empty implements Pieces {

	String pieceName = "      ";
	
	public Empty() {

	}
	
	public String getPiece() {
		return this.pieceName;
	}

	public boolean getColour() {

		return true;
	}

	@Override
	public boolean checkMoveforCorrectness(int firstPosition, int thirdPosition) {
		// TODO Auto-generated method stub
		return false;
	}
}
