package othello;

public class Joueur {

	private char couleur;
	private String nom;
	private int points;

    public Joueur(char couleur, String nom, int points) {
        this.couleur = couleur;
        this.nom = nom;
        this.points = points;
    }

    public char getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
}
