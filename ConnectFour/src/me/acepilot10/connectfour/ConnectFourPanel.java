package me.acepilot10.connectfour;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ConnectFourPanel extends JPanel {

	private CellPanel[][] panels;

	public ConnectFourPanel() {
		init();
	}

	private void init() {
		panels = new CellPanel[42][42];
		GridLayout layout = new GridLayout();
		layout.setColumns(7);
		layout.setRows(6);
		layout.setHgap(Settings.CELL_HGAP);
		layout.setVgap(Settings.CELL_VGAP);
		setLayout(layout);
		int offset = 250;
		int width = Settings.WIDTH / 2 + offset;
		int height = Settings.HEIGHT / 2 + offset - 150;
		setSize(width, height);
		int x = (Settings.WIDTH / 2) - (getWidth() / 2);
		int y = (Settings.HEIGHT / 2) - (getHeight() / 2);
		setLocation(x, y);
		setVisible(true);
		setBackground(Color.YELLOW);
		addCells();
	}

	private void addCells() {
		int currentColumn = 0;
		int currentRow = 5;
		for (int i = 0; i <= 41; i++) {
			CellPanel cell = new CellPanel(currentColumn, currentRow);
			add(cell);
			panels[currentColumn + 1][currentRow + 1] = cell;
			currentColumn++;
			if (currentColumn == 7) {
				currentColumn = 0;
				currentRow--;
			}
		}
	}

	public CellPanel getPanel(int column, int row) {
		try {
			return panels[column + 1][row + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Attempted to find cell which doesn't exist. Returning null.");
		}
		return null;
	}
}