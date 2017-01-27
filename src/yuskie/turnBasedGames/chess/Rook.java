package yuskie.turnBasedGames.chess;

public class Rook implements ChessPieces{

	String color;
	public Rook(String color){
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
		return colorChar +"R ";
	}

	@Override
	public String getColor() {
		return this.color;
	}

}
