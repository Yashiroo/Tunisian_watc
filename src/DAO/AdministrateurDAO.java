/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entities.Administrateur;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdministrateurDAO  {
   
    public Administrateur FindAdminByLogin (String login) {
         String requete ="select login,password from admin where login=?";
         Administrateur admin = new Administrateur();
      try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                admin.setLogin(resultat.getString("login"));
               admin.setPassword(resultat.getString("password"));
            }
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche d'administrateur "+ex.getMessage());
            return null;
        }
    
    }




}
