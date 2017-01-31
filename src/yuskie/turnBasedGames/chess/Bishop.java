package yuskie.turnBasedGames.chess;

public class Bishop implements ChessPiece{
	
	private String color;
	public Bishop(String color){
		this.color = color;
	}

	public boolean legalMove(String moveLoc, ChessBoard chessBoard) {
		ChessPiece occupiedPiece = chessBoard.isOccupied(moveLoc);
		String pieceLoc = chessBoard.getPieceLocation().get(this);
		boolean canMove = false;
		String[] loc = chessBoard.getPieceLocation().get(this).split(":");
		String xLoc = loc[0];
		int yLoc = Integer.parseInt(loc[1]);
		int xvaluesIndexLoc =0;
		for(int i = 0; i< ChessBoard.XVALUES.length; i++){
			if(xLoc.equals(ChessBoard.XVALUES[i])){
				xvaluesIndexLoc = i;
			}
		}
		for(int i = 0; i <8;i++){
			
		}
		if(occupiedPiece == null){
			chessBoard.getBoardState().put(pieceLoc, null);
			chessBoard.getBoardState().put(moveLoc, this);
			return true;
		}else if(occupiedPiece.getColor().equals(color)){
			return false;
		}else{
			chessBoard.getBoardState().put(pieceLoc, null);
			chessBoard.getBoardState().put(moveLoc, this);
			return true;
		}
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
	
}
