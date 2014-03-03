/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.CompteDAO;
import Entities.Responsable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yashiro
 */
public class GestionResponsable {
    
    
    
    
    public String[] getEmails(){
//            System.out.println("i am getting emails");
            CompteDAO cd = new CompteDAO();
            List<Responsable> lt = new ArrayList<Responsable>();
            lt=cd.selectAllResponsables();
            String[] res = new String[lt.size()];
            int i=0;
            for(Responsable r:lt){

                res[i]=(r.getAdress_mail());
                i+=1;
                
                }
            return res;
    }
}
