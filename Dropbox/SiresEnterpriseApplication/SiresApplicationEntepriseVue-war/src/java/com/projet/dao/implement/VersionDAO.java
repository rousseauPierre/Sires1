    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.dao.implement;

import com.projet.bean.Document;
import com.projet.bean.Editer;
import com.projet.bean.Utilisateur;
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
public class VersionDAO extends DAO<Version> {

    @Override
    public Version find(int id) {
         Connection cx = null;
         PreparedStatement st = null;
         ResultSet rs = null;
         Version version = new Version();
         
          try {
           cx = this.connect;
           st = cx.prepareStatement("select editable, url, id_document, date, id_utilisateur from VERSION v, editer e where v.id_version = e.id_version and v.id_version = ?");
           st.setInt(1, id);
           rs = st.executeQuery();
          
          if (rs.next()) {
               Boolean  editable = rs.getBoolean(1);
               String   url = rs.getString(2);
               int id_Document = rs.getInt(3);
               java.sql.Date date = rs.getDate(4);
               int id_utilisateur = rs.getInt(5);
                
               version.setId_Version(id);
               version.setEditable(editable);
               version.setUrl(url);
               ////////////////////////
               Document document = new Document();
               document.setId_Document(id_Document);
               ////////////////////////
               Editer editer = new Editer();
               editer.setDate(date);
               Utilisateur utilisateur = new Utilisateur();
               utilisateur.setId_Utilisateur(id_utilisateur);
               editer.setUtilisateur(utilisateur);
               ////////////////////////////////
               version.addEditer(editer);
               version.setDocument(document);
               
           }
         
        }catch(SQLException e){
            e.printStackTrace();
        }

         return version;
    }

    @Override
    public void create(Version obj) {
         Connection cx = null;
         PreparedStatement st = null;
         
          try {
              
           cx = this.connect;
           st = cx.prepareStatement("insert into VERSION (id_Version, editable, url, id_Document) values (default, ?, ?, ?)");
           st.setBoolean(2, obj.getEditable());
           st.setString(3, obj.getUrl());
           st.setInt(4, obj.getDocument().getId_Document());

           st.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
          
    }

    @Override
    public void update(Version obj) {
       Connection cx = null;
       PreparedStatement st = null;
         
          try {
              
           cx = this.connect;
           st = cx.prepareStatement("update VERSION set editable = ?, url = ?, id_Document = ? where id_version = ?");
           
           st.setBoolean(1, obj.getEditable());
           st.setString(2, obj.getUrl());
           st.setInt(3, obj.getDocument().getId_Document());
           st.setInt(4, obj.getId_Version());

           st.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void delete(Version obj) {
        Connection cx = null;
        PreparedStatement st = null;
         
          try {
              
           cx = this.connect;
           st = cx.prepareStatement("delete from VERSION where id_version = ?");
           st.setInt(1, obj.getId_Version());

           st.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

   
    
}
