/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Gouvernorat;
import Entities.Ville;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yashiro
 */
public class VilleDAO {
    
    public boolean checkVilleGouv(Gouvernorat g, Ville v)
    {
        String query="select * from ville where idville = ? and idgouv = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1,v.getIdville());
            ps.setInt(2, g.getIdgouv());            
            ResultSet resultat = ps.executeQuery();
            
            if(resultat.next())
                return true;
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VilleDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
        
        return false;
    }
}
