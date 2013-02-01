package othello;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
            		assertEquals(othello.getValeur(i, j), Constantes.BLANC);
            	else if((i == 4 && j == 3) || (i == 3 && j == 4))
            		assertEquals(othello.getValeur(i, j), Constantes.NOIR);
            	else
            		assertEquals(othello.getValeur(i, j), Constantes.VIDE);
            }
        }
	}

	@Test
	public void testSetCase() {
		othello.setValeur(0, 0, Constantes.BLANC);
		assertEquals(othello.getValeur(0, 0), Constantes.BLANC);
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

	@Test
	public void testChangeActif() {
        othello.changeActif();
        assertEquals(othello.getActif(),othello.getJ2());
        othello.changeActif();
        assertEquals(othello.getActif(),othello.getJ1());
	}
	
    @Test
    public void testGetCasesJouables(){
        ArrayList<Case> cases = new ArrayList<Case>();
    
        cases.add(new Case(2,3));
        cases.add(new Case(3,2));
        cases.add(new Case(4,5));
        cases.add(new Case(5,4));
        
        assertArrayEquals(othello.getCasesJouables().toArray(),cases.toArray());
    }

}
