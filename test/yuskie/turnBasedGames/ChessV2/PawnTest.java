package yuskie.turnBasedGames.ChessV2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {
	private Pawn newPawn;
	
	@Before
	public void setup(){
		newPawn = new Pawn(Utility.Color.BLACK);
	}

	@Test
	public void constructor_test() {
		assertEquals(Utility.Color.BLACK, newPawn.getColor());
		assertFalse(newPawn.isMoved());
	}
	
	@Test
	public void moved_boolean_change(){
		newPawn.moved();
		assertTrue(newPawn.isMoved());
	}
	
	@Test
	public void movement_check(){
		assertTrue(newPawn.validMove("a1", "a2"));
		assertFalse(newPawn.validMove("a1", "b1"));
		assertTrue(newPawn.validMove("a1", "a3"));
	}

}
