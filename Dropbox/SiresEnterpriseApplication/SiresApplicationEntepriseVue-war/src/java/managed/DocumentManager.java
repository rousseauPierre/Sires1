/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

/**
 *
 * @author pierre
 */
@ManagedBean
public class DocumentManager {

    private TreeNodeImpl documents = new TreeNodeImpl();
    private TreeNode currentSelection = null;
    String contenu = "";
    String selection;

    public TreeNodeImpl getDocuments() {
        return documents;
    }

    public void setDocuments(TreeNodeImpl documents) {
        this.documents = documents;
    }

    public TreeNode getCurrentSelection() {
        return currentSelection;
    }

    public void setCurrentSelection(TreeNode currentSelection) {
        this.currentSelection = currentSelection;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
    
    

    public TreeNodeImpl init() {
        File repertoire = new File("/home/pierre/Dropbox/MAQ/");
        System.out.println(repertoire.listFiles()[0]);
        int i = 0;
        documents.addChild("doc1", new Documents("Document1"));
        for (File fils : repertoire.listFiles()) {
            i++;
            documents.getChild("doc1").addChild("rev" + i, new Documents(fils.getName()));

        }
        return documents;
    }

    public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {
        List<Object> selection = new ArrayList<Object>(selectionChangeEvent.getNewSelection());
        Object currentSelectionKey = selection.get(0);
        UITree tree = (UITree) selectionChangeEvent.getSource();
        tree.setRowKey(currentSelectionKey);
        currentSelection = (TreeNode) tree.getRowData();
        System.out.println(currentSelection);
        if (!currentSelection.getChildrenKeysIterator().hasNext()) {
            this.selection = currentSelection.toString();
        }
    }
    
    public void lecture(String current) throws FileNotFoundException {
       if(current!=null){
           File fichier =   new File("/home/pierre/Dropbox/MAQ/"+current);
          
           contenu="";
           Scanner flex = new Scanner(fichier);
           while(flex.hasNextLine()){
               contenu+=flex.nextLine();
           }
       }
            
       else contenu="null "+"courant";
    }
    
    
}
