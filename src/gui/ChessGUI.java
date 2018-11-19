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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessGUI extends JFrame implements ActionListener {
	
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
        JPanel p3 = new JPanel();
        
        Container cc = getContentPane();
        cc.setLayout(new FlowLayout());
        cc.add(p1, BorderLayout.NORTH); 
              
        
       	p3.setLayout(new GridLayout(8,8));
		Dimension d = new Dimension(65, 65);
       	for (int i = 0; i <= 63; i = i+1) {
       		JButton button = new JButton();
       		button.addActionListener(this);
       		Color color = new Color(255);
       		button.setBackground(color);
       		p3.add(button);
       		
//			( (JButton) p3.add(new JButton(""+i))).addActionListener(this);
			p3.getComponent(i).setPreferredSize(d);
			p3.getComponent(i).setEnabled(true);
		}
       	p1.add(p3, BorderLayout.CENTER);
       	
       	
        this.newframe = new JFrame();
        this.newframe.add(cc);
        this.newframe.setVisible(true);
        this.newframe.setSize(750, 650);
        
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();	
		
		if (button.getBackground().getBlue() == 0) {
	   		Color color = new Color(255);
			((Component) arg0.getSource()).setBackground(color);
		} else {
	   		Color color = new Color(0);
			((Component) arg0.getSource()).setBackground(color);
		}
				
	}

}
