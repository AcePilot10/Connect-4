package me.acepilot10.connectfour;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

public class CellPanel extends JPanel {
	
	public int piece = 0;
	
	private int column;
	private int row;
	
	public CellPanel(int column, int row) {
		this.column  = column;
		this.row = row;
		init();
	}
	
	private void init() {
		setVisible(true);
	}
	
	public void update() {
		switch(piece) {
		case Piece.EMPTY:
			setBackground(Color.WHITE);
			break;
		case Piece.RED:
			setBackground(Color.RED);
			break;
		case Piece.BLACK:
			setBackground(Color.BLACK);
			break;
		}
	}
	
	public void DropPiece(int piece) {
		this.piece = piece;
		update();
	}
	
	public boolean isEmpty() {
		return piece == Piece.EMPTY;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public Point getLocation() {
		return new Point(column, row);
	}
	
	public class Piece {
		public static final int EMPTY = 0;
		public static final int RED = 1;
		public static final int BLACK = 2;
	}
}