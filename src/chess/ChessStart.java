package chess;

/**
 * This class will start the game.
 * @author James Piggott
 *
 */
public class ChessStart {
	public static void main(String[] args) {
		
		int result = 19 / 8;
		
		System.out.println("Result is: " + result);
		
		
        	Game game = new Game();
        	game.start();
    }
}
