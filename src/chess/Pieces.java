package chess;

public interface Pieces {
	
	public boolean getColour();
	
	public String getPiece();

	public boolean checkMoveforCorrectness(int firstPosition, int thirdPosition);
	
}
