/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import com.projet.bean.Utilisateur;
import com.projet.dao.DAO;
import com.projet.dao.implement.UtilisateurDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pierre
 */
@ManagedBean
public class ConnectionManager implements Serializable {

    String identifiant;
    String password;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String authenticate() {
        
          DAO<Utilisateur> daod = new UtilisateurDAO();
          daod
    }
}
