package yuskie.turnBasedGames.ChessV2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void straight_movement_test() {
		assertFalse(Utility.straightMovement("a1", "b2", 5));
		assertFalse(Utility.straightMovement("g1", "i1", 5));
		assertFalse(Utility.straightMovement("a7", "a10", 5));
		assertFalse(Utility.straightMovement("a1", "a10", 5));
		assertTrue(Utility.straightMovement("c1", "g1", 8));
		assertTrue(Utility.straightMovement("d7", "a7", 3));
		assertTrue(Utility.straightMovement("d7", "c7", 3));
		assertTrue(Utility.straightMovement("d7", "e7", 3));
	}
	@Test
	public void diagonal_movement_test() {
		assertFalse(Utility.diagonalMovement("c1", "g1", 8));
		assertFalse(Utility.diagonalMovement("d7", "a7", 3));
		assertFalse(Utility.diagonalMovement("d7", "c7", 3));
		assertFalse(Utility.diagonalMovement("d7", "e7", 3));
		assertFalse(Utility.diagonalMovement("b2", "c4", 2));
		assertTrue(Utility.diagonalMovement("a1", "b2", 2));
		assertTrue(Utility.diagonalMovement("a1", "c3", 2));
		assertTrue(Utility.diagonalMovement("a1", "h8", 8));
		assertTrue(Utility.diagonalMovement("b2", "c3", 2));
	}
	@Test
	public void l_movement_test(){
		assertFalse(Utility.lMovement("c1", "g1"));
		assertFalse(Utility.lMovement("d7", "a7"));
		assertFalse(Utility.lMovement("d7", "c7"));
		assertFalse(Utility.lMovement("d7", "e7"));
		assertFalse(Utility.lMovement("b2", "c3"));
		assertFalse(Utility.lMovement("a1", "b2"));
		assertFalse(Utility.lMovement("g1", "i1"));
		assertFalse(Utility.lMovement("a7", "a10"));
		assertFalse(Utility.lMovement("a1", "a10"));
		assertTrue(Utility.lMovement("d4", "b5"));
		assertTrue(Utility.lMovement("d4", "b3"));
		assertTrue(Utility.lMovement("d4", "c2"));
		assertTrue(Utility.lMovement("d4", "c6"));
		assertTrue(Utility.lMovement("d4", "e2"));
		assertTrue(Utility.lMovement("d4", "e6"));
		assertTrue(Utility.lMovement("d4", "f3"));
		assertTrue(Utility.lMovement("d4", "f5"));
	}
}
