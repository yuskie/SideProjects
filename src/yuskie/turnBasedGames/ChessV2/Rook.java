package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;
import static yuskie.turnBasedGames.ChessV2.Utility.*;

public class Rook implements Piece {
	Color color;

	public Rook(Color color) {
		this.color = color;
	}

	public boolean validMove(String startLocation, String endLocation) {
		return straightMovement(startLocation, endLocation, BOARD_SIZE);
	}

	public String print() {
		String color = "";
		if (this.color == Color.BLACK) {
			color = "b";
		} else if (this.color == Color.WHITE) {
			color = "w";
		}
		return color + "-R";
	}

	public Color getColor() {
		return this.color;
	}
}
