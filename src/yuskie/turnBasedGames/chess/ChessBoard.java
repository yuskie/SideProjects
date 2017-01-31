package yuskie.turnBasedGames.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
	private Map<String,ChessPiece> boardState;
	private Map<ChessPiece, String> pieceLocation;
	public static final String[] XVALUES = new String[]{"a","b","c","d","e","f","g","h"};
	
	public ChessBoard(){
		boardState = new HashMap<String, ChessPiece>();
		pieceLocation = new HashMap<ChessPiece, String>();
		resetBoard();
	}
	
	private void resetBoard(){
		String color = "White";
		for(int j =0; j<8; j++){
			ChessPiece[] allBackrowPieces = new ChessPiece[]{new Rook(color), new Knight(color), new Bishop(color), 
					new Queen(color), new King(color), new Bishop(color), new Knight(color), new Rook(color)};
			for(int i=0; i<XVALUES.length;i++){
				String xLetterValue = XVALUES[i];
				if(j==6){
					color ="Black";
				}
				if(j==0 || j==7){
					if(color.equals("Black")&&xLetterValue.equals("d")){
						boardState.put(xLetterValue+":"+Integer.toString(j+1), allBackrowPieces[i+1]);
						pieceLocation.put(allBackrowPieces[i+1], xLetterValue+":"+Integer.toString(j+1));
					}else if(color.equals("Black")&&xLetterValue.equals("e")){
						boardState.put(xLetterValue+":"+Integer.toString(j+1), allBackrowPieces[i-1]);
						pieceLocation.put(allBackrowPieces[i-1],xLetterValue+":"+Integer.toString(j+1));
					}else{
						boardState.put(xLetterValue+":"+Integer.toString(j+1), allBackrowPieces[i]);
						pieceLocation.put(allBackrowPieces[i],xLetterValue+":"+Integer.toString(j+1));
					}
				}else if(j==1 || j==6){
					Pawn newPawn = new Pawn(color);
					boardState.put(xLetterValue+":"+Integer.toString(j+1), newPawn);
					pieceLocation.put(newPawn, xLetterValue+":"+Integer.toString(j+1));
				}else{
					boardState.put(xLetterValue+":"+Integer.toString(j+1), null);
				}
			}
		}
	}
	
	public boolean movePiece(String playerColor, String pieceLoc, String moveLoc){
		ChessPiece pieceToMove = boardState.get(pieceLoc);
		if(pieceToMove.legalMove(moveLoc, this)){
			return true;
		}
		return false;
	}
	
	public void printBoard(){
		// Constructs board edges
		String boardEdge="";
		for(int i=0; i <49; i++){
			boardEdge= boardEdge.concat("-");
		}
		System.out.println(boardEdge);
		for(int i=0; i<8; i++){
			System.out.printf("|");
			for(int j=0; j<8; j++){
				String xLetterValue = XVALUES[j];
				String boardStateKey = xLetterValue + ":"+ Integer.toString(i+1);
				ChessPiece piece = boardState.get(boardStateKey);
				if(piece == null){
					System.out.printf("%6s", "|");
				}else{
					System.out.printf("%-5s",piece.printPiece());
					System.out.print("|");
				}
			}
			System.out.println();
			System.out.println(boardEdge);
		}
		
		
	}
	
	public ChessPiece isOccupied(String position){
		return boardState.get(position);
	}
	
//// Test if it prints board correctly
	public static void main(String[] args){
		ChessBoard newChessGame = new ChessBoard();
		newChessGame.printBoard();
		for(String i :newChessGame.getBoardState().keySet()){
			if(newChessGame.getBoardState().get(i) == null){
				System.out.println(i + " : null");
			}else{
				System.out.println(i + " : " + newChessGame.getBoardState().get(i).printPiece());
			}
		}
		for(ChessPiece i :newChessGame.getPieceLocation().keySet()){
			if(newChessGame.getPieceLocation().get(i) == null){
				System.out.println(i + " : null");
			}else{
				System.out.println(i.printPiece() + " : " + newChessGame.getPieceLocation().get(i));
			}
		}
	}

	public Map<String, ChessPiece> getBoardState() {
		return boardState;
	}

	public Map<ChessPiece, String> getPieceLocation() {
		return pieceLocation;
	}

}
