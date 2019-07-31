import java.awt.Color;

import javax.swing.JButton;

public class Square extends JButton {
	private boolean inMoveSet;
	private Board b;
	private Position pos;
	private King king;
	private Rook rook1;
	private Rook rook2;
	boolean bool; 
	public Square(Board b, Position pos) {
		this.inMoveSet = false;
		this.b = b;
		this.pos = pos;
//		this.king = king;
//		this.rook1=rook1;
//		this.rook2=rook2;
	}
	public void click() {
		if (b.getSelectedPiece() == null && b.getPieceAtPos(pos) != null)
			b.getPieceAtPos(pos).select();
		else if (inMoveSet && b.getSelectedPiece() != null) {
//			 bool = false;
//			 System.out.println("" + bool);
//			if(b.getSelectedPiece() != null && king.whiteAbleToCastle() == true) {
//				bool = true;
//				System.out.println("" + bool);
//			}
			b.getSelectedPiece().move(pos);
//			if(bool && b.getPieceAtPos(new Position(7,2))!= null) {
//				rook1.move(new Position(7,3));
//			}
		} else {
			b.setSelectedPiece(null);
			b.unhighlightMoves();
		}
	}

	public void setInMoveSet(boolean inMoveSet) {
		this.inMoveSet = inMoveSet;
	}
}
