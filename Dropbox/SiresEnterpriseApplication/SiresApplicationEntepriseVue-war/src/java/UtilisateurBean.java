
package simplechat.web;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import simplechat.ejb.Message;
import simplechat.ejb.MessageManagerLocal;



/**
 *
 * @author Anton Danshin
 */
@ManagedBean
@ViewScoped
public class UtilisateurBean implements Serializable {

   String pseudo="";
    /**
     * Creates a new instance of MessageBean
     */
    public UtilisateurBean() {
        /*messages = Collections.synchronizedList(new LinkedList());
        lastUpdate = new Date(0);
        message = new Message();*/
        
    }

    public String getPseudo(){
        return pseudo;
    }
    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
        
    }
}
