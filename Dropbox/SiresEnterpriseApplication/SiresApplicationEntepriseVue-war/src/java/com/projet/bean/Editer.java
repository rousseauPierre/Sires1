/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.bean;

import java.sql.Date;

/**
 *
 * @author biha
 */
public class Editer {
    
    private java.sql.Date date;
    private Utilisateur utilisateur;
    private Version version;
      
    public java.sql.Date getDate(){
      return this.date;
    }
    public void setDate(java.sql.Date date){
      this.date = date;
    }
    public Utilisateur getUtilisateur(){
      return this.utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur){
      this.utilisateur = utilisateur;
    
    }
     public Version getVersion(){
      return this.version;
    }
    public void setVersion(Version version){
      this.version = version;
    
    }
    
}
