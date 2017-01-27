package yuskie.turnBasedGames.chess;

public class Pawn implements ChessPieces{

	String color;
	public Pawn(String color){
		this.color = color;
	}
	
	@Override
	public String[] possibleMovements(ChessBoard currentState) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String printPiece() {
		String colorChar ="";
		if(color.equals("White")){
			colorChar = "w-";
		}else{
			colorChar = "b-";
		}
		return colorChar + "P ";
	}

	@Override
	public String getColor() {
		return color;
	}

}
