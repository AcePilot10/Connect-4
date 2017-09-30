package me.acepilot10.connectfour;

import javax.swing.JFrame;

import me.acepilot10.connectfour.ui.ButtonPanel;
import me.acepilot10.connectfour.ui.ScoreboardPanel;

public class ConnectFourFrame extends JFrame {
	
	private ConnectFour main;
	
	private ConnectFourPanel connectFourPanel;
	
	private ButtonPanel btnPanel;
	private ScoreboardPanel score;
	
	public ConnectFourFrame(ConnectFour main) {
		this.main = main;
		init();
	}
	
	private void init() {
		setLayout(null);
		setSize(Settings.WIDTH, Settings.HEIGHT);
		initConnectFourPanel();
		initButtonPanel();
		initScoreboard();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initConnectFourPanel() {
		connectFourPanel = new ConnectFourPanel();
		add(connectFourPanel);
	}
	
	private void initButtonPanel() {
		btnPanel = new ButtonPanel(this);
		add(btnPanel);
	}
	
	private void initScoreboard() {
		score = new ScoreboardPanel(this);
		add(score);
	}
	
	public ConnectFourPanel getConnectFourPanel() {
		return this.connectFourPanel;
	}
	
	public ButtonPanel getButtonPanel() {
		return this.btnPanel;
	}
	 
	public ScoreboardPanel getScoreboard() {
		return this.score;
	}
	
	public ConnectFour getMain() {
		return this.main;
	}
}