/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Responsable{
    private int id;
    private String nom;
    private String prenom ;
    private int cin;
    private Date Date_nais;
    private String adresse;
    private String login;
    private String adresse_email;
    private int phone;
    private int status;
    private int id_etablissement;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
    
    public Responsable() {
        
    }
        public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
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
        return Date_nais;
    }

    public void setDate_naissance(Date Date_naissance) {
        this.Date_nais = Date_naissance;
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

    public String getAdresse_email() {
        return adresse_email;
    }

    public void setAdresse_email(String adress_mail) {
        this.adresse_email = adress_mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(int id_etablissement) {
        this.id_etablissement = id_etablissement;
    }

    
    
    
    
    
    
    
    
    
    
    
        @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Responsable other = (Responsable) obj;
        if (this.cin != other.cin) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Responsable : " +nom+" "+prenom+ "\n" ;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.cin;
        return hash;
    }



    
    
}
