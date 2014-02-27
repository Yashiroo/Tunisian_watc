/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DAO.CompteDAO;
import DAO.EtablissementDAO;
import DAO.GouvernoratDAO;
import DAO.ReclamationDAO;
import Entities.Citoyen;
import Entities.Etablissement;
import Entities.Gouvernorat;
import Entities.Responsable;
import Entities.Reclamation;
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
//            System.out.println(e1.getName());
            }
            
            Etablissement e = new Etablissement();
            e=ed.findEtablissementById(1);
            ReclamationDAO td = new ReclamationDAO();
            List<Reclamation> lt = new ArrayList<Reclamation>();
            lt=ed.getRecsForEtablissement(e,2,2014);
            for(Reclamation t:lt){
//                System.out.println(t.getSujet());
            
            
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
        Responsable r = new Responsable();
        r.setId(1);
        //System.out.println(ed.getEtab(r).getName());
        
        
        Object[] res=getStatsByEtabByMonthByYear.afficherTotalRec(e, 2, 2014);
        for(Object o:res) {
//                System.out.println((Double)o);
            }
            
        
        Object[] res2=getStatsByEtabByMonthByYear.afficherRecTraitees(e, 2, 2014);
        for(Object o:res2) {
//            System.out.println((Double)o);
            }
            
        Object[] res3=getStatsByEtabByMonthByYear.afficherRecNonTraitees(e, 2, 2014);
        for(Object o:res3) {
//            System.out.println((Double)o);
            }
        

        System.out.println(getStatsByEtabByMonthByYear.afficherRecNonTraitees(e, 1, 2014));
        
        Etablissement ee = ed.findEtablissementByName("Tunisie Télécom");
        System.out.println(ee.getGouvernorat());
        
        
        
        
        
        
        
        
        
        
        
}
}