package simplechat.ejb;

import java.util.Date;
import javax.ejb.Local;
import javax.ejb.Remote;



/**
 * Local interface for chat lagic EJB
 * @author Danon
 */
@Remote
public interface MessageManagerLocal {

    void sendMessage(Message msg);

    Message getFirstAfter(Date after);

}