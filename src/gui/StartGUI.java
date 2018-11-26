package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chess.Game;

public class StartGUI extends JFrame implements ActionListener {
	
	private JButton     startGame;
	private JTextField 	tfnumberOfPlayers;
	private JTextField 	tfPlayer1;
	private JTextField 	tfPlayer2;
	private Game 		game;
	
	public StartGUI(Game game) {
		super("Start GUI");
		this.game = game;
        buildGUI();
        setVisible(true);
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                }
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
	}

	private void buildGUI() {
		setSize(600,200);
		setResizable(false);
		
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel pp = new JPanel(new GridLayout(2,2));

        JLabel numberOfPlayers = new JLabel("# of players: ");
        tfnumberOfPlayers = new JTextField("", 12);
        tfnumberOfPlayers.setEditable(true);
        
        JLabel lbPlayer1 = new JLabel("Player 1: ");
        tfPlayer1 = new JTextField("Mr. White", 12);
        tfPlayer1.setEditable(true);

        JLabel lbPlayer2 = new JLabel("Player 2:");
        tfPlayer2 = new JTextField("Mr. Black", 5);
        tfPlayer2.setEditable(true);

        pp.add(numberOfPlayers);
        pp.add(tfnumberOfPlayers);
        pp.add(lbPlayer1);
        pp.add(tfPlayer1);
        pp.add(lbPlayer2);
        pp.add(tfPlayer2);

        startGame = new JButton("Start chess game");
        startGame.addActionListener(this);
        startGame.setEnabled(true);
        
        p1.add(pp, BorderLayout.NORTH);
        p1.add(startGame, BorderLayout.SOUTH);
        
        Container cc = getContentPane();
        cc.setLayout(new FlowLayout());
        cc.add(p1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String numberOfPlayers = tfnumberOfPlayers.getText();
		String namePlayerOne = "";
		String namePlayerTwo = "";
		
		if (numberOfPlayers.equals("0")) {
			namePlayerOne = tfPlayer1.getText();
			namePlayerTwo = tfPlayer2.getText();
		}
		if (numberOfPlayers.equals("1")) {
			namePlayerOne = tfPlayer1.getText();
			namePlayerTwo = tfPlayer2.getText();
		}
		if (numberOfPlayers.equals("2")) {
			namePlayerOne = tfPlayer1.getText();
			namePlayerTwo = tfPlayer2.getText();
		}
		game.createPlayers(Integer.parseInt(numberOfPlayers), namePlayerOne, namePlayerTwo);
//		dispose(); 
	}
}
