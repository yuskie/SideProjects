package yuskie.turnBasedGames.chess;

public class Rook implements ChessPiece{

	private String color;
	private boolean canCastle;
	
	public Rook(String color){
		this.color = color;
		canCastle = true;
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
		return colorChar +"R ";
	}

	public String getColor() {
		return this.color;
	}
}
