
public class Rook extends Piece {
	public Rook(boolean isWhite) {
		super(isWhite, "R");
	}
	
	public boolean isValid(int startX, int startY, int destX, int destY, boolean isWhite, Piece[][] board) {
		boolean isValid = true;
		isValid &= this.isWhite == isWhite;
		if ((startY != destY && startX != destX) || (board[destY][destX] != null && board[destY][destX].isWhite == isWhite)
				|| destX > 7 || destY > 7) {
			return false;
		}
		for (int i = Math.min(startX, destX) + 1; i < Math.max(startX, destX); i++) {
			if (board[startY][i] != null ) {
				return false;
			}
		}
		for (int i = Math.min(startY, destY) + 1; i < Math.max(destY, startY); i++) {
			if (board[i][startX] != null ) {
				return false;
			}
		}		
		return isValid;
	}
}
