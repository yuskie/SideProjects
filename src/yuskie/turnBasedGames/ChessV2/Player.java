
package yuskie.turnBasedGames.ChessV2;

import yuskie.turnBasedGames.ChessV2.Utility.Color;

public class Player {
	private Color color;
	
	public Player(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return this.color;
	}
	
}
