/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
import Entities.Gouvernorat;
import Entities.Reclamation;
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
public class ReclamationDAO {

              public Reclamation getRecByID(int id){
                  Reclamation t = new Reclamation();
                  
                String query = "select * from reclamation where id_reclamation=?";
                //String query = "select * from responsable";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet resultat = ps.executeQuery();
            
            while(resultat.next()){
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
                
            }
            
            return t;
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la selection des responsables : "+ex.getMessage());
            return null;
        }
    }
              
              public List<Reclamation> getAllRec(){
                  
                  List<Reclamation> liste = new ArrayList<Reclamation>();
                  String query = "select * from discussion";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ResultSet resultat = ps.executeQuery();
            
           while(resultat.next()){
                Reclamation t = new Reclamation();
                t.setId(resultat.getInt(1));
                t.setEtat(resultat.getString(2));
                t.setSujet(resultat.getString(3));
                t.setId_resp(resultat.getInt(4));
                liste.add(t);
            }

            return liste;
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  
              }
             
              
public void insertRec(Reclamation r){
            String query = "insert into reclamation(id_reclamation,etat,degre_urgence,sujet,date_reclamation,id_citoyen,responsable_id_responsable,text,type_reclamation,etablissement_id_etablissement) values (?,?,?,?,?,?,?,?,?,?)";

            try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, r.getId());
            ps.setString(2, r.getEtat());
            ps.setInt(3, r.getDegre_urgence());
            ps.setString(4, r.getSujet());
//            ps.setDate(5, r.getDate_rec());
            ps.setInt(6, r.getId_cit());
            ps.setInt(7, r.getId_resp());
            ps.setString(9, r.getText());
            ps.setString(9, r.getType());
            ps.setInt(9, r.getId_etab());
            ps.executeUpdate();

            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
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
      
      public List<Reclamation> getRecsForEtablissement(Etablissement e){
                  
                  List<Reclamation> liste = new ArrayList<Reclamation>();
                  String query = "SELECT * FROM reclamation WHERE etablissement_id_etablissement = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, e.getResp_id());
            
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
      public int recTraitees(Etablissement e){
                
                List<Reclamation> et = new ArrayList<Reclamation>();
                et=getRecsForEtablissement(e);
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
      
      public int recNonTraitees(Etablissement e){
                
                List<Reclamation> et = new ArrayList<Reclamation>();
                et=getRecsForEtablissement(e);
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
      
      public int totalRec(Etablissement e){
                
                List<Reclamation> et = new ArrayList<Reclamation>();
                et=getRecsForEtablissement(e);
                int res=0;
                res=et.size();

          return res;
      }
      
      
      
public int getRecsForGouvEtab(Gouvernorat g,Etablissement e){
        
        String query = "SELECT count( * ) "
                +"FROM reclamation r, etablissement e "
                +" WHERE r.etablissement_id_etablissement = e.id_etablissement "
                +"AND r.etablissement_id_etablissement =? "
                +"AND e.gouvernerat =?";
        
        int res=0;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, e.getId());
            ps.setInt(2,g.getIdgouv());
            ResultSet resultat = ps.executeQuery();
            
            if(resultat.next()) {
                res=resultat.getInt(1);
            }
            
            
            return res;
            
        } catch (SQLException ex) {
            Logger.getLogger(GouvernoratDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
  
}
        
        public List<Reclamation> getRecsInfoForGouvEtab(Gouvernorat g,Etablissement e){
                    List<Reclamation> lt = new ArrayList<Reclamation>();
        String query = "SELECT id_reclamation ,etat,degre_urgence, sujet, date_reclamation, id_citoyen, r.responsable_id_responsable,text, type_reclamation, etablissement_id_etablissement "
                            +"FROM reclamation r, etablissement e "
                            +"WHERE r.etablissement_id_etablissement = e.id_etablissement "
                            +"AND r.etablissement_id_etablissement = ? "
                            +"AND e.gouvernerat = ? ";
        
                String re ="select * from reclamation where id_reclamation between 5 and 10";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(query);
            ps.setInt(1, e.getId());
            ps.setInt(2,g.getIdgouv());
            ResultSet resultat = ps.executeQuery();
            
            while(resultat.next())
            {
                Reclamation r = new Reclamation();
                r.setId(resultat.getInt(1));
                r.setEtat(resultat.getString(2));
                r.setDegre_urgence(resultat.getInt(3));
                r.setSujet(resultat.getString(4));
                r.setDate_rec(resultat.getString(5));
                r.setId_cit(resultat.getInt(6));
                r.setId_resp(resultat.getInt(7));
                r.setText(resultat.getString(8));
                r.setType(resultat.getString(9));
                r.setId_etab(resultat.getInt(10));
                lt.add(r);
                System.out.println("empty :/");
            }
            

            return lt;
            
        } catch (SQLException ex) {
            Logger.getLogger(GouvernoratDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
