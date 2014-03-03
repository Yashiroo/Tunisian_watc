/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Citoyen;
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
public class CitoyenDAO {
                public List<Citoyen> getAllCitoyens(){
                List<Citoyen> listecit = new ArrayList<Citoyen>();
                
                String requete = "select last_name,first_name,cin,date_of_birth,adresse,adresse_mail,login,phone,etat_compte from citoyen";
                //String query = "select * from responsable";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            //Responsable r = new Responsable();
            
            
            while(resultat.next()){
                Citoyen cit =new Citoyen();
                cit.setNom(resultat.getString(1));
                cit.setPrenom(resultat.getString(2));
                cit.setCin(resultat.getInt(3));
                cit.setAdresse(resultat.getString(5));
                cit.setAdress_mail(resultat.getString(6));
                cit.setLogin(resultat.getString(7));
                cit.setPhone(resultat.getInt(8));
                cit.setStatus(resultat.getInt(9));
                
                
                listecit.add(cit);
            }
            
            //System.out.println("Responsables Affichés");
            return listecit;
            
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la selection des responsables : "+ex.getMessage());
            return null;
        }
            }
                
                
                
          public void insertComptCitoyen(Citoyen c){

        String requeteUser = "insert into Utilisateur (cin,nom,prenom,date_naissance,adresse,login,adresse_mail,password) values (?,?,?,?,?,?,?,?,?)";
         String requeteRES = "insert into Citoyen (cin) values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUser);
            ps.setInt(1, c.getCin());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            
            ps.setDate(4, c.getDate_naissance());
            ps.setString(5, c.getAdresse());
            ps.setString(6, c.getAdress_mail());
            ps.setString(6, c.getLogin());
           
            
            ps.executeUpdate();
            PreparedStatement psres = MyConnection.getInstance().prepareStatement(requeteRES);
            psres.setInt(1, c.getCin());
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
/*************************************************hejer*******/
public List<Citoyen> DisplayAllCitoyen() {

       List<Citoyen> listeCitoyen = new ArrayList<Citoyen>();

        String requete = "select last_name,first_name,cin,adresse_mail,phone from citoyen";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Citoyen cet = new Citoyen();
                cet.setNom(resultat.getString(1));
                cet.setPrenom(resultat.getString(2));
                cet.setCin(resultat.getInt(3));
             cet.setAdress_mail(resultat.getString(4));
             cet.setPhone(resultat.getInt(5));
              


                listeCitoyen.add(cet);
            }
            return listeCitoyen;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des compte des citoyen " + ex.getMessage());
            return null;
        }
    }
          
     public void deleteCitoyen(int cin){
        String requete = "delete from Citoyen where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ps.executeUpdate();
            System.out.println("Compte responsable supprimée");
        } catch (SQLException ex) {
        
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }  
          
          
    public void activerCitoyen(Citoyen c) {
        String requete = "update citoyen set etat_compte=1 where cin=?";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, c.getCin());
            System.out.println(c.getCin());
            ps.executeUpdate();




        } catch (SQLException ex) {
            Logger.getLogger(CitoyenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactiverCitoyen(Citoyen c) {
        String requete = "update  citoyen set etat_compte=0 where cin=?";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, c.getCin());
            System.out.println(c.getCin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitoyenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }




    }     
          
    public Citoyen findCitoyentByCin(int cin) {
        Citoyen cit = new Citoyen();
       String requete = "select last_name,first_name,cin,adresse,adresse_mail,login,phone,etat_compte from citoyen where cin=?";
         // String requete = "select last_name,first_name,cin from citoyen where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

               
                cit.setNom(resultat.getString(1));
                cit.setPrenom(resultat.getString(2));
             
                cit.setCin(resultat.getInt(3));
                cit.setAdresse(resultat.getString(4));
                cit.setAdress_mail(resultat.getString(5));
                cit.setLogin(resultat.getString(6));
                cit.setPhone(resultat.getInt(7));
                cit.setStatus(resultat.getInt(8));
 
            }
            return cit;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
          
          
          
          
          
          
}
