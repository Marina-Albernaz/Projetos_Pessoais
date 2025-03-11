package br.com.vision;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.model.KeyController;
import br.com.model.Memory;

@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener{
	private final Color COLOR_DARKEST_GRAY = new Color(60, 60, 60);
	private final Color COLOR_PASTEL_PINK = new Color(230, 177, 180);
	
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints cons = new GridBagConstraints();
	
	KeyController kc = new KeyController();
	
	public Keyboard() {
		
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1;
		cons.weighty = 1;
		
		setBackground(new Color(46, 49, 50));
		setLayout(layout);
		
		cons.gridwidth = 2;
		addButton("AC", COLOR_DARKEST_GRAY, cons, 0, 0);
		cons.gridwidth = 1;
		
		addButton("±", COLOR_DARKEST_GRAY, cons, 2, 0);
		
		addButton("÷", COLOR_PASTEL_PINK, cons, 3, 0);
		
		addButton("7", Color.GRAY, cons, 0, 1);
		addButton("8", Color.GRAY, cons, 1, 1);
		addButton("9", Color.GRAY, cons, 2, 1);
		addButton("×", COLOR_PASTEL_PINK, cons, 3, 1);

		addButton("4", Color.GRAY, cons, 0, 2);
		addButton("5", Color.GRAY, cons, 1, 2);
		addButton("6", Color.GRAY, cons, 2, 2);
		addButton("-", COLOR_PASTEL_PINK, cons, 3, 2);

		addButton("1", Color.GRAY, cons, 0, 3);
		addButton("2", Color.GRAY, cons, 1, 3);
		addButton("3", Color.GRAY, cons, 2, 3);
		addButton("+", COLOR_PASTEL_PINK, cons, 3, 3);

		cons.gridwidth = 2;
		addButton("0", Color.GRAY, cons, 0, 4);
		cons.gridwidth = 1;
		
		addButton(".", Color.GRAY, cons, 2, 4);
		addButton("=", COLOR_PASTEL_PINK, cons, 3, 4);


	}

	private void addButton(String label, Color color, GridBagConstraints cons, int x, int y) {
		
		cons.gridx = x;
		cons.gridy = y;
		Button button = new Button(label, color);
		button.addActionListener(this);
		add(button, cons);
		button.addKeyListener(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
		JButton button = (JButton) e.getSource();
		Memory.getInstance().processCommand(button.getText());
		}
		
	}

}