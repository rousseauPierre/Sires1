package othello;

import java.util.ArrayList;

public class Othello {
	
    private Case[][] plateau;
    private Joueur j1, j2;
    private boolean j1Actif;

    public Othello(String nomJ1, String nomJ2) {
        this.plateau = new Case[Constantes.LIGNES][Constantes.COLONNES];
        for (int i = 0; i < Constantes.LIGNES; i++) {
            for (int j = 0; j < Constantes.COLONNES; j++) {
                plateau[i][j] = new Case(i, j);
            }
        }

        setValeur(3, 3, Constantes.BLANC);
        setValeur(4, 4, Constantes.BLANC);
        setValeur(3, 4, Constantes.NOIR);
        setValeur(4, 3, Constantes.NOIR);

        j1 = new Joueur(Constantes.NOIR, nomJ1, 0);
        j2 = new Joueur(Constantes.BLANC, nomJ2, 0);
        j1Actif = true;
    }
    
    public Case[][] getPlateau() {
        return plateau;
    }
    
    public Case getCase(int x, int y) {
        return plateau[x][y];
    }
    
    public char getValeur(int x, int y) {
        return plateau[x][y].getValeur();
    }

    public void setValeur(int x, int y, char c) {
        plateau[x][y].setValeur(c);
    }
    
    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public Joueur getActif() {
        if(j1Actif) return j1;
        return j2;
    }
    
    public char getCouleurAdverse() {
        if(j1Actif) return j2.getCouleur();
        return j1.getCouleur();
    }
    
    public void changeActif() {
        j1Actif = !j1Actif;
    }

    public ArrayList<Case> getCasesJouables() {
        ArrayList<Case> casesJouables = new ArrayList<Case>();
        int x, y;

        for (int i = 0; i < Constantes.LIGNES; i++) {
            for (int j = 0; j < Constantes.COLONNES; j++) {
                if (getValeur(i, j) == Constantes.VIDE) {

                    x = i - 1;
                    y = j;
                    while (x >= 0 && getValeur(x, y) == getCouleurAdverse()) {
                        x--;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }

                    x = i + 1;
                    y = j;
                    while (x <= Constantes.LIGNES - 1 && getValeur(x, y) == getCouleurAdverse()) {
                        x++;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }

                    x = i;
                    y = j - 1;
                    while (y >= 0 && getValeur(x, y) == getCouleurAdverse()) {
                        y--;
                        if (getCase(x, y).getValeur() == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }

                    x = i;
                    y = j + 1;
                    while (y <= Constantes.COLONNES - 1 && getValeur(x, y) == getCouleurAdverse()) {
                        y++;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }

                    x = i - 1;
                    y = j - 1;
                    while (x >= 0 && y >= 0 && getValeur(x, y) == getCouleurAdverse()) {
                        x--;
                        y--;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }
                    x = i + 1;
                    y = j + 1;
                    while (x <= Constantes.LIGNES - 1 && y <= Constantes.COLONNES - 1 && getValeur(x, y) == getCouleurAdverse()) {
                        x++;
                        y++;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }

                    x = i + 1;
                    y = j - 1;
                    while (x < Constantes.LIGNES && y >= 0 && getValeur(x, y) == getCouleurAdverse()) {
                        x++;
                        y--;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }
                    
                    x = i - 1;
                    y = j + 1;
                    while (x >= 0 && y <= Constantes.COLONNES - 1 && getValeur(x, y) == getCouleurAdverse()) {
                        x--;
                        y++;
                        if (getValeur(x, y) == getActif().getCouleur()) {
                        	casesJouables.add(getCase(i, j));
                        }
                    }
                }
            }
        }

        return casesJouables;
    }
}
