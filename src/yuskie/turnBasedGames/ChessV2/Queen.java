package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;
import static yuskie.turnBasedGames.ChessV2.Utility.*;

public class Queen implements Piece {
	private Color color;
	private boolean moved;
	
	public Queen(Color color) {
		this.color = color;
		this.moved = false;
	}
	
	public boolean validMove(String startLocation, String endLocation) {
		return diagonalMovement(startLocation, endLocation, BOARD_SIZE) || straightMovement(startLocation, endLocation, BOARD_SIZE);
	}

	public String print() {
		String color = "";
		if (this.color == Color.BLACK) {
			color = "b";
		} else if (this.color == Color.WHITE) {
			color = "w";
		}
		return color + "-Q";
	}

	public Color getColor() {
		return this.color;
	}

	public void moved() {
		this.moved = true;
	}
	
	public boolean isMoved(){
		return this.moved;
	}
}
