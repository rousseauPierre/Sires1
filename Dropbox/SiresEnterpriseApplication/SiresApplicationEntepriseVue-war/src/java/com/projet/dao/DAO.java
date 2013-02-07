/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.dao;

import com.projet.jdbc.ConnectionMySQL;
import java.sql.Connection;


/**
 *
 * @author biha
 */
public abstract class DAO<T> {
    public Connection connect = ConnectionMySQL.getInstance();
   
        public abstract T find(int id);
        
	public abstract void create(T obj);

	public abstract void update(T obj);
	
	public abstract void delete(T obj);
}
