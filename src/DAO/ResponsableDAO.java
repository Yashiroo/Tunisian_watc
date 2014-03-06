/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Responsable;
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
public class ResponsableDAO {
     
          public List<Responsable> selectAllResponsables(){
                List<Responsable> listeresp = new ArrayList<Responsable>();
                
                String requete = "select id_responsable,last_name,first_name,cin,adress_mail,login,phone,etat_compte from responsable";
                //String query = "select * from responsable";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            //Responsable r = new Responsable();
            
            
            while(resultat.next()){
                Responsable resp =new Responsable();
                resp.setId(resultat.getInt(1));
                resp.setNom(resultat.getString(2));
                resp.setPrenom(resultat.getString(3));
                resp.setCin(resultat.getInt(4));
                //resp.setEtablissement(resultat.getString(4));
                resp.setAdresse_email(resultat.getString(5));
                resp.setLogin(resultat.getString(6));
                resp.setPhone(resultat.getInt(7));
                resp.setStatus(resultat.getInt(8));

                listeresp.add(resp);
            }
            
            //System.out.println("Responsables Affichés");
            return listeresp;
            
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la selection des responsables : "+ex.getMessage());
            return null;
        }
    }
          
          
          
          
          
    public Responsable findResponsabletByCin(int cin){
   Responsable res = new Responsable ();
     String requete = "select cin from Responsable where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               res.setCin(resultat.getInt(1));
            }
            return res;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    
    
public void deleteResponsable(int cin)
{
        String requete = "delete from Responsable where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ps.executeUpdate();
            System.out.println("Compte Responsable supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    
      public void updateActiverResponsable(int cin)
    {

        String requete = "update Responsable set etat_compte=? where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1,0);
            ps.executeUpdate();
            System.out.println("le compte est activé");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
      
      
public void activerResponsable(Responsable r) {
        String requete = "update  responsable set etat_compte=1 where cin=?";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, r.getCin());
            System.out.println(r.getCin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitoyenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactiverResponsable(Responsable r) {
        String requete = "update  responsable set etat_compte=0 where cin=?";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, r.getCin());
            System.out.println(r.getCin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitoyenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
