/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.EtablissementDAO;
import DAO.ReclamationDAO;
import Entities.Etablissement;
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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yashiro
 */
public class GeneratePDFEtabs {
    public static void main(String arg[]){
    }
    public static boolean generate(){
        ReclamationDAO td = new ReclamationDAO();
        EtablissementDAO ed = new EtablissementDAO();
        try{
//        GestionEtablissement.numEtabs()
        PdfPTable table = new PdfPTable(4);
        List<Etablissement> le = new ArrayList<Etablissement>();
        le=ed.getAllEtab();
        
        
        
        Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream("Rapport.pdf"));
        document.open();
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.setFont(FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD,BaseColor.RED));
        title.add("Statistiques des Etablissement\n\n\n");
        document.add(title);
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n\n\n"));

        Paragraph p1 = new Paragraph();
        p1.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p1.add("Etablissement");
        PdfPCell cell1 = new PdfPCell();
        cell1.addElement(p1);
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell1);
        
        Paragraph p2 = new Paragraph();
        p2.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p2.add("Réclamations");
        PdfPCell cell2 = new PdfPCell();
        cell2.addElement(p2);
        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell2.setFixedHeight(4f);
        table.addCell(cell2);
        
        Paragraph p3 = new Paragraph();
        p3.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p3.add("Réclamations résolues");
        PdfPCell cell3 = new PdfPCell();
        cell3.addElement(p3);
        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell3);
        
        Paragraph p4 = new Paragraph();
        p4.setFont(FontFactory.getFont(FontFactory.TIMES_BOLDITALIC));
        p4.add("Réclamations non résolues");
        PdfPCell cell4 = new PdfPCell();
        cell4.addElement(p4);
        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell4);
        
        
            for(Etablissement e:le){
            table.addCell(e.getName());
            table.addCell((String.valueOf(td.totalRec(e))));
            table.addCell(String.valueOf(td.recTraitees(e)));
            table.addCell(String.valueOf(td.recNonTraitees(e)));
        }
        
            table.setWidthPercentage(100);
//            table.setExtendLastRow(true);
            table.setWidths(new int[]{50,35,50,50});
        
     
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
