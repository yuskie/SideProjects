package yuskie.turnBasedGames.chess;

public interface ChessPieces{

	public String[] possibleMovements(ChessBoard currentState);
	public String getColor();
	public String printPiece();
	public int[] getXYLocation(ChessBoard currentState);
}
