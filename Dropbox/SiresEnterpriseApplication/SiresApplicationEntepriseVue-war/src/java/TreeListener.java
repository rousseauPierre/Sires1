
import javax.faces.event.AbortProcessingException;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.event.TreeSelectionChangeListener;


public class TreeListener implements TreeSelectionChangeListener{
            public TreeListener(){
                
            }

    @Override
    public void processTreeSelectionChange(TreeSelectionChangeEvent tsce) throws AbortProcessingException {
      
        System.out.println("hahah "+tsce.getComponent());             
    }
    
}