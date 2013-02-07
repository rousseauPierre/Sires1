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
    private boolean prive;
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
    
    public boolean getPrive(){
        return this.prive;    
    }
    public void setPrive(boolean prive){
         this.prive = prive; 
    }    
     public List<Version> getListVersion(){
         return this.listVersion;    
    }
    public void setListVersion(List<Version> listVersion){
         this.listVersion = listVersion; 
    }
     public void addVersion(Version version){
           this.listVersion.add(version);
           version.setDocument(this);
     }
     public void removeVersion(Version version){
         this.listVersion.remove(version);
     }
     public void removeAllVersion() {
      if (this.listVersion != null)
         this.listVersion.clear();
   }
    
}
