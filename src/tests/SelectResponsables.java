/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DAO.CompteDAO;
import DAO.EtablissementDAO;
import DAO.GouvernoratDAO;
import DAO.ThreadsDAO;
import Entities.Citoyen;
import Entities.Etablissement;
import Entities.Gouvernorat;
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
            
            
            CompteDAO citoyen = new CompteDAO();
            Citoyen cc = new Citoyen();
            cc.setCin(88888888);
            cc.setLogin("Farid");
            cc.setNom("Farid");
            cc.setPrenom("Latrech");
        
            List<Citoyen> lc = new ArrayList<Citoyen>();
            lc=citoyen.getAllCitoyens();
        
            for(Citoyen c:lc)
            {
            //System.out.println(c.getNom());
            }
            
            List<Etablissement> listeEtab = new ArrayList<Etablissement>();
            
            EtablissementDAO ed = new EtablissementDAO();
            listeEtab=ed.getAllEtab();
            for(Etablissement e1:listeEtab)
            {
            System.out.println(e1.getName());
            }
            
            Etablissement e = new Etablissement();
            
            ThreadsDAO td = new ThreadsDAO();
            List<Thread> lt = new ArrayList<Thread>();
            lt=ed.getThreadsForEtablissement(e);
            for(Thread t:lt){
                //System.out.println(t.getSujet());
            
            
        }

        GouvernoratDAO gd = new GouvernoratDAO();
        List<Gouvernorat> list = new ArrayList<Gouvernorat>();
        list=gd.getAllGouv();
        
        for(Gouvernorat g:list){
            
            //System.out.println(g.getNomgouv());
            
        }
        Gouvernorat g = new Gouvernorat();
        g.setIdgouv(1);
        //System.out.println(gd.getAllGouvRec(g));

        
        
}
}