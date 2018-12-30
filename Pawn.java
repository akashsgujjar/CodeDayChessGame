
public class Pawn extends Piece {	
	public Pawn(boolean isWhite) {
		super(isWhite, "P");
	}
	public boolean isValid(int startX, int startY, int destX,
			int destY, boolean isWhite, Piece[][] board) {
		int deltaX = Math.abs(startX - destX);
		int deltaY = Math.abs(startY - destY);
		if ((board[destY][destX] != null && board[destY][destX].isWhite == isWhite)
				|| destX > 7 || destY > 7 || this.isWhite != isWhite || deltaY > 2) {
			return false;
		} 
		if (isWhite && destY >= startY || !isWhite && destY <= startY) {
			return false;
		}
		if ((deltaY == 2 && board[destY][destX] == null)
				&& (isWhite && startY == 6 || !isWhite && startY == 1)) {
			return true;
		}
		if (deltaY == 1 && deltaX == 0 && board[destY][destX] == null) {
			return true;
		} 
		if (board[destY][destX] != null && deltaX != 0) {
			return true;
		}
		return false;		
	}
}
