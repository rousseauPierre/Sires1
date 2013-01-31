package othello;

import othello.Constantes;

public class Case {

	private int x, y;
	private char valeur;

	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		valeur = Constantes.VIDE;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public char getValeur() {
		return valeur;
	}

	public void setValeur(char valeur) {
		this.valeur = valeur;
	}

	public String toString() {
		return "Case [x=" + x + ", y=" + y + ", valeur=" + valeur + "]";
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + this.valeur;
		hash = 23 * hash + this.x;
		hash = 23 * hash + this.y;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Case other = (Case) obj;
		if (this.valeur != other.valeur) {
			return false;
		}
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return true;
	}
}