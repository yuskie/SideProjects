package yuskie.turnBasedGames.chess;

public class Player {
	private String color;
	
	public Player(String color){
		this.color = color;
	}

	public int piecesLeft(ChessBoard currentState){
		return 0;
	}
	
	public boolean isKingAlive(ChessBoard currentState){
		return false;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public boolean isCheckMate(ChessBoard currentState){
		return false;
	}
}
