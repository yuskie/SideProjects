package yuskie.turnBasedGames.chess;

public interface ChessPiece{

	public boolean legalMove (String moveLoc, ChessBoard chessBoard);
	public String getColor();
	public String printPiece();
}
