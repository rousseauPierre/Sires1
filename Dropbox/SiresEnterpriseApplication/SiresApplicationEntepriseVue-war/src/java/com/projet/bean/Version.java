/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.bean;

import java.util.Date;

/**
 *
 * @author biha
 */
public class Version {
    private int id_Version;
    private Date date;
    private String url;
    private Document document;
    
    public Version(){};
    public int getId_Version(){
      return this.id_Version;
    }
    public void setId_Version(int id_Version){
      this.id_Version = id_Version;
    
    }
    public Date getDate(){
      return this.date;
    }
    public void setDate(Date date){
      this.date = date;
    
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
    
}
