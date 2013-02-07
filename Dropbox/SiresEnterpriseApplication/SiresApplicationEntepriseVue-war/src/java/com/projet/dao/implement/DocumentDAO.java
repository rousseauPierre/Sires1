/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.dao.implement;

import com.projet.bean.Document;
import com.projet.bean.Version;
import com.projet.dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author biha
 */
public class DocumentDAO extends DAO<Document> {

   ///////////////////////////FIND/////////////////////////
    public Document find(int id) {
         Connection cx = null;
         PreparedStatement st = null;
         ResultSet rs = null;
         Document document = new Document();
        
        try {
           cx = this.connect; 
st = cx.prepareStatement("select titre, prive, id_version, url, editable from document d, version v where d.id_document = v.id_document and d.id_document = ?");
           st.setInt(1, id);
           rs = st.executeQuery();
         
          while(rs.next()) {
               String titre = rs.getString(1);   
               Boolean  prive = rs.getBoolean(2);
               int id_version = rs.getInt(3);
               String url  = rs.getString(4);
               Boolean editable = rs.getBoolean(5);
               
               
               document.setId_Document(id);
               document.setTitre(titre);
               document.setPrive(prive);
               
               Version version = new Version();
               version.setId_Version(id_version);
               version.setUrl(url);
               version.setEditable(editable);
               
               document.addVersion(version);
           }
         
        }catch(SQLException e){
            e.printStackTrace();
        }

        return document;
    }
////////////////////////////////////////////////////////////
    
    public void create(Document obj) {
       Connection cx = null;
       PreparedStatement st = null;
    
       
        try {
           cx = this.connect;
           st = cx.prepareStatement("insert into document (id_document, titre, prive) values (?, ?, ?)");
           st.setInt(1, obj.getId_Document());
           st.setString(2, obj.getTitre());
           st.setBoolean(3, obj.getPrive());
           st.executeUpdate();
         
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    
    public void update(Document obj) {
         Connection cx = null;
         PreparedStatement st = null;
        // ResultSet rs = null;
         
          try {
           cx = this.connect;
           st = cx.prepareStatement("update document set titre = ?, prive = ? where id_document = ?");
           st.setString(1, obj.getTitre());
           st.setBoolean(2, obj.getPrive());
           st.setInt(3, obj.getId_Document());
           st.executeUpdate();
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Document obj) {
        Connection cx = null;
        PreparedStatement st = null;
      //  ResultSet rs = null;
        
         try {
           cx = this.connect;
           st = cx.prepareStatement("delete from document where id_document = ?");
           st.setInt(1, obj.getId_Document());
           st.executeUpdate();
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
