package othello;

public class Othello {
	
    private Case[][] plateau;
    private Joueur j1, j2, actif;

    public Othello(String nomJ1, String nomJ2) {
        this.plateau = new Case[Constantes.LIGNES][Constantes.COLONNES];
        for (int i = 0; i < Constantes.LIGNES; i++) {
            for (int j = 0; j < Constantes.COLONNES; j++) {
                plateau[i][j] = new Case(i, j);
            }
        }

        setCase(3, 3, Constantes.BLANC);
        setCase(4, 4, Constantes.BLANC);
        setCase(3, 4, Constantes.NOIR);
        setCase(4, 3, Constantes.NOIR);

        j1 = new Joueur(Constantes.NOIR, nomJ1, 0);
        j2 = new Joueur(Constantes.BLANC, nomJ2, 0);
        actif = j1;
    }
    
    public Case[][] getPlateau() {
        return plateau;
    }
    
    public char getCase(int x, int y) {
        return plateau[x][y].getValeur();
    }

    public void setCase(int x, int y, char c) {
        plateau[x][y].setValeur(c);
    }
    
    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public Joueur getActif() {
        return actif;
    }
}
