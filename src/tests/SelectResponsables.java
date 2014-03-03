/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import javafx.scene.chart.*;
import DAO.EtablissementDAO;
import DAO.GouvernoratDAO;
import DAO.ReclamationDAO;
import DAO.ResponsableDAO;
import Entities.Citoyen;
import Entities.Etablissement;
import Entities.Gouvernorat;
import Entities.Responsable;
import Entities.Reclamation;
import Entities.Ville;
import conn.MyConnection;
import GUI.SampleTableModel;
import GUI.SwingInterop;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.BarChart;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import metier.GestionCitoyen;
import metier.GestionReclamation;
import metier.GestionResponsable;

/**
 *
 * @author Yashiro
 */
public class SelectResponsables {
public static String etabName;

        public static void main(String[] args) {
                EtablissementDAO ed = new EtablissementDAO();
                ReclamationDAO td = new ReclamationDAO();
                GouvernoratDAO gd = new GouvernoratDAO();
                ResponsableDAO rd = new ResponsableDAO();
//            CompteDAO citoyen = new CompteDAO();
//            Citoyen cc = new Citoyen();
//            cc.setCin(88888888);
//            cc.setLogin("Farid");
//            cc.setNom("Farid");
//            cc.setPrenom("Latrech");
//        
//            List<Citoyen> lc = new ArrayList<Citoyen>();
//            lc=citoyen.getAllCitoyens();
        
//            for(Citoyen c:lc)
//            {
            //System.out.println(c.getNom());
//            }
            
//            List<Etablissement> listeEtab = new ArrayList<Etablissement>();
            

//            listeEtab=ed.getAllEtab();
//            for(Etablissement e1:listeEtab)
//            {
//            System.out.println(e1.getName());
//            }
            Ville v = new Ville();
            Etablissement e=ed.findEtablissementById(1);
//            System.out.println(e.getName());
            v = ed.getVilleForEtab(e);
            System.out.println(v.getNomville());
            
            
            
//            List<Reclamation> lt = new ArrayList<Reclamation>();
//            lt=td.getRecsForEtablissement(e,2,2014);
//            for(Reclamation t:lt){
//                System.out.println(t.getSujet());
//                }
            
        

        
//        List<Gouvernorat> list = new ArrayList<Gouvernorat>();
//        List<Reclamation> listerec = new ArrayList<Reclamation>();
//        list=gd.getAllGouv();
        
//        e=ed.findEtablissementById(1);
//        for(Gouvernorat g:list){
//          System.out.println(g.getNomgouv());
//            listerec=td.getRecsInfoForGouvEtab(g,e);
//            for(Reclamation r:listerec){
//                System.out.println(r.getDate_rec());
//            }
//        }
//        Gouvernorat g = new Gouvernorat();
//        g.setIdgouv(1);
        
//        listerec=td.getRecsInfoForGouvEtab(g,e);
//        GestionReclamation grec = new GestionReclamation();
//        System.out.println((listerec.size()));
//        System.out.println(grec.getRecResolues(listerec));
//        System.out.println(grec.getRecNonResolues(listerec));
        

//        System.out.println(listerec.size());
//        for(Reclamation r:listerec){
//            System.out.println(r.getDate_rec());}
//            
//        System.out.println();
        //System.out.println(gd.getAllGouvRec(g));
//        Responsable r = new Responsable();
//        r.setId(1);
//        System.out.println(ed.getEtab(r).getName());
        
        
//        Object[] res=getStatsByEtabByMonthByYear.afficherTotalRec(e, 2, 2014);
//        for(Object o:res) {
//                System.out.println((Double)o);
//            }
//            
//        
//        Object[] res2=getStatsByEtabByMonthByYear.afficherRecTraitees(e, 2, 2014);
//        for(Object o:res2) {
//            System.out.println((Double)o);
//            }
//            
//        Object[] res3=getStatsByEtabByMonthByYear.afficherRecNonTraitees(e, 2, 2014);
//        for(Object o:res3) {
//            System.out.println((Double)o);
//            }
//        
//
//        System.out.println(getStatsByEtabByMonthByYear.afficherRecNonTraitees(e, 1, 2014));
//        
//        Etablissement ee = ed.findEtablissementByName("Tunisie Télécom");
//        System.out.println(ee.getGouvernorat());
        
        
        
        /**********************************************************************************/
//        JFrame frame = new JFrame();
//         JPanel panel = new JPanel();
//         JTable table;
//         etabName="STEG";
////         etabName="Tunisie Télécom";
//         SampleTableModel tableModel;
//         panel.setLayout(new BorderLayout());
//         tableModel = new SampleTableModel();
//         table = new JTable(tableModel);
//         table.getColumnModel().getColumn(0).setMinWidth(160);
//        
//        panel.add(table);
//    //JTable
//     table = new JTable(tableModel);
//     SwingInterop si = new SwingInterop();
////     Chart bt;
//
//     
//     frame.setBounds(960, 200, 700, 500);
//     frame.add(panel);
//     frame.setVisible(true);
//     
//     
//     
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                /**********************************************************************************/
        
//        GestionCitoyen gr = new GestionCitoyen();
//        String[] ar = gr.getEmails();
//        
//        for(String s:ar){
//            System.out.println(s);
//        }
        
}
}