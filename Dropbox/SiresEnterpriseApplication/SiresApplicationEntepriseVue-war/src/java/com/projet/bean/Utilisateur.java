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
public class Utilisateur {
    
    private int id_Utilisateur;
    private String nom;
    private String prenom;
    private String password;
    private String code_activation;
    private String login;
    private List<Document> listDocument = new ArrayList<Document>();
    
    public Utilisateur(){}
    
    public int getId_Utilisateur(){
      return this.id_Utilisateur;
    }
    public void setId_Utilisateur(int id_Utilisateur){
       this.id_Utilisateur = id_Utilisateur;
    }
    
     public String getNom(){
      return this.nom;
    }
    public void setNom(String nom){
       this.nom = nom;
    }
    
     public String getPrenom(){
      return this.prenom;
    }
    public void setPrenom(String prenom){
       this.prenom = prenom;
    } 
    
     public String getPassword(){
      return this.password;
    }
    public void setPassword(String password){
       this.password = password;
    }
    
    public String getCode_activation(){
      return this.code_activation;
    }
    public void setCode_activation(String code_activation){
       this.code_activation = code_activation;
    }
    
    public List<Document> getListDocument(){
       return this.listDocument;
    }
    public void setListDocument(List<Document> listDocument){
       this.listDocument = listDocument; 
       
    }
    public void addDocument(Document document){
      this.listDocument.add(document);
      document.addUtilisateur(this);
    }
    public void removeDocument(Document document){
        this.listDocument.remove(document);
    }
    
}
