/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
class Message {
      
   
    private String text;
   
    private Date date;
    
    private Responsable responsableIdResponsable;
  
    private Citoyen citoyenIdCitoyen;
 
    private Discussion discussionIdDiscussion;
    
    private Collection<Fichier> fichierCollection;

    public Message() {
    }

   
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Responsable getResponsableIdResponsable() {
        return responsableIdResponsable;
    }

    public void setResponsableIdResponsable(Responsable responsableIdResponsable) {
        this.responsableIdResponsable = responsableIdResponsable;
    }

    public Citoyen getCitoyenIdCitoyen() {
        return citoyenIdCitoyen;
    }

    public void setCitoyenIdCitoyen(Citoyen citoyenIdCitoyen) {
        this.citoyenIdCitoyen = citoyenIdCitoyen;
    }

    public Discussion getDiscussionIdDiscussion() {
        return discussionIdDiscussion;
    }

    public void setDiscussionIdDiscussion(Discussion discussionIdDiscussion) {
        this.discussionIdDiscussion = discussionIdDiscussion;
    }

    @XmlTransient
    public Collection<Fichier> getFichierCollection() {
        return fichierCollection;
    }

    public void setFichierCollection(Collection<Fichier> fichierCollection) {
        this.fichierCollection = fichierCollection;
    }

}
