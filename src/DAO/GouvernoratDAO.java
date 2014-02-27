/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
import Entities.Gouvernorat;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yashiro
 */
public class GouvernoratDAO {
    
    public List<Gouvernorat> getAllGouv(){
        
        List<Gouvernorat> lg = new ArrayList<Gouvernorat>();
        String query = "select * from gouvernorat";
        
        
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ResultSet resultat = ps.executeQuery();
            
            while(resultat.next())
            {
                Gouvernorat g = new Gouvernorat();
                g.setIdgouv(resultat.getInt(1));
                g.setNomgouv(resultat.getString(2));
                
                lg.add(g);
            }
            return lg;
            
        } catch (SQLException ex) {
            Logger.getLogger(GouvernoratDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        }
    
    
    
    
    






}
