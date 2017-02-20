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
	
	@Test
	public void move_piece_with_same_color_block(){
		newBoard.setupNewGame();
		Piece before_movement = newBoard.getBoardState().get("a1");
		assertFalse(newBoard.movePiece(WHITE, "a1", "a3"));
		assertNotNull(newBoard.getBoardState().get("a1"));
		assertNull(newBoard.getBoardState().get("a3"));
		assertEquals(before_movement, newBoard.getBoardState().get("a1"));
		assertTrue(newBoard.movePiece(WHITE, "b1", "c3"));
		assertNotNull(newBoard.getBoardState().get("c3"));
		assertNull(newBoard.getBoardState().get("b1"));
	}
	
	@Test
	public void destroy_enemy_piece(){
		Queen whiteQueen = new Queen(WHITE);
		newBoard.getBoardState().put("d4", whiteQueen);
		newBoard.getBoardState().put("d5", new Pawn(BLACK));
		newBoard.movePiece(WHITE, "d4", "d5");
		assertNull(newBoard.getBoardState().get("d4"));
		assertEquals(whiteQueen, newBoard.getBoardState().get("d5"));
	}
	
	@Test
	public void castling_left_rook(){
		King whiteKing = new King(WHITE);
		King blackKing = new King(BLACK);
		Rook whiteRook = new Rook(WHITE);
		Rook blackRook = new Rook(BLACK);
		newBoard.getBoardState().put("e1", whiteKing);
		newBoard.getBoardState().put("e8", blackKing);
		newBoard.getBoardState().put("a1", whiteRook);
		newBoard.getBoardState().put("a8", blackRook);
		assertTrue(newBoard.movePiece(WHITE, "e1", "c1"));
		assertNull(newBoard.getBoardState().get("e1"));
		assertNull(newBoard.getBoardState().get("a1"));
		assertNotNull(newBoard.getBoardState().get("c1"));
		assertNotNull(newBoard.getBoardState().get("d1"));
		assertFalse(newBoard.movePiece(WHITE, "c1", "c3"));
		
		assertTrue(newBoard.movePiece(BLACK, "e8", "c8"));
		assertNull(newBoard.getBoardState().get("e8"));
		assertNull(newBoard.getBoardState().get("a8"));
		assertNotNull(newBoard.getBoardState().get("c8"));
		assertNotNull(newBoard.getBoardState().get("d8"));
		assertFalse(newBoard.movePiece(BLACK, "c8", "e8"));

	}
	
	@Test
	public void castling_right_rook(){
		King whiteKing = new King(WHITE);
		King blackKing = new King(BLACK);
		Rook whiteRook = new Rook(WHITE);
		Rook blackRook = new Rook(BLACK);
		newBoard.getBoardState().put("e1", whiteKing);
		newBoard.getBoardState().put("e8", blackKing);
		newBoard.getBoardState().put("h1", whiteRook);
		newBoard.getBoardState().put("h8", blackRook);
		assertTrue(newBoard.movePiece(WHITE, "e1", "g1"));
		assertNull(newBoard.getBoardState().get("e1"));
		assertNull(newBoard.getBoardState().get("h1"));
		assertNotNull(newBoard.getBoardState().get("g1"));
		assertNotNull(newBoard.getBoardState().get("f1"));
		assertFalse(newBoard.movePiece(WHITE, "g1", "e1"));
		
		assertTrue(newBoard.movePiece(BLACK, "e8", "g8"));
		assertNull(newBoard.getBoardState().get("e8"));
		assertNull(newBoard.getBoardState().get("h8"));
		assertNotNull(newBoard.getBoardState().get("g8"));
		assertNotNull(newBoard.getBoardState().get("f8"));
		assertFalse(newBoard.movePiece(BLACK, "g8", "e8"));
		
	}
	
	@Test
	public void pawn_promotion(){
		Pawn blackPawn = new Pawn(BLACK);
		Pawn whitePawn = new Pawn(WHITE);
		newBoard.getBoardState().put("a7", whitePawn);
		newBoard.getBoardState().put("a2", blackPawn);
		newBoard.movePiece(WHITE, "a7", "a8");
		assertNotEquals(newBoard.getBoardState().get("a8").getClass(), Pawn.class);
		newBoard.movePiece(BLACK, "a2", "a1");
		assertNotEquals(newBoard.getBoardState().get("a1").getClass(), Pawn.class);
	}
}
