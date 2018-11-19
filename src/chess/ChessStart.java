package chess;

import gui.ChessGUI;

/**
 * This class will start the game.
 * @author James Piggott - November 18th 2018
 *
 */
public class ChessStart {
	public static void main(String[] args) {
			
				
    	Game game = new Game();
    	game.start();
    	ChessGUI gui = new ChessGUI(game.getBoard());
    	
    }
}
