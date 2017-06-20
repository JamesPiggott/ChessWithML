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
		if (isPossibleMove(firstPosition, thirdPosition) && isOnTheBoard(firstPosition, thirdPosition)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private boolean isPossibleMove(int firstPosition, int thirdPosition) {
		if (firstPosition + 7 == thirdPosition || firstPosition - 7 == thirdPosition || firstPosition + 14  == thirdPosition || firstPosition - 14 == thirdPosition || firstPosition + 21 == thirdPosition || firstPosition - 21 == thirdPosition || firstPosition + 28 == thirdPosition || firstPosition - 28 == thirdPosition || firstPosition + 35 == thirdPosition || firstPosition - 35 == thirdPosition || firstPosition + 42 == thirdPosition || firstPosition - 42 == thirdPosition || firstPosition + 49 == thirdPosition || firstPosition - 49 == thirdPosition) {
			return true;
		} else if (firstPosition + 9 == thirdPosition || firstPosition - 9 == thirdPosition || firstPosition + 18  == thirdPosition || firstPosition - 18 == thirdPosition || firstPosition + 27 == thirdPosition || firstPosition - 27 == thirdPosition || firstPosition + 36 == thirdPosition || firstPosition - 36 == thirdPosition || firstPosition + 45 == thirdPosition || firstPosition - 45 == thirdPosition || firstPosition + 54 == thirdPosition || firstPosition - 54 == thirdPosition || firstPosition + 63 == thirdPosition || firstPosition - 63 == thirdPosition) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isOnTheBoard(int firstPosition, int thirdPosition) {
		if ((firstPosition >= 0 || firstPosition <= 7) && thirdPosition < 0) {
			return false;
		}
		
		if ((firstPosition >= 56 || firstPosition <= 63) && thirdPosition > 63) {
			return false;
		}
		
		if (firstPosition == 8 || firstPosition == 16 || firstPosition == 24 || firstPosition == 32 || firstPosition == 40 || firstPosition == 48) {
			if (thirdPosition == firstPosition - 9 || thirdPosition == firstPosition + 7 || thirdPosition == firstPosition - 1) {
				return false;
			}
		}
		
		if (firstPosition == 15 || firstPosition == 23 || firstPosition == 31 || firstPosition == 39 || firstPosition == 47 || firstPosition == 55) {
			if (thirdPosition == firstPosition + 9 || thirdPosition == firstPosition - 7 || thirdPosition == firstPosition + 1) {
				return false;
			}
		}
		
		if (firstPosition == 56 && thirdPosition == firstPosition - 1) {
			return false;
		}
				
		if (firstPosition == 7 && thirdPosition == firstPosition + 1 ) {
			return false;
		}
		return true;
	}

}
