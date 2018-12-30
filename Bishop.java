
public class Bishop extends Piece {

	public Bishop(boolean isWhite) {
		super(isWhite, "B");
	}
	
	public boolean isValid(int startX, int startY, int destX, int destY, boolean isWhite, Piece[][] board) {
		boolean isValid = true;
		isValid &= this.isWhite == isWhite;
		if ((startY == destY || startX == destX) || (board[destY][destX] != null && board[destY][destX].isWhite == isWhite)
				|| destX > 7 || destY > 7 || Math.abs(destX - startX) != Math.abs(destY - startY)) {
			return false;
		}
		int deltaX = 0;
		int deltaY = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				deltaX = Math.abs(j - startX);
				deltaY = Math.abs(i - startY);
				if (((i > startY && i < destY) || (i < startY && i > destY)) &&
						(((j > startX && j < destX) || (j < startX && j > destX)))
						&& board[i][j] != null && deltaX == deltaY) {
					return false;					
				}
			}
		}
		return isValid;
	}
	
	

}
