/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author FC
 */
public class Administrateur {
    String login;
public Administrateur()
{
    
}
        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    String password;

    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }
 
   
     public Administrateur(String login, String mot_de_passe) {
        this.login = login;
        this.password = mot_de_passe;
    }

      public String toString() {
        return "Administrateur{" + "login=" + login + "mot_de_passe=" + password + '}';
    }

}
