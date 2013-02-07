/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.dao;

import com.projet.bean.Document;
import com.projet.bean.Utilisateur;
import com.projet.bean.Version;
import com.projet.dao.implement.DocumentDAO;
import com.projet.dao.implement.UtilisateurDAO;
import com.projet.dao.implement.VersionDAO;

/**
 *
 * @author biha
 */
public class DAOFactory {
    
    public static DAO<Utilisateur> getUtilisateurDAO(){
		return new UtilisateurDAO();
	}
    
    public static DAO<Document> getDocumentDAO(){
		return new DocumentDAO();
	}
    
    public static DAO<Version> getVersionDAO(){
		return new VersionDAO();
	}
    
}
