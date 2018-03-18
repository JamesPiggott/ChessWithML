package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessGUI extends JFrame {
	
	public JFrame newframe;
	
	public ChessGUI() {
        super("Client GUI");
        buildGUI();
//        setVisible(true);
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

//	private void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}

	private void buildGUI() {
        setSize(650,550);

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel pp = new JPanel(new GridLayout(4,2));
        
        
        Container cc = getContentPane();
        cc.setLayout(new FlowLayout());
        cc.add(p1, BorderLayout.NORTH); 
        
        this.newframe = new JFrame();
        this.newframe.add(cc);
        this.newframe.setVisible(true);
        this.newframe.setSize(750, 650);
		
	}

}
