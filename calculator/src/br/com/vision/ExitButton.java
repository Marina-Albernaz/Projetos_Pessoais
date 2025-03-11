package br.com.vision;

import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ExitButton extends HeaderButton {
	
	public void mouseClicked(MouseEvent e) {
		Calculator.exit();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Calculator.exit();
	}
	
	
	
}
