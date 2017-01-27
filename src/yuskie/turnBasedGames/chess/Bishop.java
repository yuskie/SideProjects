package yuskie.turnBasedGames.chess;

public class Bishop implements ChessPieces{
	
	String color;
	public Bishop(String color){
		this.color = color;
	}

	public String[] possibleMovements(ChessBoard currentState) {
		
		//Loop for diagonal movment
			//Checks if piece exists there;
				// if enemy, DESTROY
				// else that's the limit;
		
		return null;
	}
	
	public String printPiece() {
		String colorChar ="";
		if(color.equals("White")){
			colorChar = "w-";
		}else{
			colorChar = "b-";
		}
		return colorChar +"B ";
	}

	public String getColor() {
		return color;
	}
	
	//X will be at index 0; Y will be at index 1
	public int[] getXYLocation(ChessBoard currentState){
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
