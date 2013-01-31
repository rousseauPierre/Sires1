package othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JoueurTest {
	
	Joueur j;

	@Before
	public void setUp() throws Exception {
		j = new Joueur(Constantes.BLANC, 0, "Test");
	}

	@Test
	public void testJoueur() {
		assertNotNull(j);
	}

	@Test
	public void testGetCouleur() {
		assertEquals(j.getCouleur(), Constantes.BLANC);
	}

	@Test
	public void testGetNom() {
		assertEquals(j.getNom(), "Test");
	}

	@Test
	public void testGetPoints() {
		assertEquals(j.getPoints(), 0);
	}

	@Test
	public void testSetPoints() {
		j.setPoints(1);
		assertEquals(j.getPoints(), 1);
	}
	
}
