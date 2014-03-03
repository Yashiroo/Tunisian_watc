/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
import Entities.Reclamation;
import Entities.Responsable;
import Entities.Ville;
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
public class EtablissementDAO {
                  
        public List<Etablissement> getAllEtab(){
    
                  List<Etablissement> liste = new ArrayList<Etablissement>();
                  String query = "select * from etablissement";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ResultSet resultat = ps.executeQuery();
            
           while(resultat.next()){
                Etablissement e = new Etablissement();
                e.setId(resultat.getInt(1));
                e.setName(resultat.getString(2));
                e.setType(resultat.getString(3));
                e.setVille(resultat.getInt(4));
                e.setResp_id(resultat.getInt(5));
                liste.add(e);
            }
            
            return liste;
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
                    
              }
        
  public Etablissement findEtablissementById(int num){
        Etablissement e = new Etablissement();
        String requete = "select * from etablissement where id_etablissement=?";

        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
        ps.setInt(1, num);
        ResultSet resultat = ps.executeQuery();
        
        while (resultat.next()){
            e.setId(resultat.getInt(1));
            e.setName(resultat.getString(2));
            e.setType(resultat.getString(3));
            e.setVille(resultat.getInt(4));
            e.setResp_id(resultat.getInt(5));
            
        }
        return e;
        }
        catch(SQLException ex){
            System.out.println("erreur lors du chargement"+ex.getMessage());
            return null;
        }
    }
 
    public Etablissement findEtablissementByName(String name){
        Etablissement e = new Etablissement();
        String requete = "select * from etablissement where name=?";

        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
        ps.setString(1, name);
        ResultSet resultat = ps.executeQuery();
        
        while (resultat.next()){
            
            e.setId(resultat.getInt(1));
            e.setName(resultat.getString(2));
            e.setType(resultat.getString(3));
            e.setVille(resultat.getInt(4));
            e.setResp_id(resultat.getInt(5));
            
        }
        return e;
        }
        catch(SQLException ex){
            System.out.println("erreur lors du chargement"+ex.getMessage());
            return null;
        }
    }
  
  

  public Etablissement getEtab(Responsable r){
            Etablissement e = new Etablissement();
            String query = "select * from etablissement where responsable_id_responsable=?";
            
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1,r.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next())
            {
                e.setId(resultat.getInt(1));
                e.setName(resultat.getString(2));
                e.setType(resultat.getString(3));
                e.setVille(resultat.getInt(4));
                e.setResp_id(resultat.getInt(5));     
            }
            return e;

        } catch (SQLException ex) {
            Logger.getLogger(EtablissementDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
      
  }
      
      
      public Ville getVilleForEtab(Etablissement e){
          Ville v = new Ville();
          String query = "select v.* from ville v , etablissement e where v.idville = e.ville and e.id_etablissement = ? ";
          
          
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, e.getId());
            ResultSet resultat = ps.executeQuery();
            
            while(resultat.next())
            {
                v.setIdville(resultat.getInt(1));
                v.setNomville(resultat.getString(2));
                v.setIdgouv(resultat.getInt(3));
//                System.out.println("im inside");
            }
                return v;
            
        } catch (SQLException ex) {
            Logger.getLogger(EtablissementDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
