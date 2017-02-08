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

	}

}
