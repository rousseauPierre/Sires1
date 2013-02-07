/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.dao.implement;


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
public class UtilisateurDAO extends DAO<Utilisateur>{

    public Utilisateur find(int id) {
         Connection cx = null;
         PreparedStatement st = null;
         ResultSet rs = null;
         Utilisateur utilisateur = new Utilisateur();
         
         try {
           cx = this.connect;
st = cx.prepareStatement("select login, code_activation, password, telephone, nom, prenom, date, id_version from utilisateur u, editer e where u.id_utilisateur = e.id_utilisateur and u.id_utilisateur = ?");
           st.setInt(1, id);
           rs = st.executeQuery();
          
          while (rs.next()) {
               String login = rs.getString(1);
               String code_activation = rs.getString(2);
               String password = rs.getString(3);
               String telephone = rs.getString(4);
               String nom = rs.getString(5);
               String prenom = rs.getString(6);
               java.sql.Date date = rs.getDate(7);
               int id_version = rs.getInt(8);
               
               
               utilisateur.setId_Utilisateur(id);
               utilisateur.setCode_activation(code_activation);
               utilisateur.setPassword(password);
               utilisateur.setTelephone(telephone);
               utilisateur.setNom(nom);
               utilisateur.setPrenom(prenom);
               
               Editer editer = new Editer();
               editer.setDate(date);
               Version version = new Version();
               version.setId_Version(id_version);
               editer.setVersion(version);
               utilisateur.addEditer(editer);
               
           }
         
        }catch(SQLException e){
            e.printStackTrace();
        }
         return utilisateur;
    }

    @Override
    public void create(Utilisateur obj) {
       
          Connection cx = null;
          PreparedStatement st = null;
         // ResultSet rs = null;
         
         try {
           cx = this.connect;
           st = cx.prepareStatement("insert into utilisateur (login, code_activation, password, telephone, nom, prenom, id_utilisateur) values (?, ?, ?, ?, ?, ?, ?)");
           st.setString(1, obj.getLogin());
           st.setString(2, obj.getCode_activation());
           st.setString(3, obj.getPassword());
           st.setString(4, obj.getTelephone());
           st.setString(5, obj.getNom());
           st.setString(6, obj.getPrenom());
           st.setInt(7, obj.getId_Utilisateur());
           st.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Utilisateur obj) {
          Connection cx = null;
          PreparedStatement st = null;
         /// ResultSet rs = null;
         
         try {
           cx = this.connect;
           st = cx.prepareStatement("update utilisateur set login = ?, code_activation = ?, password = ?, telephone = ?, nom = ?, prenom = ? where id_utilisateur = ?");
           st.setString(1, obj.getLogin());
           st.setString(2, obj.getCode_activation());
           st.setString(3, obj.getPassword());
           st.setString(4, obj.getTelephone());
           st.setString(5, obj.getNom());
           st.setString(6, obj.getPrenom());
           st.setInt(7, obj.getId_Utilisateur());
  
           st.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Utilisateur obj) {
       Connection cx = null;
       PreparedStatement st = null;
    //   ResultSet rs = null;
       
         try {
           cx = this.connect;
           st = cx.prepareStatement("delete from utilisateur where id_utilisateur = ?");
           st.setInt(1, obj.getId_Utilisateur());
           st.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
       
       
    }
    
}
