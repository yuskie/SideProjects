package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;
import static yuskie.turnBasedGames.ChessV2.Utility.*;


public class Knight implements Piece {
	Color color;

	public Knight(Color color) {
		this.color = color;
	}
	
	public boolean validMove(String startLocation, String endLocation) {
		return lMovement(startLocation, endLocation);
	}

	public String print() {
		String color = "";
		if (this.color == Color.BLACK) {
			color = "b";
		} else if (this.color == Color.WHITE) {
			color = "w";
		}
		return color + "-KN";
	}

	public Color getColor() {
		return this.color;
	}
}
