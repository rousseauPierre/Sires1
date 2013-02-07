/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author biha
 */
public class Document {
    private int id_Document;
    private String titre;
    private List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
    private List<Version> listVersion = new ArrayList<Version>();
    
    public Document(){};
    
    public int getId_Document(){
        return this.id_Document;    
    }
    public void setId_Document(int id_Document){
         this.id_Document =id_Document; 
    }
    
    public String getTitre(){
        return this.titre;    
    }
    public void setTitre(String titre){
         this.titre =titre; 
    }
    
     public List<Utilisateur> getListUtilisateur(){
         return this.listUtilisateur;    
    }
    public void setListUtilisateur(List<Utilisateur> listUtilisateur){
         this.listUtilisateur = listUtilisateur; 
    } 
     public void addUtilisateur(Utilisateur utilisateur){
           this.listUtilisateur.add(utilisateur);
           utilisateur.addDocument(this);
     }
     public void  removeUtilisateur(Utilisateur utilisateur){
         this.listUtilisateur.remove(utilisateur);
     }
     
     public List<Version> getVersion(){
         return this.listVersion;    
    }
    public void setVersion(List<Version> listVersion){
         this.listVersion = listVersion; 
    }
     public void addVersion(Version version){
           this.listVersion.add(version);
          version.setDocument(this);
     }
     public void removeVersion(Version version){
         this.listVersion.remove(version);
     }
    
}
