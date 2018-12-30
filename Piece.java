
public class Piece {
	
	protected boolean isWhite;
	private String name;
	private boolean hasMoved;
	
	public Piece(boolean isWhite, String name) {
		this.isWhite = isWhite;
		this.name = name;
	}
	
	public void move() {
		hasMoved = true;
	}
	
	public boolean hasMoved() {
		return hasMoved;
	}
	
	public boolean isValid(int startX, int startY, int destX, int destY, boolean isWhite, Piece[][] board) {
		return false;
	}
	
	public String toString() {
		if (isWhite) {
			return name + 1;
		} else {
			return name + 2;
		}
	}

}
