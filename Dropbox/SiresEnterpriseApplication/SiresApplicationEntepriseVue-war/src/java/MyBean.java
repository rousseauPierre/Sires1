
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

@ManagedBean
public class MyBean {

    private String fichier = "coucou";
    private TreeNodeImpl documents = new TreeNodeImpl();
    private String identifiant, password;
    static ArrayList<String> liste;
    static int compteur = 0;
    TreeNode currentSelection = null;
    static String selection;
    String nouveau;

    String contenu="";
    
    @PostConstruct
    public void MyBean() {
        liste = new ArrayList<String>();
        liste.add("doc1");
        liste.add("doc2");

    }

    public String getNouveau() {
        return nouveau;
    }

    public void setNouveau(String nouveau) {
        this.nouveau = nouveau;
    }

    public String authenticate() {
        if (this.identifiant.equals("marouane") && this.password.equals("marouane")) {
            return "Redirection";
        } else {
            return "";
        }
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
//

        return documents;
    }

    public void add(String s) {
        liste.add(s);
    }

    public TreeNodeImpl getDocuments() {
        return documents;
    }

    public void setDocuments(TreeNodeImpl documents) {
        this.documents = documents;
    }

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

    public void selected() {
        System.out.println("dsdlkfffffffffffffffffffffffffffffffffffffffrefreferferfrej");

    }

    public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {


        List<Object> selection = new ArrayList<Object>(selectionChangeEvent.getNewSelection());
        Object currentSelectionKey = selection.get(0);
        UITree tree = (UITree) selectionChangeEvent.getSource();

        tree.setRowKey(currentSelectionKey);
        currentSelection = (TreeNode) tree.getRowData();

        if (!currentSelection.getChildrenKeysIterator().hasNext()) {
            this.selection = currentSelection.toString();
            setSelection(currentSelection.toString());
            System.out.println(currentSelection.toString());

        }


        System.out.println("CURRENT SELECTION " + currentSelection);
    }

    public String getCurrentSelection() {
        return selection;
    }

    public void setCurrentSelection(TreeNode se) {
        this.currentSelection = se;
    }

    public String getSelection() {
        if (currentSelection == null) {
            return "";
        }
        return currentSelection.toString();
    }

    public void setSelection(String s) {
        this.selection = s;
        System.out.println("update selection ::::!:!!!");
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;

    }

    public String getContenu(){return contenu;}
    public void setContenu(String contenu){this.contenu=contenu;}
    
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
      
        //return fichier;
    

}
