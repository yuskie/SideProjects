package yuskie.turnBasedGames.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import yuskie.turnBasedGames.GameBase;

public class Chess extends GameBase {
	private List<Player> players;
	private ChessBoard newChessBoard;

	public Chess() {
		super(2);
		newChessBoard = new ChessBoard();
		players = new ArrayList<Player>();
	}

	@Override
	protected void setup(int numberOfPlayers) {
		players.add(new Player("White"));
		players.add(new Player("Black"));
	}

	@Override
	protected void takeTurn(int player) {
		Scanner scanner = new Scanner(System.in);
		Player currentPlayer = players.get(player-1);
		if(!currentPlayer.isCheckMate(newChessBoard)){
			boolean notMoved = true;
			while(notMoved){
				System.out.println("What piece would you like to move? " );
				String pieceMoving = scanner.nextLine().toLowerCase();
				System.out.println("Where would you like to move it? ");
				String location = scanner.nextLine().toLowerCase();
				notMoved = newChessBoard.movePiece(currentPlayer.getColor() ,pieceMoving, location);
				if(notMoved){
					System.out.println("Invalid move");
				}
			}
		}
		scanner.close();
	}

	@Override
	protected boolean isGameOver() {
		return getActivePlayers().size() == 1;
	}

	@Override
	protected void finishGame() {
		Player winner = getActivePlayers().get(0);
		System.out.println("Congratz! Player " + winner.getColor() + " is the winner!!!");
	}
	private List<Player> getActivePlayers() {
		List<Player> activePlayers = new ArrayList<Player>();
		for(Player p : players) {
			if(!p.isCheckMate(newChessBoard)) {
				activePlayers.add(p);
			}
		}
		return activePlayers;
	}
}
