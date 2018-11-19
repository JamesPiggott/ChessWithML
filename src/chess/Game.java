package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	
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
    }

	public void start() {
		
        System.out.println("Welcome to The Island, a chess implementation coded to test Artificial Intelligence algorithms"); 
		
		while (inprogress == true) {
	        System.out.println("Press 1 to play a game of chess");
	        System.out.println("Press 0 to discontinue The Island");
	        String gamechoice = "";
		        
	        try {
	        	gamechoice = br.readLine();
	         } catch (IOException ioe) {
	            System.out.println("IO error trying to read your input!");
	            System.exit(1);
	         }
	        if (gamechoice.equals("1")) {
	        	this.createPlayers();
	        	this.createBoard();
	        	this.playGame();
	        } else if (gamechoice.equals("0")) {
	        	System.out.println("The Islands will now discontinue");
	        	System.exit(0);
	        }
		}
	}

	private void createPlayers() {
        System.out.println("Select number of players (0, 1 or 2): ");
        try {
			this.playernumber = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
        if (this.playernumber == 2) {
        	this.player1 = new Player();
        	this.player2 = new Player();
            System.out.println("Input name of player 1: White");
            String name1 = "";
			try {
				name1 = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
            player1.setNameAndColour(name1, true);
            System.out.println("Input name of player 2: Black");
            String name2 = "";
			try {
				name2 = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
            player2.setNameAndColour(name2, false);
            
        }
        if (this.playernumber == 1) {
        	this.player1 = new Player();
            System.out.println("Which side do you choose to play? Black or White");
            
            
            System.out.println("Input your name");
            String name1 = "";
			try {
				name1 = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
            player1.setNameAndColour(name1, true);
        } else {
            System.out.println("Both opponents will play as A.I.");
        }
	}
	
	private void createBoard() {
		this.board = new Chessboard();
	}
	
	public Chessboard getBoard() {
		return this.board;
	}
	
	private void playGame() {
		System.out.println("The first move is for player " + player1.name + ". Who will play for White");
		this.nextPlayer = player1;
		
		while (inprogress) {
			board.showBoard();
			
			System.out.println(nextPlayer.name + ". What is your next move?");
			

			try {
				boolean moveinprogress = true;
				while (moveinprogress) {
				
					System.out.println("Select square from which to move your piece");
		            String piece = br.readLine();
		                       	            
		            System.out.println("Select square to capture with your piece");
		            String capture = br.readLine();
		            
		            String move = piece + " " + capture;
		            moveinprogress = board.performMove(move.toLowerCase(), this.nextPlayer);
		            
		            if (moveinprogress) {
		            	System.out.println("The move was not valid. Please check your coordinates");
		            }
	            
				}
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("A move has been made!");
			if (this.board.checkForCheckMate() == true) {
				System.out.println("It is check mate!");
				this.inprogress = false;
			} else {
				this.inprogress = true;
			}
				
			
			if (this.nextPlayer == player1) {
				this.nextPlayer = player2;
			} else {
				this.nextPlayer = player1;
			}
		}
	}
}
