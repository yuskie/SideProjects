package yuskie.turnBasedGames.chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements ChessPieces{
	
	String color;
	public Bishop(String color){
		this.color = color;
	}

	public ArrayList<int[]> possibleMovements(ChessBoard currentState) {
		int[] location = this.getXYLocation(currentState);
		int pieceX = location[0];
		int pieceY = location[1];
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
		for(int i = 1; i<8; i++){
			for(int j = 1; j<8; j++){
				if(pieceX+i<8 && pieceY+i<8){
					ChessPieces pieceAtLoc = currentState.getPiece(i, j);
					if(pieceAtLoc == null){
						possibleMoves.add(new int[]{pieceX+i,pieceY+j});
					}else if(pieceAtLoc.getColor()!=this.getColor()){
						possibleMoves.add(new int[]{pieceX+i,pieceY+j});
					}
				}
			}
		}
		//Loop for diagonal movment
			//Checks if piece exists there;
				// if enemy, DESTROY
				// else that's the limit;
		
		return possibleMoves;
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
