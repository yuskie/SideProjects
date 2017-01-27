package yuskie.turnBasedGames.chess;

public class King implements ChessPieces{

	String color;
	public King(String color){
		this.color = color;
	}
	
	public String[] possibleMovements(ChessBoard currentState) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String printPiece() {
		String colorChar ="";
		if(color.equals("White")){
			colorChar = "w-";
		}else{
			colorChar = "b-";
		}
		return colorChar+"K ";
	}

	public String getColor() {
		return color;
	}

	public int[] getXYLocation(ChessBoard currentState) {
		int[] pieceLocation = new int[2];
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8; j++){
				if(this == currentState.getPiece(i,j)){
					pieceLocation[0]=i;
					pieceLocation[1]=j;
				}
			}
		}
		return pieceLocation;
	}

}
