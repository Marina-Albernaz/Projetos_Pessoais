package br.com.vision;

import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MinimizeButton extends HeaderButton {

	public void mouseClicked(MouseEvent e) {
		c.minimize();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		c.minimize();
	}
	
}
