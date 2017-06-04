package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void Game_constructor_test() {
		Game game  = new Game();
		assertNotNull(game);
		assertTrue(game.inprogress);
	}

}
