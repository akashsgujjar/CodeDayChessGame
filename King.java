
public class King extends Piece {
	
	public King(boolean isWhite) {
		super(isWhite, "K");
	}
	
	public boolean isValid(int startX, int startY, int destX, int destY, boolean isWhite, Piece[][] board) {
		boolean isValid = true;
		isValid &= this.isWhite == isWhite;
		if ((board[destY][destX] != null && board[destY][destX].isWhite == isWhite)
				|| destX > 7 || destY > 7) {
			//System.out.println("first one");
			return false;
		} 
		if (Math.abs(destX - startX) > 1 || Math.abs(destY - startY) > 1) {
			//System.out.println("second one");
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != null && 
						board[i][j].isWhite != isWhite &&
						board[i][j].isValid(j, i, destX, destY, board[i][j].isWhite, board)) {
					//System.out.println(i + " " + j);
					return false;
				}
			}
		}
		//System.out.println("last one");
		return isValid;
	}
	
	
}
