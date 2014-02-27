/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.EtablissementDAO;
import DAO.GouvernoratDAO;
import DAO.ReclamationDAO;
import Entities.Etablissement;
import Entities.Gouvernorat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import metier.GestionReclamation;

/**
 *
 * @author Yashiro
 */
public class stats_gouvernorat extends javax.swing.JPanel {

    /**
     * Creates new form stats_gouvernorat
     */
    public stats_gouvernorat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gouvtab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(845, 469));

        gouvtab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(gouvtab);

        jLabel1.setText("Statistiques des Réclamations par Gouvernorat et Etablissement");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gouvtab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

public void afficher(){
    
        GouvernoratDAO gd = new GouvernoratDAO();
        EtablissementDAO ed = new EtablissementDAO();
        ReclamationDAO rd = new ReclamationDAO();
        List<Gouvernorat> liste = new ArrayList<Gouvernorat>();
        liste=gd.getAllGouv();
        List<Etablissement> listeEtab = new ArrayList<Etablissement>();
        listeEtab = ed.getAllEtab();
        
        String[] colName = new String[] {
           "Gouvernorat","Etablissement", "Réclamations", "Réclamations résolues", "Réclamations non résolues"
            };
        
        DefaultTableModel model = new DefaultTableModel(colName, WIDTH); 
        
        gouvtab.setModel(model);
        int k=0;
        GestionReclamation grec = new GestionReclamation();
//        int grecs=0;
        
                
        
        for(Gouvernorat g:liste){
                //int i=1;
            gouvtab.getModel().setValueAt(g.getNomgouv(),k,0);
            
            for(Etablissement e:listeEtab){
                k+=1;
                model.addRow(new Object[]{""});
                gouvtab.getModel().setValueAt("",k,0);
                gouvtab.getModel().setValueAt(e.getName(),k,1);
                
                gouvtab.getModel().setValueAt(rd.getRecsForGouvEtab(g,e),k,2);
                gouvtab.getModel().setValueAt(grec.getRecResolues(rd.getRecsInfoForGouvEtab(g,e)),k,3);
                gouvtab.getModel().setValueAt(grec.getRecNonResolues(rd.getRecsInfoForGouvEtab(g,e)),k,4);
            }
            model.addRow(new Object[]{""});
            k+=1;
            }
            
        
    
        model.removeRow(gouvtab.getRowCount()-1);
    
    }
    
    
    









}
