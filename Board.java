
public class Board {

	private Piece[][] board = new Piece[8][8];

	public Board() {
		this.board = new Piece[8][8];
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(false);
		}
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(true);
		}
		board[0][0] = new Rook(false);
		board[0][7] = new Rook(false);
		board[0][1] = new Knight(false);
		board[0][6] = new Knight(false);
		board[0][2] = new Bishop(false);
		board[0][5] = new Bishop(false);
		board[0][3] = new Queen(false);
		board[0][4] = new King(false);
		board[7][4] = new King(true);
		board[7][0] = new Rook(true);
		board[7][7] = new Rook(true);
		board[7][1] = new Knight(true);
		board[7][7] = new Rook(true);
		board[7][6] = new Knight(true);
		board[7][2] = new Bishop(true);
		board[7][5] = new Bishop(true);
		board[7][3] = new Queen(true);
	}

	public void printBoard() {
		 System.out.print("  ");
		  for (int x = 0; x < 41; x++) {
			  System.out.print("-");
		  }
		  System.out.println();
		  
		  for (int i = 0; i < board.length; i++) {
			  System.out.print(board.length-(i)+" ");
			  System.out.print("| ");
			  for (int j = 0; j < board.length; j++) {
				  if (board[i][j] == null) {
					  System.out.print("   | ");
				  }
				  else {
					  System.out.print(board[i][j].toString() + " | ");   
				  } 
		       }
			  System.out.println();
			  System.out.print("  ");
			  for(int z = 0; z < 41; z++) { 
				  System.out.print("-");
			  }
			  System.out.println();
			  
		  }
		  System.out.println("     a    b    c    d    e    f    g    h");
	}
	
	public boolean castle(String side, boolean isWhite) {
		if (side.equals("K") && isWhite) {
			return castleKingside(7);
		} else if (side.equals("K")) {
			return castleKingside(0);
		} else if (side.equals("Q") && isWhite) {
			return castleQueenside(7);
		} else {
			return castleQueenside(0);
		}
	}
	
	public boolean castleKingside(int row) {
		if (board[row][6] != null || board[row][5] != null
				|| board[row][4].hasMoved() || board[row][7].hasMoved()) {
			return false;
		} else {
			board[row][6] = board[row][4];
			board[row][4] = null;
			board[row][5] = board[row][7];
			board[row][7] = null;
			return true;
		}
	}
	
	public boolean castleQueenside(int row) {
		if (board[row][1] != null || board[row][2] != null || board[row][3] != null
				|| board[row][0].hasMoved() || board[row][4].hasMoved()) {
			return false;
		} else {
			board[row][2] = board[row][4];
			board[row][4] = null;
			board[row][3] = board[row][0];
			board[row][0] = null;
			return true;
		}
	}

	public boolean move(String start, String dest, boolean isWhite) {
		int startX = getX(start.charAt(0));
		int startY = board.length - (Integer.parseInt("" + start.charAt(1)));
		int destX = getX(dest.charAt(0));
		int destY = board.length - (Integer.parseInt("" + dest.charAt(1)));
		if (startX >= 0 && destY >= 0 && 
				destX < 8 && destY < 8 && 
				board[startY][startX] != null &&
				board[startY][startX].isValid(startX, startY, destX, destY, isWhite, board)) {
			board[startY][startX].move();
			board[destY][destX] = board[startY][startX];
			board[startY][startX] = null;
			return true;
		} else {
			return false;
		}

	}
	


	private int getX(char ch) {
		String s = "abcdefgh";
		return s.indexOf(ch);
	}

}
