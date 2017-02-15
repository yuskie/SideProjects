package yuskie.turnBasedGames.ChessV2;
import static org.junit.Assert.*;
import static yuskie.turnBasedGames.ChessV2.Utility.Color.*;

import org.junit.Before;
import org.junit.Test;

import yuskie.turnBasedGames.ChessV2.ChessBoard;

public class ChessBoardTest {

	private ChessBoard newBoard;
	
	@Before
	public void setup(){
		newBoard = new ChessBoard();
	}
	
	@Test
	public void constructor_test() {
		assertEquals(64, newBoard.getBoardState().size());
	}
	
	@Test
	public void setup_board_test(){
		newBoard.setupNewGame();
		assertEquals(64, newBoard.getBoardState().size());
	}
	@Test
	public void constructor_test_checking_piece_loc_visual_test() {
		newBoard.setupNewGame();
		newBoard.print();
	}

	@Test
	public void constructor_test_unique_pieces_address_checking() {
		newBoard.setupNewGame();
		Object[] pieceArray = newBoard.getBoardState().values().toArray();
		boolean duplicates = false;
		for (int i = 0; i < pieceArray.length; i++) {
			for (int j = i + 1; j < pieceArray.length; j++) {
				if (pieceArray[i] != null && pieceArray[i] == pieceArray[j]) {
					duplicates = true;
				}
			}
		}
		assertFalse(duplicates);
	}

	@Test
	public void move_piece_with_no_block(){
		newBoard.setupNewGame();
		assertTrue(newBoard.movePiece(WHITE, "a2", "a3"));
		assertNotNull(newBoard.getBoardState().get("a3"));
		assertNull(newBoard.getBoardState().get("a2"));
	}
	
	public void move_piece_with_same_color_block(){
		newBoard.setupNewGame();
		Piece before_movement = newBoard.getBoardState().get("a1");
		assertFalse(newBoard.movePiece(WHITE, "a1", "a3"));
		assertNotNull(newBoard.getBoardState().get("a1"));
		assertNull(newBoard.getBoardState().get("a3"));
		assertEquals(before_movement, newBoard.getBoardState().get("a1"));
	}
	
	public void destroy_enemy_piece(){
		Queen whiteQueen = new Queen(WHITE);
		newBoard.getBoardState().put("d4", whiteQueen);
		newBoard.getBoardState().put("d5", new Pawn(BLACK));
		newBoard.movePiece(WHITE, "d4", "d5");
		assertNull(newBoard.getBoardState().get("d4"));
		assertEquals(whiteQueen, newBoard.getBoardState().get("d5"));
	}
}
