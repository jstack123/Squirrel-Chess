import java.awt.Color;

import javax.swing.JButton;

public class Square extends JButton {
	private boolean inMoveSet;
	private Board b;
	private Position pos;
	private King king;
	boolean bool; 
	public Square(Board b, Position pos, King king) {
		this.inMoveSet = false;
		this.b = b;
		this.pos = pos;
		this.king = king;
	}
	public void click() {
		if (b.getSelectedPiece() == null && b.getPieceAtPos(pos) != null)
			b.getPieceAtPos(pos).select();
		else if (inMoveSet && b.getSelectedPiece() != null) {
			 bool = false;
			if(b.getSelectedPiece().equals(king) && king.whiteAbleToCastle() && b.getPieceAtPos(new Position(7,4)).equals(king)) {
				bool = true;
			}
			b.getSelectedPiece().move(pos);
			if(bool && b.getPieceAtPos(new Position(7,4)).equals(king)) {
				
			}
		} else {
			b.setSelectedPiece(null);
			b.unhighlightMoves();
		}
	}

	public void setInMoveSet(boolean inMoveSet) {
		this.inMoveSet = inMoveSet;
	}
}
