/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Etablissement;
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
              

}
