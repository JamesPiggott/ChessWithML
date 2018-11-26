package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gui.ChessGUI;
import gui.StartGUI;

public class Game {
	
	boolean gameBeingSetup;
	boolean inprogress;
    int playernumber;
    BufferedReader br;
    Player player1;
    Player player2;
	private Player nextPlayer;
	private Chessboard board;
    
    
    public Game() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.inprogress = true;
        this.gameBeingSetup = true;
    }

	public void start() {
			
		while (inprogress == true) {

			StartGUI start = new StartGUI(this);
			while (gameBeingSetup == true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.createBoard();
	        this.playGame();

		}
	}

	public void createPlayers(int numberOfPlayers, String playerOne, String playerTwo) {
        this.playernumber = numberOfPlayers;
        if (this.playernumber == 2) {
        	this.player1 = new Player();
        	this.player2 = new Player();

            String name1 = playerOne;
            player1.setNameAndColour(name1, true);

            String name2 = playerTwo;
            player2.setNameAndColour(name2, false);
            
        }
        if (this.playernumber == 1) {
        	this.player1 = new Player();
            String name1 = playerOne;
            player1.setNameAndColour(name1, true);
        } 
        this.gameBeingSetup = false;
	}
	
	private void createBoard() {
		this.board = new Chessboard();
	}
	
	public Chessboard getBoard() {
		return this.board;
	}
	
	public Player getNextPlayer() {
		return this.nextPlayer;
	}
	
	private void playGame() {

		this.nextPlayer = player1;
		
		while (inprogress) {
			ChessGUI gui = new ChessGUI(this);
			board.showBoard();
	

			try {
				boolean moveinprogress = true;
				while (moveinprogress) {

		            String piece = br.readLine();

		            String capture = br.readLine();
		            
		            String move = piece + " " + capture;
		            moveinprogress = board.performMove(move.toLowerCase(), this.nextPlayer, false);
		            
		            if (moveinprogress) {
		            	System.out.println("The move was not valid. Please check your coordinates");
		            }

				}
	            
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void checkForMate() {
		if (this.board.checkForCheckMate() == true) {
			System.out.println("It is check mate!");
			this.inprogress = false;
		} else {
			this.inprogress = true;
		}
	}
	
	public void assignNextPlayer() {
		if (this.nextPlayer == player1) {
			this.nextPlayer = player2;
		} else {
			this.nextPlayer = player1;
		}
	}
}
