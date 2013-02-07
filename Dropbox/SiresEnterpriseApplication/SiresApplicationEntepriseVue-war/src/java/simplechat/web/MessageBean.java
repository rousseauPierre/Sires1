
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
public class MessageBean implements Serializable {

    @EJB
    MessageManagerLocal mm;

    private final List messages;
    private Date lastUpdate;
    private Message message;

    /**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
        messages = Collections.synchronizedList(new LinkedList());
        lastUpdate = new Date(0);
        message = new Message();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void sendMessage(ActionEvent evt) {
       //if(connect())
            mm.sendMessage(message);
    }

    public void firstUnreadMessage(ActionEvent evt) {
       RequestContext ctx = RequestContext.getCurrentInstance();
       Message m = mm.getFirstAfter(lastUpdate);

       ctx.addCallbackParam("ok", m!=null);
       if(m==null)
           return;

       lastUpdate = m.getDateSent();
       ctx.addCallbackParam("user", m.getUser());
       ctx.addCallbackParam("dateSent", m.getDateSent().toString());
       ctx.addCallbackParam("text", m.getMessage());

    }
    
   
}
