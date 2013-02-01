package othello;

import java.util.Scanner;

public class Vue {

    Othello othello;
    Scanner sc;

    public Vue(Othello othello) {
        this.othello = othello;
        sc = new Scanner(System.in);
    }
    
    public String toString(){
        String s = othello.getJ1().getNom() + " : " + othello.getJ1().getPoints() + "\n";
        s += othello.getJ2().getNom() + " : " + othello.getJ2().getPoints() + "\n";
        s += "\n"; 
        s += "-----------------\n";
        for(int i = 0; i < Constantes.LIGNES; i++){
            for(int j = 0; j < Constantes.COLONNES; j++){
                s += "|" + othello.getValeur(i, j);
            }
            s += "|\n";
            s += "-----------------\n";
        }
        return s;
    }
    
    public Case saisirCase(){ 		
		int ligne = 0;
		int colonne = 0;
		
		boolean valide;
		
		System.out.println("Ligne :");
		valide = false;
		while(!valide){
			try{
				ligne = Integer.parseInt(sc.nextLine());
				if(ligne <= 0 || ligne > Constantes.LIGNES) {
					System.out.println("Cette ligne n'est pas valide !");
					valide = false;
				}
				else valide = true;
			}catch(Exception e){
				System.out.println("Cette ligne n'est pas valide !");
				valide = false;
			}
		}
		
		System.out.println("Colonne :");
		valide = false;
		while(!valide){
			try{
				colonne = Integer.parseInt(sc.nextLine());
				if(colonne <= 0 || colonne > Constantes.COLONNES) {
					System.out.println("Cette colonne n'est pas valide !");
					valide = false;
				}
				else valide = true;
			}catch(Exception e){
				System.out.println("Cette colonne n'est pas valide !");
				valide = false;
			}
		}
		
		if(valide)
			return othello.getCase(ligne, colonne);
		else
			return null;
    }
}