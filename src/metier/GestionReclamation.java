/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entities.Reclamation;
import java.util.List;

/**
 *
 * @author Yashiro
 */
public class GestionReclamation {
    
    public int getRecResolues(List<Reclamation> l){
        int res=0;
        for(Reclamation r:l)
        {
            if(r.getEtat().equalsIgnoreCase("resolue")) {
                res+=1;
            }       
        }

        
        return res;
    }
    
    public int getRecNonResolues(List<Reclamation> l){
        int res=0;
        for(Reclamation r:l)
        {
            if(r.getEtat().equalsIgnoreCase("non resolue")) {
                res+=1;
            }       
        }

        
        return res;
    }
    
    
    
}
