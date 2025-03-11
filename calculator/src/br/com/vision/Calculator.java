package br.com.vision;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	Header header;
	Display display ;
	Keyboard keyboard ;
	MinimizeButton hb;
	
	public Calculator() {
		
		hb = new MinimizeButton();
		header = new Header();
		display = new Display();
		keyboard = new Keyboard();
		organizeLayout();
		
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(232, 322);
		setLocationRelativeTo(null);
	}
	
	public static void exit() {
		System.exit(0);
	}
	
	public void minimize() {
		this.setState(JFrame.ICONIFIED);
	}
	
	private void organizeLayout() {
		setLayout(new BorderLayout());
		
		header.addMouseListener(header);
		header.addMouseMotionListener(header);
		
		add(header, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
		add(keyboard, BorderLayout.SOUTH);
		
		display.setPreferredSize(new Dimension(233, 62));
		keyboard.setPreferredSize(new Dimension(233, 257));
		
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator(); 
		c.header.setC(c);
		c.header.jBminimizebtn.setC(c); 
	}

}	
	

