/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.dao.implement;

import com.projet.bean.Utilisateur;
import com.projet.bean.Version;
import com.projet.bean.Editer;
import com.projet.dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author biha
 */
public class EditerDAO extends DAO<Editer> {

    @Override
    public Editer find(int id) {
        return null;
    }

    @Override
    public void create(Editer obj) {
       Connection cx = null;
         PreparedStatement st = null;
         
          try {
              
           cx = this.connect;
           st = cx.prepareStatement("insert into EDITER (date, id_Version, id_Utilisateur) values (?, ?, ?)");
           st.setDate(1, obj.getDate());
           st.setInt(2, obj.getVersion().getId_Version());
           st.setInt(3, obj.getUtilisateur().getId_Utilisateur());

           st.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void update(Editer obj) {
         Connection cx = null;
         PreparedStatement st = null;
         
          try {
              
           cx = this.connect;
           st = cx.prepareStatement("update EDITER set date = ? where id_utilisateur = ? and id_version = ?");
           
           st.setDate(1, obj.getDate());
           
           st.setInt(2, obj.getUtilisateur().getId_Utilisateur());
           st.setInt(3, obj.getVersion().getId_Version());
           st.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void delete(Editer obj) {
         Connection cx = null;
         PreparedStatement st = null;
         
          try {
           cx = this.connect;
           st = cx.prepareStatement("delete from EDITER where id_utilisateur = ? and id_version = ?");
           st.setInt(1, obj.getUtilisateur().getId_Utilisateur());
           st.setInt(2, obj.getVersion().getId_Version());
           st.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
