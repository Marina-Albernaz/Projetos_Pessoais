package br.com.vision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{

	public MainPanel() {
		Display display = new Display();
		Keyboard keyboard = new Keyboard();
		
		this.setLayout(new BorderLayout());
		this.add(display, BorderLayout.NORTH);
		this.add(keyboard, BorderLayout.SOUTH);
		this.setBackground(new Color(10, 10, 10));
		this.setSize(new Dimension(1000, 300));
	}
	
}
