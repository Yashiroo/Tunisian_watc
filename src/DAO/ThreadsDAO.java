/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
import Entities.Thread;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yashiro
 */
public class ThreadsDAO {

              public Thread getThreadByID(int id){
                  Thread t = new Thread();
                
                String query = "select * from discussion where id_discussion=?";
                //String query = "select * from responsable";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet resultat = ps.executeQuery();
            
            while(resultat.next()){
                t.setId(resultat.getInt(1));
                t.setEtat(resultat.getString(2));
                t.setSujet(resultat.getString(3));
                t.setId_resp(resultat.getInt(4));
                
            }
            
            return t;
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la selection des responsables : "+ex.getMessage());
            return null;
        }
    }
              
              public List<Thread> getAllThreads(){
                  
                  List<Thread> liste = new ArrayList<Thread>();
                  String query = "select * from discussion";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ResultSet resultat = ps.executeQuery();
            
           while(resultat.next()){
                Thread t = new Thread();
                t.setId(resultat.getInt(1));
                t.setEtat(resultat.getString(2));
                t.setSujet(resultat.getString(3));
                t.setId_resp(resultat.getInt(4));
                liste.add(t);
            }

            return liste;
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  
              }
             
              

              

}
