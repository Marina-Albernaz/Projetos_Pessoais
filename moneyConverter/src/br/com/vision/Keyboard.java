package br.com.vision;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.model.Memory;

@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener{
	
	GridBagConstraints gbc = new GridBagConstraints();

	public Keyboard() {
		
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0, 0, 0));
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		addButton(" 7 ", new Color(50, 50, 50), gbc, 0, 0);
		addButton(" 8 ", new Color(50, 50, 50), gbc, 1, 0);
		addButton(" 9 ", new Color(50, 50, 50), gbc, 2, 0);
		addButton("U$", new Color(100, 10, 10), gbc, 3, 0);
		addButton(" € ", new Color(100, 10, 10), gbc, 4, 0);
		addButton(" £ ", new Color(100, 10, 10), gbc, 5, 0);
	
		addButton(" 4 ", new Color(50, 50, 50), gbc, 0, 1);
		addButton(" 5 ", new Color(50, 50, 50), gbc, 1, 1);
		addButton(" 6 ", new Color(50, 50, 50), gbc, 2, 1);
		addButton("J¥", new Color(100, 10, 10), gbc, 3, 1);
		addButton("A$", new Color(100, 10, 10), gbc, 4, 1);
		addButton("C$", new Color(100, 10, 10), gbc, 5, 1);
		
		addButton(" 1 ", new Color(50, 50, 50), gbc, 0, 2);
		addButton(" 2 ", new Color(50, 50, 50), gbc, 1, 2);
		addButton(" 3 ", new Color(50, 50, 50), gbc, 2, 2);
		addButton(" ₣ ", new Color(100, 10, 10), gbc, 3, 2);
		addButton("C¥", new Color(100, 10, 10), gbc, 4, 2);
		addButton("P$", new Color(100, 10, 10), gbc, 5, 2);
		
		addButton(" 0 ", new Color(50, 50, 50), gbc, 0, 3);
		addButton("AC", new Color(50, 50, 50), gbc, 1, 3);
		addButton("⌫", new Color(50, 50, 50), gbc, 2, 3);
		addButton(" ₽ ", new Color(100, 10, 10), gbc, 3, 3);
		addButton(" ₺ ", new Color(100, 10, 10), gbc, 4, 3);
		addButton(" د ", new Color(100, 10, 10), gbc, 5, 3);
	}
	
private void addButton(String label, Color color, GridBagConstraints cons, int x, int y) {
		
		cons.gridx = x;
		cons.gridy = y;
		Button button = new Button(label, color);
		button.addActionListener(this);
		add(button, cons);
		button.addKeyListener(button);
	}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() instanceof JButton) {
		JButton button = (JButton) e.getSource();
		Memory.getInstance().processCommand(button.getText());
		}
}
	
}
