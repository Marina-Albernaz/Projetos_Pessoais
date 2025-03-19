package br.com.vision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.model.Memory;
import br.com.model.MemoryObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoryObserver{

	JLabel moneyLabel1 = new JLabel("",SwingConstants.LEFT);
	JLabel moneyLabel2 = new JLabel("",SwingConstants.RIGHT);

	public Display() {
		Memory.getInstance().addObserver(this);
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.DARK_GRAY));
		this.setBackground(new Color(10,10, 10));
		
		moneyLabel1.setSize(new Dimension(470, 80));
		moneyLabel2.setSize(new Dimension(470, 80));
		
		moneyLabel1.setForeground(Color.WHITE);
		moneyLabel2.setForeground(Color.WHITE);
		
		
		moneyLabel1.setSize(new Dimension(400, 100));
		moneyLabel2.setSize(new Dimension(400, 100));
		
		moneyLabel1.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		moneyLabel2.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		
		moneyLabel1.setText(Memory.getInstance().getTypedText());
		moneyLabel2.setText(Memory.getInstance().getConvertedText());
		
		moneyLabel1.setBorder(BorderFactory.createEmptyBorder(10,100, 10, 0));
		moneyLabel2.setBorder(BorderFactory.createEmptyBorder(10,0, 10, 100));
		
		this.add(moneyLabel1, BorderLayout.WEST);
		this.add(moneyLabel2, BorderLayout.EAST);
		
		
	}
	
	public void setValue1(String text1) {
		moneyLabel1.setText(text1);
	}
	
	public void setValue2(String text2) {
		moneyLabel2.setText(text2);
	}
	
}
