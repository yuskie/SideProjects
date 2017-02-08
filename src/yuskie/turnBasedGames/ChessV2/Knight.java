package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;

public class Knight implements Piece {
	Color color;

	public Knight(Color color) {
		this.color = color;
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
