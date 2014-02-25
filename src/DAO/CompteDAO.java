/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Citoyen;
import Entities.Responsable;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CompteDAO {
    public void insertCompteResponsable(Responsable res){

        String requeteUser = "insert into Utilisateur (cin,nom,prenom,date_naissance,adresse,login,adresse_mail,password) values (?,?,?,?,?,?,?,?,?)";
         String requeteRES = "insert into Responsable (cin,Id_etablissement) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUser);
            ps.setInt(1, res.getCin());
            ps.setString(2, res.getNom());
            ps.setString(3, res.getPrenom());
            
            ps.setDate(4, res.getDate_naissance());
            ps.setString(5, res.getAdresse());
            ps.setString(6, res.getAdress_mail());
            ps.setString(6, res.getLogin());
            
            
            ps.executeUpdate();
            PreparedStatement psres = MyConnection.getInstance().prepareStatement(requeteRES);
            psres.setInt(1, res.getCin());
            psres.setString(2,res.getEtablissement());
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
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
     
     
          public List<Responsable> selectAllResponsables(){
                List<Responsable> listeresp = new ArrayList<Responsable>();
                
                String requete = "select last_name,first_name,cin,etablissement,adresse_email,login,phone,status from responsable";
                //String query = "select * from responsable";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            //Responsable r = new Responsable();
            
            
            while(resultat.next()){
                Responsable resp =new Responsable();
                resp.setNom(resultat.getString(1));
                resp.setPrenom(resultat.getString(2));
                resp.setCin(resultat.getInt(3));
                resp.setEtablissement(resultat.getString(4));
                resp.setAdress_mail(resultat.getString(5));
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
                //cit.setDate_naissance(resultat.getString(4));
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
    
    
}
