package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;
import static yuskie.turnBasedGames.ChessV2.Utility.*;

public class King implements Piece {
	Color color;
	private static final int MAX_NORMAL_MOVEMENT = 1;
	boolean moved;
	
	public King(Color color) {
		this.color = color;
		moved = false;
	}
	
	public boolean validMove(String startLocation, String endLocation) {
		return diagonalMovement(startLocation, endLocation, MAX_NORMAL_MOVEMENT) || straightMovement(startLocation, endLocation, MAX_NORMAL_MOVEMENT);
	}

	public String print() {
		String color = "";
		if (this.color == Color.BLACK) {
			color = "b";
		} else if (this.color == Color.WHITE) {
			color = "w";
		}
		return color + "-K";
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isMoved() {
		return moved;
	}

	public void moved() {
		this.moved = true;
	}
}
