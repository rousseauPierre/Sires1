package othello;

public class Vue {

    Othello othello;

    public Vue(Othello othello) {
        this.othello = othello;
    }
    
    public String toString(){
        String s = othello.getJ1().getNom() + " : " + othello.getJ1().getPoints() + "\n";
        s += othello.getJ2().getNom() + " : " + othello.getJ2().getPoints() + "\n";
        s += "\n"; 
        s += "-----------------\n";
        for(int i = 0; i < Constantes.LIGNES; i++){
            for(int j = 0; j < Constantes.COLONNES; j++){
                s += "|";
                switch(othello.getCase(i, j)){
                    case Constantes.NOIR:
                        s += "N";
                        break;
                    case Constantes.BLANC:
                        s += "B";
                        break;
                    default:
                        s += " ";
                        break;
                }
            }
            s += "|\n";
            s += "-----------------\n";
        }
        return s;
    }
}