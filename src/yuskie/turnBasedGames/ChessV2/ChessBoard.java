package yuskie.turnBasedGames.ChessV2;

import java.util.HashMap;
import java.util.Map;

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
		}
		if (movingPiece.validMove(startLocation, endLocation) && blockingPath(startLocation, endLocation)) {
			boardState.put(endLocation, boardState.get(startLocation));
			boardState.put(startLocation, null);
			return true;
		}
		return false;
	}

	public boolean isCheckMate(Color color) {
		return false;
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
