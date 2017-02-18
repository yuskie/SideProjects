package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;
import static yuskie.turnBasedGames.ChessV2.Utility.*;

public class Pawn implements Piece {
	private Color color;
	private boolean moved;
	private static final int MAX_DISTANCE = 2;
	private static final int NORMAL_DISTANCE = 1;

	public Pawn(Color color) {
		this.color = color;
		moved = false;
	}
	
	public boolean validMove(String startLocation, String endLocation) {
		if(!moved){
			return straightMovement(startLocation, endLocation, MAX_DISTANCE);
		}
		return straightMovement(startLocation, endLocation, NORMAL_DISTANCE);
	}

	public String print() {
		String color = "";
		if (this.color == Color.BLACK) {
			color = "b";
		} else if (this.color == Color.WHITE) {
			color = "w";
		}
		return color + "-P";
	}

	public Color getColor() {
		return this.color;
	}

	public void moved() {
		this.moved = true;
	}

	public boolean isMoved() {
		return this.moved;
	}
}
