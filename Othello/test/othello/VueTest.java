package othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VueTest {

	Vue vue;
    Othello othello;
    
	@Before
	public void setUp() {
		othello = new Othello("Test1","Test2");
        vue = new Vue(othello);
	}

	@Test
	public void testVue() {
		assertNotNull(vue);
	}

	@Test
	public void testToString() {
        String attendu = "Test1 : 0\nTest2 : 0\n\n";
        attendu += "-----------------\n";
        attendu += "| | | | | | | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | | | | | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | | | | | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | |B|N| | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | |N|B| | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | | | | | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | | | | | | |\n";
        attendu += "-----------------\n";
        attendu += "| | | | | | | | |\n";
        attendu += "-----------------\n";
        assertEquals(attendu, vue.toString());
	}

}
