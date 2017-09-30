package me.acepilot10.connectfour.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import me.acepilot10.connectfour.ConnectFour;
import me.acepilot10.connectfour.ConnectFourFrame;
import me.acepilot10.connectfour.Settings;

public class ButtonPanel extends JPanel {
	
	private ConnectFourFrame frame;
	
	public ButtonPanel(ConnectFourFrame frame) {
		this.frame = frame;
		setLayout(new GridLayout(1, 0, 0, 0));
		setSize(frame.getConnectFourPanel().getWidth(), 50);
		int x = Settings.WIDTH / 2 - getWidth() / 2;
		int y = Settings.HEIGHT - getHeight() * 2;
		setLocation(x, y);		
		ArrayList<JButton> temp = new ArrayList<JButton>();
		JButton btn1 = new JButton("1");
		add(btn1);
		JButton btn2 = new JButton("2");
		add(btn2);
		JButton btn3 = new JButton("3");
		add(btn3);
		JButton btn4 = new JButton("4");
		add(btn4);
		JButton btn5 = new JButton("5");
		add(btn5);
		JButton btn6 = new JButton("6");
		add(btn6);
		JButton btn7 = new JButton("7");
		add(btn7);		
		temp.add(btn1);
		temp.add(btn2);
		temp.add(btn3);
		temp.add(btn4);
		temp.add(btn5);
		temp.add(btn6);
		temp.add(btn7);
		for(JButton btn : temp) {
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonClicked(Integer.parseInt(btn.getText()));
				}
			});
		}
		setVisible(true);
	}
	
	public void buttonClicked(int btn) {
		if(frame.getMain().playing) {
			ConnectFour.connectFour.playerDropPiece(btn-1);
		}
	}
	
	public ConnectFourFrame getConnectFourFrame() {
		return this.frame;
	}
}