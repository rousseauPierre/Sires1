package othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OthelloTest {

	Othello othello;
	
	@Before
	public void setUp() {
		othello = new Othello("Test1", "Test2");
	}

	@Test
	public void testOthello() {
		assertNotNull(othello);
		assertSame(othello.getPlateau().length, Constantes.LIGNES);
        assertSame(othello.getPlateau()[0].length, Constantes.COLONNES);
	}

	@Test
	public void testGetCase() {
        for (int i = 0; i < Constantes.LIGNES; i++) {
            for (int j = 0; j < Constantes.COLONNES; j++) {
            	if((i == 3 && j == 3) || (i == 4 && j == 4))
            		assertEquals(othello.getCase(i, j), Constantes.BLANC);
            	else if((i == 4 && j == 3) || (i == 3 && j == 4))
            		assertEquals(othello.getCase(i, j), Constantes.NOIR);
            	else
            		assertEquals(othello.getCase(i, j), Constantes.VIDE);
            }
        }
	}

	@Test
	public void testSetCase() {
		othello.setCase(0, 0, Constantes.BLANC);
		assertEquals(othello.getCase(0, 0), Constantes.BLANC);
	}

	@Test
	public void testGetJ1() {
		assertEquals(othello.getJ1().getNom(), "Test1");
	}

	@Test
	public void testGetJ2() {
		assertEquals(othello.getJ2().getNom(), "Test2");
	}

	@Test
	public void testGetActif() {
		assertEquals(othello.getActif(), othello.getJ1());
		assertFalse(othello.getActif().equals(othello.getJ2()));
	}

}
