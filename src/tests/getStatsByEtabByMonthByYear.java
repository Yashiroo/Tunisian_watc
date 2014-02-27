/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

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
            Object[] totalrec = new Object[12];
            EtablissementDAO ed = new EtablissementDAO();
            int m=1;
            for(int i=0;i<12;i++)
            {
                
                totalrec[i]=new Double(ed.totalRec(e,m,year));
                m+=1;
            }
             
             
             for(int i=0;i<12;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
    
            return totalrec;
}
        
     
        public static Object[] afficherRecTraitees(Etablissement e,int month,int year){
            Object[] totalrec = new Object[12];
            EtablissementDAO ed = new EtablissementDAO();
            int m=1;
            for(int i=0;i<12;i++)
            {

                totalrec[i]=new Double(ed.recTraitees(e,m,year));
                m+=1;
                }
            
            for(int i=0;i<12;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
    
            return totalrec;
}

        
        
        public static Object[] afficherRecNonTraitees(Etablissement e,int month,int year){
            Object[] totalrec = new Object[12];
            EtablissementDAO ed = new EtablissementDAO();
            int m=1;
            for(int i=0;i<12;i++)
            {

                totalrec[i]=new Double(ed.recNonTraitees(e,m,year));
                m+=1;
                }
            
            
            for(int i=0;i<12;i++)
             {
                 if(totalrec[i]==null)
                     totalrec[i]=0.0;
                 
             }
            return totalrec;
}


        
        
        }


