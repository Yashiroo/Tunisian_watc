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
    private String etablissement;
    private int phone;
    private int status;

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
    
        public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
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

    public String getAdress_mail() {
        return adresse_email;
    }

    public void setAdress_mail(String adress_mail) {
        this.adresse_email = adress_mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Responsable : " +nom+" "+prenom+ "\nEtablissment=" + etablissement;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.cin;
        return hash;
    }



    
    
}
