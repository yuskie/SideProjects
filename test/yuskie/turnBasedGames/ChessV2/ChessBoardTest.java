package yuskie.turnBasedGames.ChessV2;
import static org.junit.Assert.*;

import org.junit.Test;

import yuskie.turnBasedGames.ChessV2.ChessBoard;

public class ChessBoardTest {

	@Test
	public void constructor_test() {
		ChessBoard newBoard = new ChessBoard();
		assertEquals(64, newBoard.getBoardState().size());
	}

	@Test
	public void constructor_test_checking_piece_loc_visual_test() {
		ChessBoard newBoard = new ChessBoard();
		newBoard.print();
	}

	@Test
	public void constructor_test_unique_pieces_address_checking() {
		ChessBoard newBoard = new ChessBoard();
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

//	// Tests wrote to test private methods.
//	@Test
//	public void getXValue_test() {
//		ChessBoard newBoard = new ChessBoard();
//		int xLoc = newBoard.getXValue("a1");
//		String xValue = Utility.XVALUES[xLoc];
//		assertEquals(0, xLoc);
//		assertEquals("a", xValue);
//	}
//
//	@Test
//	public void getYValue_test() {
//		ChessBoard newBoard = new ChessBoard();
//		int yLoc = newBoard.getYValue("a1");
//		assertEquals(1, yLoc);
//		assertEquals(-1, newBoard.getYValue("aa"));
//		assertEquals(-1, newBoard.getYValue("a9"));
//	}
}
