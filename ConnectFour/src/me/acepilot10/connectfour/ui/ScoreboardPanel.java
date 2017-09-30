package me.acepilot10.connectfour.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import me.acepilot10.connectfour.ConnectFourFrame;
import me.acepilot10.connectfour.Settings;

public class ScoreboardPanel extends JPanel {
	
	public ConnectFourFrame frame;
	
	private JLabel currentPlayer;
	
	public ScoreboardPanel(ConnectFourFrame frame) {
		this.frame = frame;
		init();
	}
	
	private void init() {
		int width = Settings.WIDTH - 25;
		int height = 50;
		int x = Settings.WIDTH / 2 - width / 2;
		int y = 10;
		setSize(width, height);
		setLocation(x, y);
		setBackground(Color.GRAY);
		currentPlayer = new JLabel();
		currentPlayer.setText("Current Player: 1");
		setBackground(Color.RED);
		currentPlayer.setFont(new Font("Serif", Font.PLAIN, Settings.SCOREBOARD_FONT_SIZE));
		add(currentPlayer);
		setVisible(true);
	}
	
	public void update() {
		int player = frame.getMain().currentPlayer;
		currentPlayer.setText("Current Player:" + player);
		switch(player) {
		case 1:
			setBackground(Color.RED);
			break;
		case 2:
			setBackground(Color.GRAY);
			break;
		}
	}
	
	public JLabel getLabel() {
		return this.currentPlayer;
	}
}