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
    
    
    
    
    
public int getRecsForGouvEtab(Gouvernorat g,Etablissement e){
        
        String query = "select count(*) from responsable r inner join reclamation rec on r.id_responsable = rec.responsable_id_responsable inner join etablissement e on rec.etablissement_id_etablissement=e.id_etablissement where e.gouvernerat=? AND e.id_etablissement=?";
        
        int res=0;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, g.getIdgouv());
            ps.setInt(2,e.getId());
            ResultSet resultat = ps.executeQuery();
            
            if(resultat.next())
                 res=resultat.getInt(1);
            
            
            return res;
            
        } catch (SQLException ex) {
            Logger.getLogger(GouvernoratDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
  
}
        
        
    
public int getAllGouvRecResolues(Gouvernorat g){
        
        String query = "select count(*) from responsable r inner join reclamation rec on r.id_responsable = rec.responsable_id_responsable inner join etablissement e on r.etablissement=e.id_etablissement where e.gouvernorat=?";
        int res=0;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, g.getIdgouv());
            ResultSet resultat = ps.executeQuery();
            
            if(resultat.next())
                 res=resultat.getInt(1);
            
            
            return res;
            
        } catch (SQLException ex) {
            Logger.getLogger(GouvernoratDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
  
}
    



public int getAllGouvRecNonResolues(Gouvernorat g){
        
        String query = "select count(id_reclamation) from responsable r,etablissement e, reclamation rec where rec.responsable_id_responsable=r.id_responsable AND r.etablissement=e.id_etablissement AND e.gouvernorat=?";
        int res=0;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, g.getIdgouv());
            ResultSet resultat = ps.executeQuery();
            
            if(resultat.next())
                 res=resultat.getInt(1);
            
            
            return res;
            
        } catch (SQLException ex) {
            Logger.getLogger(GouvernoratDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
  
}






}
