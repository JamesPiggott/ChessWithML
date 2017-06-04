package pieces;

import chess.Pieces;

public class Knight implements Pieces {
	
	boolean isWhite;
	String pieceName = "Knight";
	
	public Knight(boolean colour) {
		this.isWhite = colour;
	}
	
	public boolean getColour() {
		return this.isWhite;
	}
	
	public String getPiece() {
		return this.pieceName;
	}

	public boolean checkMoveforCorrectness(int firstPosition, int thirdPosition) {
		if (isPossibleMove(firstPosition, thirdPosition) && isOnTheBoard(firstPosition, thirdPosition)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isPossibleMove(int firstPosition, int thirdPosition) {
		int thirdremain = thirdPosition % 8;
		
		if (firstPosition + 7 == thirdPosition || firstPosition - 7 == thirdPosition || firstPosition + 15  == thirdPosition || firstPosition - 15 == thirdPosition || firstPosition + 23 == thirdPosition || firstPosition - 23 == thirdPosition || firstPosition + 31 == thirdPosition || firstPosition - 31 == thirdPosition || firstPosition + 39 == thirdPosition || firstPosition - 39 == thirdPosition || firstPosition + 48 == thirdPosition || firstPosition - 48 == thirdPosition || firstPosition + 56 == thirdPosition || firstPosition - 56 == thirdPosition) {
			return true;
		} else if ((firstPosition / 8 == thirdPosition / 8) && (thirdremain >= 0 || thirdremain <= 7)){
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
