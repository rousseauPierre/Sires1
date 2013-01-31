package othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaseTest {

	private Case c, c2;

	@Before
	public void setUp() {
		c  = new Case(0, 0);
		c2 = new Case(0, 0);
	}

	@Test
	public void testCase() {
		assertNotNull(c);
	}

	@Test
	public void testGetX() {
		assertEquals(c.getX(), 0);
	}
	
	@Test
	public void testGetY() {
		assertEquals(c.getY(), 0);
	}

	@Test
	public void testGetValeur() {
		assertEquals(c.getValeur(), Constantes.VIDE);
	}

	@Test
	public void testSetValeur() {
		c.setValeur(Constantes.BLANC);
		assertEquals(c.getValeur(), Constantes.BLANC);
	}

	@Test
	public void testToString() {
		assertEquals(c.toString(), "Case [x=0, y=0, valeur= ]");
	}

	@Test
	public void testEquals() {
		assertEquals(c, c2);
		c2.setValeur(Constantes.BLANC);
		assertFalse(c.equals(c2));
	}

}
