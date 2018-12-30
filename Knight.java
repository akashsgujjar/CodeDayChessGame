
public class Knight extends Piece {

	public Knight(boolean isWhite) {
		super(isWhite, "N");
	}
	
	public boolean isValid(int startX, int startY, int destX, int destY,
			boolean isWhite, Piece[][] board) {
		int deltaX = Math.abs(startX - destX);
		int deltaY = Math.abs(startY - destY);
		if ((board[destY][destX] != null && board[destY][destX].isWhite == isWhite)
				|| destX > 7 || destY > 7 || this.isWhite != isWhite) {
			return false;
		}
		if (deltaX == 2 && deltaY == 1) {
			return true;
		} else if (deltaY == 2 && deltaX == 1) {
			return true;
		} else {
			return false;
		}
	}
}
