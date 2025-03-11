package br.com.vision;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.model.Memory;
import br.com.model.MemoryObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoryObserver{

	private final JLabel jLnumberDisplay;
	Font displayFont;
	
	public Display() {
		Memory.getInstance().addObserver(this);
		
		setBackground(new Color(46, 49, 50));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 3));
		
		
			try {
				InputStream myStream = new BufferedInputStream(new FileInputStream("src/technology.bold.ttf"));
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				displayFont = Font.createFont(Font.TRUETYPE_FONT, myStream);
				ge.registerFont(displayFont);
			} catch (FontFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		jLnumberDisplay = new JLabel();
		jLnumberDisplay.setForeground(Color.WHITE);
		jLnumberDisplay.setFont(displayFont.deriveFont(40f));
		jLnumberDisplay.setSize(new Dimension(233, 57));
		
		jLnumberDisplay.setText(Memory.getInstance().getCurrentText());
		add(jLnumberDisplay);
		
	}

	@Override
	public void alteredValue(String newValue) {
		jLnumberDisplay.setText(newValue);
	}
	
}
