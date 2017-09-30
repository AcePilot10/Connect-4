package me.acepilot10.connectfour;

import java.awt.Color;
import java.util.ArrayList;

import me.acepilot10.connectfour.CellPanel.Piece;

public class ConnectFour {

	public boolean playing = true;

	public static ConnectFour connectFour;

	public ConnectFourFrame frame;

	public int currentPlayer = 1;

	public ConnectFour() {
		connectFour = this;
		init();
	}

	private void init() {
		frame = new ConnectFourFrame(this);
	}

	public void startGame() {

	}

	public void playerDropPiece(int column) {
		CellPanel topCell = frame.getConnectFourPanel().getPanel(column, 5);
		if (topCell.isEmpty()) {
			CellPanel cellBelow = frame.getConnectFourPanel().getPanel(column, 4);
			if (cellBelow.isEmpty()) {
				for (int i = 5; i >= 0; i--) {
					CellPanel currentCell = frame.getConnectFourPanel().getPanel(column, i);
					if (i == 0) {
						dropPiece(frame.getConnectFourPanel().getPanel(column, 0));
						break;
					}
					CellPanel currentCellBelow = frame.getConnectFourPanel().getPanel(column, i - 1);
					if (!currentCellBelow.isEmpty()) {
						dropPiece(currentCell);
						break;
					}
				}
			} else {
				dropPiece(topCell);
			}
		}
		else {
			return;
		}
		checkIfPlayerWon();
	}

	private void dropPiece(CellPanel cell) {
		switch (currentPlayer) {
		case 1:
			cell.DropPiece(Piece.RED);
			break;
		case 2:
			cell.DropPiece(Piece.BLACK);
			break;
		}
	}

	public void checkIfPlayerWon() {
		if(playing) {
			checkVertical();
			checkHorizontal();
			checkDiagonal();			
			switchPlayer();
		}
	}

	private void checkVertical() {
		for(int row = 5; row >= 3; row--) {
			for(int column = 0; column <= 6; column++) {
				CellPanel cell = frame.getConnectFourPanel().getPanel(column, row);
				if(!cell.isEmpty()) {
					int piece = cell.piece;
					ArrayList<CellPanel> panels = new ArrayList<CellPanel>();
					panels.add(cell);
					int rowTo = row - 3;
					for(int i = 1; i <= 3; i++) {
						CellPanel currentCell = frame.getConnectFourPanel().getPanel(column, row - i);
						if(currentCell != null) {
							panels.add(currentCell);
							if(currentCell.piece == piece) {
								if((row-i) == rowTo) {
									//Win
									System.out.println("Won vertical");
									win(panels);
									break;
								}
							}
							else
								break;
						}
						else 
							break;
					}
				}
			}
		}
	}
	
	private void checkHorizontal() {
		for (int col = 0; col <= 6; col++) {
			for (int row = 0; row <= 5; row++) {
				CellPanel cell = frame.getConnectFourPanel().getPanel(col, row);
				if (!cell.isEmpty()) {
					int piece = cell.piece;
					ArrayList<CellPanel> panels = new ArrayList<CellPanel>();
					panels.add(cell);
					for (int i = 1; i <= 3; i++) {
						CellPanel currentCell = frame.getConnectFourPanel().getPanel(col + i, row);
						if (currentCell != null) {
							if (currentCell.piece == piece) {
								panels.add(currentCell);
								if (i == 3) {
									// win
									System.out.println("Win horizontal");
									win(panels);
									break;
								}
							}
							else
								break;
						} else
							break;
					}
				}
			}
		}
	}

	private void checkDiagonal() {
		for (int row = 5; row >= 3; row--) {
			for (int column = 0; column <= 6; column++) {
				CellPanel cell = frame.getConnectFourPanel().getPanel(column, row);
				if (!cell.isEmpty()) {
					int piece = cell.piece;
					// right
					int currentColumn = column;
					ArrayList<CellPanel> panels = new ArrayList<CellPanel>();
					panels.add(cell);
					for (int i = 1; i <= 4; i++) {
						CellPanel currentCell = frame.getConnectFourPanel().getPanel(currentColumn + i, row - i);
						if (currentCell != null) {
							if (currentCell.piece == piece) {
								panels.add(currentCell);
								if (i == 3) {
									System.out.println("Won right diagonal");
									win(panels);
									break;
								}
							}
							else
								break;
						} else
							break;
					}
					// left
					currentColumn = column;
					for (int i = 1; i <= 4; i++) {
						CellPanel currentCell = frame.getConnectFourPanel().getPanel(currentColumn - i, row - i);
						if (currentCell != null) {
							if (currentCell.piece == piece) {
								panels.add(currentCell);
								if (i == 3) {
									System.out.println("Won left diagonal");
									win(panels);
									break;
								}
							}
							else 
								break;
						} else
							break;
					}
				}
			}
		}
	}
	
	private void win(ArrayList<CellPanel> panels) {
		playing = false;
		for(CellPanel panel : panels) {
			panel.setBackground(Color.YELLOW);
		}
		frame.getScoreboard().setBackground(Color.YELLOW);
		frame.getScoreboard().getLabel().setText("Player " + currentPlayer + " has won!");
	}
	
	private void switchPlayer() {
		if(currentPlayer == 1) currentPlayer = 2;
		else currentPlayer = 1;
		frame.getScoreboard().update();
	}
}