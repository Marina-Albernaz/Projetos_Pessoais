package br.com.vision;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MainScreen extends JFrame{
	
	public MainScreen() {

		this.setSize(new Dimension(1000, 335));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Money Conversion Calculator");
		this.add(new MainPanel());
		
		this.setLayout(new BorderLayout());
	
	}

	public static void main(String[] args) {
		
		MainScreen frame = new MainScreen();
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
}
