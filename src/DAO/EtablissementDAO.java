/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
import Entities.Reclamation;
import Entities.Responsable;
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
                e.setGouvernorat(resultat.getInt(5));
                e.setResp_id(resultat.getInt(6));
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
            
            e.setName(resultat.getString(2));
            e.setName(resultat.getString(2));
            e.setType(resultat.getString(3));
            e.setVille(resultat.getInt(4));
            e.setGouvernorat(resultat.getInt(5));
            e.setResp_id(resultat.getInt(6));
            
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
            e.setGouvernorat(resultat.getInt(5));
            e.setResp_id(resultat.getInt(6));
            
        }
        return e;
        }
        catch(SQLException ex){
            System.out.println("erreur lors du chargement"+ex.getMessage());
            return null;
        }
    }
  
  
      public List<Reclamation> getRecsForEtablissement(Etablissement e,int month,int year){
                  
                  List<Reclamation> liste = new ArrayList<Reclamation>();
                  String query = "SELECT * FROM reclamation WHERE etablissement_id_etablissement = ? AND month(date_reclamation) = ? AND year(date_reclamation)=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, e.getResp_id());
            ps.setInt(2,month);
            ps.setInt(3,year);
            
            ResultSet resultat = ps.executeQuery();
            
           while(resultat.next()){
                Reclamation t = new Reclamation();
                t.setId(resultat.getInt(1));
                t.setEtat(resultat.getString(2));
                t.setDegre_urgence(resultat.getInt(3));
                t.setSujet(resultat.getString(4));
                t.setDate_rec(resultat.getString(5));
                t.setId_cit(resultat.getInt(6));
                t.setId_resp(resultat.getInt(7));
                t.setText(resultat.getString(8));
                t.setType(resultat.getString(9));
                t.setId_etab(resultat.getInt(10));
                liste.add(t);
                
            }

            return liste;
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  
              }
      
      
      public int recTraitees(Etablissement e,int month,int year){
                
                List<Reclamation> et = new ArrayList<Reclamation>();
                et=getRecsForEtablissement(e,month,year);
                int res=0;
                for(Reclamation t:et){
                        if(t.getEtat().equalsIgnoreCase("resolue"))
                            res+=1;   
                }

          return res;
      }
        
      public int recNonTraitees(Etablissement e,int month,int year){
                
                List<Reclamation> et = new ArrayList<Reclamation>();
                et=getRecsForEtablissement(e,month,year);
                int res=0;
                for(Reclamation t:et){
                        if(t.getEtat().equalsIgnoreCase("non resolue"))
                            res+=1;   
                }

          return res;
      }
      
      
      public int totalRec(Etablissement e,int month,int year){
                
                List<Reclamation> et = new ArrayList<Reclamation>();
                et=getRecsForEtablissement(e,month,year);
                int res=0;
                res=et.size();

          return res;
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
                e.setGouvernorat(resultat.getInt(5));
                e.setResp_id(resultat.getInt(6)); 
                    
            }
            return e;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EtablissementDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
      
      
      
      
      
      
      
  }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
