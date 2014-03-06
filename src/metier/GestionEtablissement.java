/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.EtablissementDAO;
import DAO.ReclamationDAO;
import Entities.Etablissement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yashiro
 */
public class GestionEtablissement {
    

        public static void main(String[] args) {
//            EtablissementDAO ed = new EtablissementDAO();
//            Etablissement etab=ed.findEtablissementById(2);
//            for(int i=0;i<10;i++)
//            {
//
//                System.out.println(afficherTotalRec(etab,1,2014)[i]);
//                System.out.println(afficherRecTraitees(etab,1,2014)[i]);
//                System.out.println(afficherRecNonTraitees(etab,1,2014)[i]);
//            }
            
//            afficherRecTraitees(etab,1,2014);
//            afficherRecNonTraitees(etab,1,2014);
//            System.out.println(numEtabs());
    }
        public static Object[] afficherTotalRec(Etablissement e,int month,int year){
            Object[] totalrec = new Object[13];
            ReclamationDAO td = new ReclamationDAO();
            int m=1;
            totalrec[0]="Réclamations";
            for(int i=1;i<13;i++)
            {
                
                totalrec[i]=new Double(td.totalRec(e,m,year));
                m+=1;
            }
             
             
             for(int i=0;i<13;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
    
            return totalrec;
}
        
     
        public static Object[] afficherRecTraitees(Etablissement e,int month,int year){
            Object[] totalrec = new Object[13];
            ReclamationDAO td = new ReclamationDAO();
            int m=1;
            totalrec[0]="Réclamations Résolues";
            for(int i=1;i<13;i++)
            {
                
                totalrec[i]=new Double(td.recTraitees(e,m,year));
                m+=1;
                }
            
            for(int i=0;i<13;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
    
            return totalrec;
}

        
        
        public static Object[] afficherRecNonTraitees(Etablissement e,int month,int year){
            Object[] totalrec = new Object[13];
            
            ReclamationDAO td = new ReclamationDAO();
            int m=1;
            totalrec[0]="Réclamations Non Résolues";
            for(int i=1;i<13;i++)
            {
                
                totalrec[i]=new Double(td.recNonTraitees(e,m,year));
                m+=1;
                }
            
            
            for(int i=0;i<13;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
            return totalrec;
}
        
        public static int numEtabs(){
            EtablissementDAO ed = new EtablissementDAO();
            List<Etablissement> listetab = new ArrayList<Etablissement>();
            listetab=ed.getAllEtab();
            return listetab.size();
        }
        
        
        
        }


