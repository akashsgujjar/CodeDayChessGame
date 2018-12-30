
public class Queen extends Piece {

	public Queen(boolean isWhite) {
		super(isWhite, "Q");
	}
	
	public boolean isValid(int startX, int startY, int destX, int destY, boolean isWhite, Piece[][] board) {
		if (this.isWhite != isWhite) {
			return false;
		} else if (startX == destX || startY == destY) {
			Rook r = new Rook(isWhite);
			return r.isValid(startX, startY, destX, destY, isWhite, board);
		} else {
			Bishop b = new Bishop(isWhite);
			return b.isValid(startX, startY, destX, destY, isWhite, board);
		}
	}
	
}
