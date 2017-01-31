package yuskie.turnBasedGames.chess;

public class Queen implements ChessPiece{

	private String color;
	public Queen(String color){
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
		return colorChar + "Q ";
	}

	public String getColor() {
		return color;
	}

}
