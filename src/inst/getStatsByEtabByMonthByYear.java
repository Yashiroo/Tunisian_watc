/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inst;

import DAO.EtablissementDAO;
import Entities.Etablissement;

/**
 *
 * @author Yashiro
 */
public class getStatsByEtabByMonthByYear {
    
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
            
    }
        public static Object[] afficherTotalRec(Etablissement e,int month,int year){
            Object[] totalrec = new Object[13];
            EtablissementDAO ed = new EtablissementDAO();
            int m=1;
            totalrec[0]="Réclamations";
            for(int i=1;i<13;i++)
            {
                
                totalrec[i]=new Double(ed.totalRec(e,m,year));
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
            EtablissementDAO ed = new EtablissementDAO();
            int m=1;
            totalrec[0]="Réclamations Traitées";
            for(int i=1;i<13;i++)
            {
                
                totalrec[i]=new Double(ed.recTraitees(e,m,year));
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
            EtablissementDAO ed = new EtablissementDAO();
            int m=1;
            totalrec[0]="Réclamations Non Traitées";
            for(int i=1;i<13;i++)
            {
                
                totalrec[i]=new Double(ed.recNonTraitees(e,m,year));
                m+=1;
                }
            
            
            for(int i=0;i<13;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
            return totalrec;
}


        
        
        }

