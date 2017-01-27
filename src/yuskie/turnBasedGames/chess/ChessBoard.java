package yuskie.turnBasedGames.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
	private ChessPieces[][] boardState;
	
	public ChessBoard(){
		boardState = new ChessPieces[8][8];
		resetBoard();
	}
	
	public ChessPieces getPiece(int x, int y){
		return boardState[x][y];
	}
	
	private void resetBoard(){
		String color = "Black";
		for(int i = 0;i<8;){
			boardState[i][0] = new Rook(color);
			boardState[i][1] = new Knight(color);
			boardState[i][2] = new Bishop(color);
			boardState[i][3] = new King(color);
			boardState[i][4] = new Queen(color);
			boardState[i][5] = new Bishop(color);
			boardState[i][6] = new Knight(color);
			boardState[i][7] = new Rook(color);
			i+=1;
			if(i == 8){
				i = 6;
			}
			for(int j = 0; j<8;j++){
				boardState[i][j] = new Pawn(color);
			}
			i+=6;
			color ="White";
		}
	}
	
	public void printBoard(){
		String boardEdge="";
		for(int i =0; i <41; i++){
			boardEdge= boardEdge.concat("-");
		}
		System.out.println(boardEdge);
		for(int i = 0; i<8;i++){
			System.out.print("|");
			for(int j = 0; j<8; j++){
				if(this.boardState[i][j] == null){
					System.out.print("    ");
				}else{
					System.out.print(this.boardState[i][j].printPiece());
				}
				System.out.print("|");
			}
			System.out.print("  " + i);
			System.out.println();
			System.out.println(boardEdge);
		}
		for(int i = 0; i<8; i++){
			System.out.print("  " +i +"  ");
		}
		System.out.println();
	}
	
	
//// Test if it prints board correctly
	public static void main(String[] args){
		ChessBoard newChessGame = new ChessBoard();
		newChessGame.printBoard();
		ChessPieces piece = newChessGame.getPiece(0, 0);
		int[] location = piece.getXYLocation(newChessGame);
		for(int i =0 ; i<location.length;i++){
			System.out.print(location[i]+ " ");
		}
	}

}
