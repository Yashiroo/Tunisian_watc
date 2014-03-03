/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.CitoyenDAO;
import Entities.Citoyen;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yashiro
 */
public class GestionCitoyen {
    
    
    
    public String[] getEmails(){
//            System.out.println("i am getting emails");
            CitoyenDAO cd = new CitoyenDAO();
            List<Citoyen> lt = new ArrayList<Citoyen>();
            lt=cd.getAllCitoyens();
            String[] res = new String[lt.size()];
            int i=0;
            for(Citoyen r:lt){

                res[i]=(r.getAdress_mail());
                i+=1;
                
                }
            return res;
    }
}
