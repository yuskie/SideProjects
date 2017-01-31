package yuskie.turnBasedGames.chess;


public class Pawn implements ChessPiece{
	private boolean reachedEnd;
	private String color;
	
	public Pawn(String color){
		this.color = color;
		reachedEnd = false;
	}
	
	public boolean legalMove(String moveLoc, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String printPiece() {
		String colorChar ="";
		if(color.equals("White")){
			colorChar = "w-";
		}else{
			colorChar = "b-";
		}
		return colorChar + "P ";
	}

	public String getColor() {
		return color;
	}
	
}
