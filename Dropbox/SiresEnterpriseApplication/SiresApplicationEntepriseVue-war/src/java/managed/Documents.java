package managed;




import org.richfaces.model.TreeNodeImpl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marouane
 */
public class Documents extends TreeNodeImpl {
    private String nom;
    private String url;
    
    public Documents(String nom, String url) {
        this.nom = nom;
        this.url=url;
    }

    public Documents(String nom) {
        this.nom = nom;
    }
    
  
   public String value(){
       return url;
   }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
    
    
    
}
