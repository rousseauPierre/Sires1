/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author biha
 */
public class Version {
    private int id_Version;
    private Boolean editable;  
    private String url;
    private Document document;
    private List<Editer> listEditer = new ArrayList<Editer>();
    
    public Version(){};
    public int getId_Version(){
      return this.id_Version;
    }
    public void setId_Version(int id_Version){
      this.id_Version = id_Version;
    
    }
    
     public Boolean getEditable(){
      return this.editable;
    }
    public void setEditable(Boolean editable){
      this.editable = editable;
    
    }
    public String getUrl(){
      return this.url;
    }
    public void setUrl(String url){
      this.url = url;
    
    }
    public Document getDocument(){
      return this.document;
    }
    public void setDocument(Document document){
      this.document = document;
    
    }
   
     // listEditer
    public List<Editer> getListEditer(){
         return this.listEditer;    
    }
    public void setListEditer(List<Editer> listEditer){
         this.listEditer = listEditer; 
    }
     public void addEditer(Editer editer){
           this.listEditer.add(editer);
           editer.setVersion(this);
     }
     public void removeEditer(Editer editer){
         this.listEditer.remove(editer);
     }
     public void removeAllEditer() {
      if (this.listEditer != null)
         this.listEditer.clear();
   }
   
}
