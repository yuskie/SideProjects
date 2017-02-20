package yuskie.turnBasedGames.ChessV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import yuskie.turnBasedGames.ChessV2.Utility.Color;

public class ChessBoard {
	private Map<String, Piece> boardState;

	private static final int X_BLACK_PAWN_START_LOC = 0;
	private static final int Y_BLACK_PAWN_START_LOC = 7;

	private static final int X_WHITE_PAWN_START_LOC = 0;
	private static final int Y_WHITE_PAWN_START_LOC = 2;

	private static final int X_BLACK_BACK_START_LOC = 0;
	private static final int Y_BLACK_BACK_START_LOC = 8;

	private static final int X_WHITE_BACK_START_LOC = 0;
	private static final int Y_WHITE_BACK_START_LOC = 1;

	private static final int BOARD_SIZE = 8;
	
	private boolean pawnMoved = false;

	public ChessBoard() {
		boardState = new HashMap<String, Piece>();
		initializeBoardState();
	}
	
	public void setupNewGame(){
		setupPawn(Utility.Color.BLACK, X_BLACK_PAWN_START_LOC, Y_BLACK_PAWN_START_LOC);
		setupPawn(Utility.Color.WHITE, X_WHITE_PAWN_START_LOC, Y_WHITE_PAWN_START_LOC);
		setupBackRow(Utility.Color.BLACK, X_BLACK_BACK_START_LOC, Y_BLACK_BACK_START_LOC);
		setupBackRow(Utility.Color.WHITE, X_WHITE_BACK_START_LOC, Y_WHITE_BACK_START_LOC);
	}
	public boolean movePiece(Color color, String startLocation, String endLocation) {
		Piece movingPiece = boardState.get(startLocation);
		if (movingPiece == null || movingPiece.getColor() != color) {
			return false;
		}else if (checkValidMove(startLocation, endLocation, movingPiece)) {
			movePieces(startLocation, endLocation, movingPiece);
			pawnPromotion(endLocation, movingPiece);
			return true;
		}else if(movingPiece.getClass() == King.class){
			King kingPiece = (King) movingPiece;
			if(canCastle(startLocation, endLocation, kingPiece));{
				String closestRookLoc = getCastlingRookLoc(endLocation);
				Piece castleRook = boardState.get(closestRookLoc);
				if(castleRook != null && castleRook.getClass() == Rook.class && !castleRook.isMoved()){
					castling(startLocation, endLocation, kingPiece, closestRookLoc, castleRook);
					return true;
				}
			}
		}
		return false;
	}

	private void pawnPromotion(String endLocation, Piece movingPiece) {
		if(movingPiece.getClass()==Pawn.class && (Integer.parseInt(endLocation.substring(1))==1 || Integer.parseInt(endLocation.substring(1))==8)){
			if(movingPiece.getColor().equals(Utility.Color.BLACK) && Integer.parseInt(endLocation.substring(1))==1){
				promotePawn(endLocation, movingPiece.getColor());
			}else if(movingPiece.getColor().equals(Utility.Color.WHITE) && Integer.parseInt(endLocation.substring(1))==8){
				promotePawn(endLocation, movingPiece.getColor());
			}
		}
	}

	private void promotePawn(String pawnLocation, Color color){
		Scanner temp = new Scanner(System.in);
		boolean undecided = true;
		while(undecided){
			System.out.print("What would you like to promote to? (KN, B, Q, R)");
			undecided = false;
			String pieceType = temp.nextLine().toLowerCase();
			if(pieceType.equals("kn")){
				boardState.put(pawnLocation, new Knight(color));
			}else if(pieceType.equals("b")){
				boardState.put(pawnLocation, new Bishop(color));
			}else if(pieceType.equals("q")){
				boardState.put(pawnLocation, new Queen(color));
			}else if(pieceType.equals("r")){
				boardState.put(pawnLocation, new Rook(color));
			}else{
				System.out.println("Input invalid. Try again");
				undecided = true;
			}
		}
	}
	
	private boolean canCastle(String startLocation, String endLocation, King kingPiece) {
		return Utility.castlingMovement(startLocation, endLocation, kingPiece.isMoved()) && blockingPath(startLocation, endLocation);
	}

	private boolean checkValidMove(String startLocation, String endLocation, Piece movingPiece) {
		return movingPiece.validMove(startLocation, endLocation) && blockingPath(startLocation, endLocation);
	}

	private void movePieces(String startLocation, String endLocation, Piece movingPiece) {
		boardState.put(endLocation, boardState.get(startLocation));
		boardState.put(startLocation, null);
		movingPiece.moved();
	}

	private void castling(String startLocation, String endLocation, King kingPiece, String closestRookLoc,
			Piece castleRook) {
		String rookEndLoc = getRookEndLoc(closestRookLoc);
		boardState.put(endLocation, kingPiece);
		boardState.put(rookEndLoc, castleRook);
		boardState.put(startLocation, null);
		boardState.put(closestRookLoc, null);
	}

	private String getRookEndLoc(String closestRookLoc) {
		String rookEndLoc = "";
		if(closestRookLoc.substring(0,1).equals(Utility.XVALUES[0])){
			rookEndLoc = Utility.XVALUES[3].concat(closestRookLoc.substring(1));
		}else{
			rookEndLoc = Utility.XVALUES[5].concat(closestRookLoc.substring(1));
		}
		return rookEndLoc;
	}

	public boolean isCheckMate(Color color) {
		return false;
	}
	
	private String getCastlingRookLoc(String endLocation){
		String rookLoc = endLocation.substring(1);
		String result;
		if(endLocation.substring(0,1) != null && endLocation.substring(0,1).equals("g")){
			int hLocation = 7;
			result = Utility.XVALUES[hLocation].concat(rookLoc);
		}else{
			int aLocation = 0;
			result = Utility.XVALUES[aLocation].concat(rookLoc);
		}
		return result;
	}

	public void print() {
		String border = createBorder();
		System.out.println(border);
		for (int i = BOARD_SIZE; i > 0; i--) {
			for (int j = 0; j < Utility.XVALUES.length; j++) {
				System.out.print("|");
				if (boardState.get(Utility.XVALUES[j] + i) == null) {
					System.out.printf("%5s", "");
				} else {
					System.out.printf("%5s", boardState.get(Utility.XVALUES[j] + i).print());
				}
			}
			System.out.print("|");
			System.out.println();
			System.out.println(border);
		}
	}
	
	public Map<String, Piece> getBoardState() {
		return boardState;
	}

	private String createBorder() {
		String result = "";
		for (int i = 0; i < 49; i++) {
			result += "-";
		}
		return result;
	}

	private boolean blockingPath(String startLocation, String endLocation) {
		Piece endLocPiece = boardState.get(endLocation);
		Piece startPiece = boardState.get(startLocation);
		if (endLocPiece != null && endLocPiece.getColor() == startPiece.getColor()) {
			return false;
		}
		String nextString = startLocation;
		while (!Utility.getNextLoc(nextString, endLocation).equals(endLocation)) {
			nextString = Utility.getNextLoc(nextString, endLocation);
			if (boardState.get(nextString) != null) {
				return false;
			}
		}
		return true;
	}
	
	private void initializeBoardState() {
		for (int i = 0; i < Utility.XVALUES.length; i++) {
			for (int j = 1; j <= BOARD_SIZE; j++) {
				boardState.put(Utility.XVALUES[i] + j, null);
			}
		}
	}
	
	private void setupPawn(Color color, int xValueLoc, int yLocation) {
		for (int i = 0; i < Utility.XVALUES.length; i++) {
			Pawn temp = new Pawn(color);
			boardState.put(Utility.XVALUES[xValueLoc] + yLocation, temp);
			xValueLoc++;
		}
	}
	
	private void setupBackRow(Color color, int xValueLoc, int yLocation) {
		Piece[] backRow = { new Rook(color), new Knight(color), new Bishop(color), new Queen(color), new King(color),
				new Bishop(color), new Knight(color), new Rook(color) };
		for (int i = 0; i < Utility.XVALUES.length; i++) {
			boardState.put(Utility.XVALUES[xValueLoc] + yLocation, backRow[i]);
			xValueLoc++;
		}
	}
}
