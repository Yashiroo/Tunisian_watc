/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Fichier {
    private Integer idFichier;
   
    private Message messageIdMessage;

    public Fichier() {
    }

    public Fichier(Integer idFichier) {
        this.idFichier = idFichier;
    }

    public Integer getIdFichier() {
        return idFichier;
    }

    public void setIdFichier(Integer idFichier) {
        this.idFichier = idFichier;
    }

    public Message getMessageIdMessage() {
        return messageIdMessage;
    }

    public void setMessageIdMessage(Message messageIdMessage) {
        this.messageIdMessage = messageIdMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichier != null ? idFichier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichier)) {
            return false;
        }
        Fichier other = (Fichier) object;
        if ((this.idFichier == null && other.idFichier != null) || (this.idFichier != null && !this.idFichier.equals(other.idFichier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Fichier[ idFichier=" + idFichier + " ]";
    }
    
    
}
