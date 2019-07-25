import java.util.ArrayList;

public class King extends Piece {

	private Rook rook1;
	private Rook rook2;
	
	public King(Position pos, Board b, boolean isWhite, Rook rook1, Rook rook2) {
		super(pos, b, isWhite);
		this.rook1 = rook1;//white
		this.rook2 = rook2;//black
	}

	public boolean whiteAbleToCastle() {
		if(b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() - 1))==null && 
			b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() - 2))==null && 
			b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() - 3)) == null) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public ArrayList<Position> getMoveSet() {
		ArrayList<Position> ret = new ArrayList<Position>();
		if (pos.getRow() + 1 < 8 && pos.getCol() + 1 < 8)
			ret.add(new Position(pos.getRow() + 1, pos.getCol() + 1));
		if (pos.getRow() - 1 >= 0 && pos.getCol() + 1 < 8)
			ret.add(new Position(pos.getRow() - 1, pos.getCol() + 1));
		if (pos.getRow() + 1 < 8 && pos.getCol() - 1 >= 0)
			ret.add(new Position(pos.getRow() + 1, pos.getCol() - 1));
		if (pos.getRow() - 1 >= 0 && pos.getCol() - 1 >= 0)
			ret.add(new Position(pos.getRow() - 1, pos.getCol() - 1));
		if (pos.getRow() + 1 < 8)
			ret.add(new Position(pos.getRow() + 1, pos.getCol()));
		if (pos.getRow() - 1 >= 0)
			ret.add(new Position(pos.getRow() - 1, pos.getCol()));
		if (pos.getCol() + 1 < 8)
			ret.add(new Position(pos.getRow(), pos.getCol() + 1));
		if (pos.getCol() - 1 >= 0)
			ret.add(new Position(pos.getRow(), pos.getCol() - 1));
		if (isWhite && whiteAbleToCastle()) { 
			boolean bool = false;
			ret.add(new Position(pos.getRow(), pos.getCol() - 2));
//			while(bool== false) {
			//while(b.getPieceAtPos(new Position(pos.getRow(), pos.getCol()))!= null) {//while loop doesnt allow user to click on anything
				if(b.getPieceAtPos(new Position(pos.getRow(), pos.getCol() - 2))!= null) { 
					bool = true;
					rook1.move(new Position(pos.getRow(), 3)); //doesnt move yet
				}
	//	}
//			}
			/*moves rook when castling but moves
			immediately when user clicks on king
			*/
		}
		return removeInvalidMoves(ret);
	}
	
	@Override
	public void draw() {
		
	}
	
	public String toString() {
		return "King" + super.toString();
	}
}
