package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chess.Chessboard;
import chess.Game;

public class ChessGUI extends JFrame implements ActionListener {
	
	public JFrame newframe;
	private Game game;
	private boolean squareSelected;
	private String firstSquare;
	private String secondSquare;
	private JButton firstMove;
	private JPanel p3;
	
	public ChessGUI(Game game) {
		super("Chess board GUI");
        this.game = game;
        buildGUI();
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

        setSize(650,550);

        JPanel p1 = new JPanel(new BorderLayout());
        this.p3 = new JPanel();
        
        Container cc = getContentPane();
        cc.setLayout(new FlowLayout());
        cc.add(p1, BorderLayout.NORTH); 
              
       	p3.setLayout(new GridLayout(8,8));
		
		addGridBag(p3, 56, 63);
		addGridBag(p3, 48, 55);
		addGridBag(p3, 40, 47);
		addGridBag(p3, 32, 39);
		addGridBag(p3, 24, 31);
		addGridBag(p3, 16, 23);
		addGridBag(p3, 8, 15);
		addGridBag(p3, 0, 7);

       	p1.add(p3, BorderLayout.CENTER);
       	
        this.newframe = new JFrame();
        this.newframe.add(cc);
        this.newframe.setVisible(true);
        this.newframe.setSize(900, 900);
        squareSelected = false;   

	}
	
	public void addGridBag(JPanel panel, int start, int end) {
		Dimension d = new Dimension(100, 100);
       	for (int i = start; i <= end; i = i+1) {
       		JButton button = new JButton();
       		button.addActionListener(this);
       		Color color = new Color(255,255,255);
       		button.setBackground(color);

       		try {
           		if (this.game.getBoard().getBoard()[1].getPiece() != null) {
           			button.setText(this.game.getBoard().getBoard()[i].getPiece());
           		} else {
           			button.setText("");
           		}
       		} catch(Exception e) {
       			button.setText("");
       		}
       		button.setName(i + "");
       		panel.add(button);
       		button.setPreferredSize(d);
       		button.setEnabled(true);
		}
	}
	
	public void updateScreen() {
		updateGridBag(this.p3, 56, 63, 0, 7);
		updateGridBag(this.p3, 48, 55, 8, 15);
		updateGridBag(this.p3, 40, 47, 16, 23);
		updateGridBag(this.p3, 32, 39, 24, 31);
		updateGridBag(this.p3, 24, 31, 32, 39);
		updateGridBag(this.p3, 16, 23, 40, 47);
		updateGridBag(this.p3, 8, 15, 48, 55);
		updateGridBag(this.p3, 0, 7, 56, 63);
	}
	
	public void updateGridBag(Component panel, int start, int end, int startboard, int endboard) {
		for (int i = start; i <= end; i = i+1) {
   			((AbstractButton) this.p3.getComponent(i)).setText(this.game.getBoard().getBoard()[startboard].getPiece());
   			startboard++;
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		if (squareSelected == false) {
			firstSquare = button.getName();
			squareSelected = true;
			button.setEnabled(false);
			firstMove = button;
		} else {
			secondSquare = button.getName();	
			game.getBoard().performMove(firstSquare, secondSquare, game.getNextPlayer());
			firstMove.setEnabled(true);
			
			squareSelected = false;
			firstSquare = "";
			secondSquare = "";
			game.checkForMate();
			game.assignNextPlayer();
		}
		updateScreen();
	}
}
