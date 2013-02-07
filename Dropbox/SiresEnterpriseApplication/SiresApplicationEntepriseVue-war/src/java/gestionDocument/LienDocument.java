/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDocument;

import com.projet.bean.Document;
import com.projet.dao.DAO;
import com.projet.dao.DAOFactory;

/**
 *
 * @author thibaud
 */
public class LienDocument
{
    private static DAO<Document> daoDoc = DAOFactory.getDocumentDAO();
    private static GestionDocument gestDoc;
    
    public static void CreerDocument(String titre)
    {
         gestDoc = new GestionDocument(titre, "");
         gestDoc.commit();
         
         Document doc = new Document();
         
         doc.setTitre(titre);
         doc.setPrive(false);
         
         daoDoc.create(doc);
    }
    
    public static void commit(String titre, String texte)
    {
        gestDoc = new GestionDocument(titre, texte);
        gestDoc.commit();
    }
    
    public static void temp(String titre, String texte)
    {
        gestDoc = new GestionDocument(titre, texte);
        gestDoc.temp();
    }
    
    /*public static void supprimmer(String titre)
    {
        
    }*/
}
