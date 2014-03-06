/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.EtablissementDAO;
import DAO.GouvernoratDAO;
import DAO.ReclamationDAO;
import DAO.VilleDAO;
import Entities.Etablissement;
import Entities.Gouvernorat;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Yashiro
 */
public class GeneratePDFEtabGouv {
    public static void main(String[] args) {
        
    }
    public static boolean generate(){
        ReclamationDAO td = new ReclamationDAO();
        EtablissementDAO ed = new EtablissementDAO();
        try{
//        GestionEtablissement.numEtabs()
        PdfPTable table = new PdfPTable(5);
        List<Etablissement> le = new ArrayList<Etablissement>();
        le=ed.getAllEtab();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        PdfPCell empty = new PdfPCell();
//        empty.setColspan(4);
            
            
        Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream("Rapport Filtré "+dateFormat.format(new Date())+".pdf"));
        document.open();
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.setFont(FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD,BaseColor.RED));
        title.add("Statistiques des Etablissement Filtrées par Gouvernorat\n\n\n");
        document.add(title);
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n\n\n"));

        Paragraph p0 = new Paragraph();
        p0.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p0.add("Gouvernorat");
        p0.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell0 = new PdfPCell();
        cell0.addElement(p0);
        cell0.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell0.setPaddingBottom(10);
        table.addCell(cell0);

    
        Paragraph p1 = new Paragraph();
        p1.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p1.add("Etablissement");
        p1.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell1 = new PdfPCell();
        cell1.addElement(p1);
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell1);
        
        Paragraph p2 = new Paragraph();
        p2.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p2.add("Réclamations");
        p2.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell2 = new PdfPCell();
        cell2.addElement(p2);
        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell2.setFixedHeight(4f);
        table.addCell(cell2);
        
        Paragraph p3 = new Paragraph();
        p3.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p3.add("Réclamations résolues");
        p3.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell3 = new PdfPCell();
        cell3.addElement(p3);
        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell3);
        
        Paragraph p4 = new Paragraph();
        p4.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p4.add("Réclamations non résolues");
        p4.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell4 = new PdfPCell();
        cell4.addElement(p4);
        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell4);
        
        
        GouvernoratDAO gd = new GouvernoratDAO();
        ReclamationDAO rd = new ReclamationDAO();
        List<Gouvernorat> liste = new ArrayList<Gouvernorat>();
        GestionReclamation grec = new GestionReclamation();
        VilleDAO vd = new VilleDAO();
        liste=gd.getAllGouv();
        List<Etablissement> listeEtab = new ArrayList<Etablissement>();
        listeEtab = ed.getAllEtab();
        for(Gouvernorat g:liste){
                //int i=1;
                table.addCell(g.getNomgouv());
                table.addCell(empty);
                table.addCell(empty);
                table.addCell(empty);
                table.addCell(empty);
                
                for(Etablissement e:listeEtab){

                if(vd.checkVilleGouv(g,ed.getVilleForEtab(e))){
                    table.addCell("");
                    table.addCell(String.valueOf(e.getName()));

                    table.addCell(String.valueOf(rd.totalRec(e)));
                    table.addCell(String.valueOf(grec.getRecResolues(rd.getRecsForEtablissement(e))));
                    table.addCell(String.valueOf(grec.getRecNonResolues(rd.getRecsForEtablissement(e))));
                    
                }
            }

            }
        
            
            

            
            table.setWidthPercentage(100);
//            table.setExtendLastRow(true);
            table.setWidths(new int[]{26,40,30,44,50});
            
     document.add(table);

     document.close();
            System.out.println("Report Edited");
            return true;
            
            
        }catch(Exception e){
            System.out.println("Error : "+e);
            return false;
        }
    
    }
    
}
