/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DAO.CompteDAO;
import DAO.EtablissementDAO;
import DAO.ThreadsDAO;
import Entities.Citoyen;
import Entities.Etablissement;
import Entities.Responsable;
import Entities.Thread;
import conn.MyConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yashiro
 */
public class SelectResponsables {

        public static void main(String[] args) {
            
            
//            CompteDAO citoyen = new CompteDAO();
//            Citoyen cc = new Citoyen();
//            cc.setCin(88888888);
//            cc.setLogin("Farid");
//            cc.setNom("Farid");
//            cc.setPrenom("Latrech");
        
//        List<Citoyen> lc = new ArrayList<Citoyen>();
//        lc=citoyen.getAllCitoyens();
//        
//        for(Citoyen c:lc)
//        {
//            System.out.println(c.getNom());
//        }
            
            
            Etablissement e = new Etablissement();
            EtablissementDAO ed = new EtablissementDAO();
            
            e=ed.findEtablissementById(2);
            System.out.println(e.getName());
        
            
            
            ThreadsDAO td = new ThreadsDAO();
            List<Thread> lt = new ArrayList<Thread>();
            lt=ed.getThreadsForEtablissement(e);
            for(Thread t:lt){
                System.out.println(t.getSujet());
            
            
        }
        
//            EtablissementDAO ed = new EtablissementDAO();
//            List<Etablissement> et = new ArrayList<Etablissement>();
//            et=ed.getAllEtab();
//            for(Etablissement e:et){
//                System.out.println(e.getName());
//            
//            
//        }
        

        
        
}
}