/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.projet.bean.Document;
import com.projet.bean.Utilisateur;
import com.projet.dao.DAO;
import com.projet.dao.implement.DocumentDAO;
import com.projet.dao.implement.UtilisateurDAO;

/**
 *
 * @author pierre
 */
public class Test {

    public static void main(String args[]) {

        DAO<Utilisateur> daod = new UtilisateurDAO();

       Utilisateur utilisateur = new Utilisateur();
       utilisateur.setLogin("rousseau.pierre76@gmail.com");
       utilisateur.setPassword("toto76");
       utilisateur.setCode_activation("153");      
       utilisateur.setTelephone("023544444");       
       utilisateur.setNom("rousseau");
       utilisateur.setPrenom("pierre");
       
        daod.create(utilisateur);
    }
}
