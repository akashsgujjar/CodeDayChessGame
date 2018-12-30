import java.util.Scanner;

public class ChessMain {

	public static void main(String[] args) {
		Board b = new Board();
		startGame(b);
	}
	
	public static void startGame(Board b) {
		Scanner scan = new Scanner(System.in);
		b.printBoard();
		System.out.println("To castle kingside, enter K.");
		System.out.println("To castle queenside, enter Q");
		while(true) {
			onePlayerMoves("Player 1:", scan, b, true);
			onePlayerMoves("Player 2:", scan, b, false);
			b.printBoard();
		}
	}
	
	public static void onePlayerMoves(String player, Scanner scan, Board b, boolean isWhite) {
		boolean castled = true;
		boolean moved = true;
		boolean badArguments = false;
		boolean notValidMove = true;
		while (notValidMove) {
			System.out.println(player);
			System.out.print("Enter coordinates of moving piece: ");
			String start = scan.next();
			castled = true;
			moved = true;
			String dest = null;
			if (start.equals("K")) {
				castled = b.castle("K", isWhite);
			} else if (start.equals("Q")) {
				castled = b.castle("Q", isWhite);
			} else {					
				System.out.print("Enter coordinates of destination square: ");
				dest = scan.next();
				badArguments = badInput(start) || badInput(dest);
				if (!badArguments) {
					moved = b.move(start,  dest,  isWhite);
				}
			}
			if (!castled || !moved || badArguments) {
				System.out.println("Not a valid move!");
			} else {
				notValidMove = false;
				b.printBoard();
			}

		}
	}
	
	
	private static boolean badInput(String s) {
		return s == null || s.length() != 2;
	}
	
}
