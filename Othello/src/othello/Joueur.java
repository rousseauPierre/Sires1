package othello;

public class Joueur {

	private int couleur, points;
	private String nom;

    public Joueur(int couleur, int points, String nom) {
        this.couleur = couleur;
        this.points = points;
        this.nom = nom;
    }

    public int getCouleur() {
        return couleur;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getNom() {
        return nom;
    }
    
}
