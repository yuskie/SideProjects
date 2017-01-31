package yuskie.turnBasedGames.chess;

public class Knight implements ChessPiece{
	
	private String color;
	public Knight(String color){
		this.color = color;
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
		return colorChar + "KN";
	}

	public String getColor() {
		return color;
	}

}
