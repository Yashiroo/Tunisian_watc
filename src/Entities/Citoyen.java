/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class Citoyen{
    private String nom;
    private String prenom ;
    private int cin;
    private Date Date_naissance;
    private String adresse;
    private int phone;
    private int status;
    
    public Citoyen() {
    }

        public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }
    private String login;
    private String adress_mail;


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.cin;
        return hash;
    }

    @Override
    public String toString() {
        return  "nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", Date_naissance=" + Date_naissance + ", adresse=" + adresse + ", login=" + login + ", adress_mail=" + adress_mail +'}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Citoyen other = (Citoyen) obj;
        if (this.cin != other.cin) {
            return false;
        }
        return true;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return Date_naissance;
    }

    public void setDate_naissance(Date Date_naissance) {
        this.Date_naissance = Date_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAdress_mail() {
        return adress_mail;
    }

    public void setAdress_mail(String adress_mail) {
        this.adress_mail = adress_mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    
    
    
}
