/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Yashiro
 */
public class Reclamation  {
    private int id;
    private String etat;
    private String sujet;
    private int degre_urgence;
    private String date_rec;
    private int id_cit;
    private int id_resp;
    private String text;
    private String type;
    private int id_etab;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getId_resp() {
        return id_resp;
    }

    public void setId_resp(int id_resp) {
        this.id_resp = id_resp;
    }

    public int getDegre_urgence() {
        return degre_urgence;
    }

    public void setDegre_urgence(int degre_urgence) {
        this.degre_urgence = degre_urgence;
    }

    public String getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(String date_rec) {
        this.date_rec = date_rec;
    }

    public int getId_cit() {
        return id_cit;
    }

    public void setId_cit(int id_cit) {
        this.id_cit = id_cit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_etab() {
        return id_etab;
    }

    public void setId_etab(int id_etab) {
        this.id_etab = id_etab;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public Reclamation() {
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
