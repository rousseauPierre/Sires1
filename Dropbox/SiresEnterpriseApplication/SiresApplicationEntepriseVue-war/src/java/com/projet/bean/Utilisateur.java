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
    private String telephone;
    private List<Editer> listEditer = new ArrayList<Editer>();
    
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
    
    public String getLogin(){
      return this.login;
    }
    public void setLogin(String login){
       this.login = login;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public List<Editer> getlistEditer(){
       return this.listEditer;
    }
    public void setlistEditer(List<Editer> listEditer){
       this.listEditer = listEditer; 
       
    }
    public void addEditer(Editer editer){
      this.listEditer.add(editer);
      editer.setUtilisateur(this);
    }
    public void removeEditer(Editer editer){
        this.listEditer.remove(editer);
        
    }
     public void removeAllEditer() {
      if (this.listEditer != null)
         this.listEditer.clear();
   }
    
}
