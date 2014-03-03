/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Yashiro
 */
public class Etablissement {
            private int id;
            private String name;
            private int ville;
            private String type;
            private int gouvernorat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVille() {
        return ville;
    }

    public void setVille(int ville) {
        this.ville = ville;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(int gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public Etablissement() {
    }
            
            
            
            
            
}
