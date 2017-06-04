package chess;

public class Player {
	
	String name;
	boolean colour;
	
	public Player() {
	}

	public void setNameAndColour(String name, boolean colour) {
		this.name = name;
		this.colour = colour;
	}
	
	public boolean getColour() {
		return this.colour;
	}
	

}
