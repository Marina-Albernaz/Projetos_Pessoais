package br.com.vision;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Header extends JPanel implements MouseListener, MouseMotionListener{

	int x,y;
	
	Calculator c;
	HeaderButton jBexitbtn ;
	HeaderButton jBminimizebtn;
	
	public Header() {
		
		setBackground(new Color(46, 49, 50));
		setSize(new Dimension(233, 13));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		jBexitbtn = new ExitButton();
		jBminimizebtn = new MinimizeButton();
		
		Icon exitIcon = new ImageIcon("icons/icon-exit.png");
		jBexitbtn.setIcon(exitIcon);
		jBexitbtn.addMouseListener(jBexitbtn);
		
		Icon minimizeIcon = new ImageIcon("icons/icon-minimize.png");
		jBminimizebtn.setIcon(minimizeIcon);
		jBminimizebtn.addMouseListener(jBminimizebtn);
		
		
		add(jBminimizebtn);
		add(jBexitbtn);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int xx = e.getXOnScreen();
		int yy = e.getYOnScreen();
		
		c.setLocation(xx - x, yy - y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setC(Calculator c) {
		this.c = c;
	}
	
	
}
