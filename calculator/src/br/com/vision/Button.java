package br.com.vision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.model.Memory;

@SuppressWarnings("serial")
public class Button extends JButton implements KeyListener {
	
	
	public Button(String label, Color color) {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(new Color(46, 49, 50), 2));
		setText(label);
		setOpaque(true);
		setBackground(color);
		setFont(new Font("Trebuchet MS ", Font.PLAIN, 23));
		setForeground(Color.WHITE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 48 || e.getKeyCode() == 96) {
			Memory.getInstance().processCommand("0");
		} else if(e.getKeyCode() == 49 || e.getKeyCode() == 97) {
			Memory.getInstance().processCommand("1");
		} else if(e.getKeyCode() == 50 || e.getKeyCode() == 98) {
			Memory.getInstance().processCommand("2");
		} else if(e.getKeyCode() == 51 || e.getKeyCode() == 99) {
			Memory.getInstance().processCommand("3");
		} else if(e.getKeyCode() == 52 || e.getKeyCode() == 100) {
			Memory.getInstance().processCommand("4");
		} else if(e.getKeyCode() == 53 || e.getKeyCode() == 101) {
			Memory.getInstance().processCommand("5");
		} else if(e.getKeyCode() == 54 || e.getKeyCode() == 102) {
			Memory.getInstance().processCommand("6");
		} else if(e.getKeyCode() == 55 || e.getKeyCode() == 103) {
			Memory.getInstance().processCommand("7");
		} else if(e.getKeyCode() == 56 || e.getKeyCode() == 104) {
			Memory.getInstance().processCommand("8");
		} else if(e.getKeyCode() == 57 || e.getKeyCode() == 105) {
			Memory.getInstance().processCommand("9");
		} else if(e.getKeyCode() == 8 || e.getKeyCode() == 127) {
			Memory.getInstance().processCommand("AC");
		} else if(e.getKeyCode() == 10) {
			Memory.getInstance().processCommand("=");
		} else if(e.getKeyCode() == 107) {
			Memory.getInstance().processCommand("+");
		} else if(e.getKeyCode() == 106) {
			Memory.getInstance().processCommand("×");
		} else if(e.getKeyCode() == 111) {
			Memory.getInstance().processCommand("÷");
		} else if(e.getKeyCode() == 109) {
			Memory.getInstance().processCommand("-");
		} else if(e.getKeyCode() == 16) {
			Memory.getInstance().processCommand("±");
		} else if(e.getKeyCode() == 46) {
			Memory.getInstance().processCommand(".");
		}
	}

}
