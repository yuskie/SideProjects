package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;

public interface Piece {

	public String print();

	public Color getColor(); 
	
	public boolean validMove(String startLocation, String endLocation);

	public void moved();
	
	public boolean isMoved();
}
