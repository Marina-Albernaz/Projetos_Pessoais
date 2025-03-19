package br.com.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.model.Memory;

@SuppressWarnings("serial")
public class Button extends JButton implements KeyListener, ActionListener{
	
	public Button(String placeholder, Color color) {
		
		this.setText(placeholder);
		this.setBackground(color);
		this.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10), 3));
		this.setOpaque(true);
		this.setFont(new Font("Trebuchet MS ", Font.PLAIN, 23));
		this.setForeground(Color.WHITE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		} else if(e.getKeyCode() == 127) {
			Memory.getInstance().processCommand("AC");
		} else if(e.getKeyCode() == 8) {
			Memory.getInstance().processCommand("⌫");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			Memory.getInstance().processCommand(button.getText());
	}
	
	}
}
