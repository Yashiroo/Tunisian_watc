/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
import Entities.Responsable;
import Entities.Thread;
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
                e.setVille(resultat.getString(4));
                e.setGouvernorat(resultat.getString(5));
                e.setResp_id(resultat.getInt(6));
                liste.add(e);
            }
            
            return liste;
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadsDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            e.setVille(resultat.getString(4));
            e.setGouvernorat(resultat.getString(5));
            e.setResp_id(resultat.getInt(6));
            
        }
        return e;
        }
        catch(SQLException ex){
            System.out.println("erreur lors du chargement"+ex.getMessage());
            return null;
        }
    }
 
  
  
  
      public List<Entities.Thread> getThreadsForEtablissement(Etablissement e){
                  
                  List<Entities.Thread> liste = new ArrayList<Entities.Thread>();
                  String query = "select * from discussion where id_responsable=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, e.getResp_id());
            ResultSet resultat = ps.executeQuery();
            
           while(resultat.next()){
                Entities.Thread t = new Entities.Thread();
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
      
      
      public int recTraitees(Etablissement e){
                
                List<Entities.Thread> et = new ArrayList<Entities.Thread>();
                et=getThreadsForEtablissement(e);
                int res=0;
                for(Entities.Thread t:et){
                        if(t.getEtat().equalsIgnoreCase("resolue"))
                            res+=1;   
                }

          return res;
      }
        
      public int recNonTraitees(Etablissement e){
                
                List<Entities.Thread> et = new ArrayList<Entities.Thread>();
                et=getThreadsForEtablissement(e);
                int res=0;
                for(Entities.Thread t:et){
                        if(t.getEtat().equalsIgnoreCase("non resolue"))
                            res+=1;   
                }

          return res;
      }
      
      
      public int totalRec(Etablissement e){
                
                List<Entities.Thread> et = new ArrayList<Entities.Thread>();
                et=getThreadsForEtablissement(e);
                int res=0;
                res=et.size();

          return res;
      }
      
  public Etablissement getEtab(Responsable r){
            Etablissement e = new Etablissement();
            String query = "select * from etablissement where responsable_id_responsable=?";
            
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1,r.getCin());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next())
            {
                e.setId(resultat.getInt(1));
                e.setName(resultat.getString(2));
                e.setName(resultat.getString(2));
                e.setName(resultat.getString(2));
                e.setName(resultat.getString(2));
                    
                    
            }
            return e;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EtablissementDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
      
      
      
      
      
      
      
  }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
