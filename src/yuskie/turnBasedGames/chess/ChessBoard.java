package yuskie.turnBasedGames.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
	private ChessPieces[][] boardState;
	private Map<ChessPieces, int[]> location;
	
	public ChessBoard(){
		boardState = new ChessPieces[8][8];
		resetBoard();
		location = new HashMap<ChessPieces, int[]>();
	}
	
	public ChessPieces getPiece(int x, int y){
		return boardState[x][y];
	}
	
	private void resetBoard(){
		String color = "Black";
		for(int i = 0;i<8;){
			boardState[i][0] = new Rook(color);
			location.put(boardState[i][0], new int[]{i,0});
			boardState[i][1] = new Knight(color);
			location.put(boardState[i][1], new int[]{i,1});
			boardState[i][2] = new Bishop(color);
			location.put(boardState[i][2], new int[]{i,2});
			boardState[i][3] = new King(color);
			location.put(boardState[i][3], new int[]{i,3});
			boardState[i][4] = new Queen(color);
			location.put(boardState[i][4], new int[]{i,4});
			boardState[i][5] = new Bishop(color);
			location.put(boardState[i][5], new int[]{i,5});
			boardState[i][6] = new Knight(color);
			location.put(boardState[i][6], new int[]{i,6});
			boardState[i][7] = new Rook(color);
			location.put(boardState[i][7], new int[]{i,7});
			i+=1;
			if(i == 8){
				i = 6;
			}
			for(int j = 0; j<8;j++){
				boardState[i][j] = new Pawn(color);
				location.put(boardState[i][j], new int[]{i,j});
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
