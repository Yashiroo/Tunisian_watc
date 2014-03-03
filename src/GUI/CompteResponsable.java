/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ResponsableDAO;
import Entities.Responsable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yashiro
 */
public class CompteResponsable extends javax.swing.JPanel {

   
    /**
     * Creates new form statistiques
     */
    public CompteResponsable() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResponsables = new javax.swing.JTable();
        btnDesactiver = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jLabel1.setText("Responsables");

        tableResponsables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tableResponsables.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableResponsables.setEditingColumn(0);
        tableResponsables.setEditingRow(0);
        tableResponsables.setFocusable(false);
        tableResponsables.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableResponsablesFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tableResponsables);

        btnDesactiver.setText("Désactiver");
        btnDesactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactiverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 763, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesactiver, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactiver)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    }//GEN-LAST:event_formComponentShown
    public void afficher() {
//        EtablissementDAO ed = new EtablissementDAO();
        ResponsableDAO resp = new ResponsableDAO();
        List<Responsable> listresp = new ArrayList<Responsable>();
        listresp = resp.selectAllResponsables();
        String[] colName = new String[]{
            "Pseudo", "Nom", "Prenom", "CIN", "Etablissement", "Emai", "Téléphone", "Etat"
        };
        
        DefaultTableModel model = new DefaultTableModel(colName, WIDTH);
        /* DefaultTableModel model;
         model = new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int row, int col) {
         return false;
         }};*/
        
        tableResponsables.setModel(model);
        
        int i = 0;
        int j = 0;
        String status = "Inconnu";
        for (Responsable r : listresp) {
            if (r.getStatus() == 1) {
                status = "Actif";
            } else if (r.getStatus() == 0) {
                status = "Non Actif";
            }
         
            model.addRow(new Object[]{""});
            tableResponsables.getModel().setValueAt(r.getLogin(), i, j);
            tableResponsables.getModel().setValueAt(r.getNom(), i, j + 1);
            tableResponsables.getModel().setValueAt(r.getPrenom(), i, j + 2);
            tableResponsables.getModel().setValueAt(r.getCin(), i, j + 3);
//            tableResponsables.getModel().setValueAt(ed.getEtab(r).getName(), i, j + 4);
            tableResponsables.getModel().setValueAt(r.getAdresse_email(), i, j + 5);
            tableResponsables.getModel().setValueAt(r.getPhone(), i, j + 6);
            tableResponsables.getModel().setValueAt(status, i, j + 7);
            
            i += 1;    
        }
        model.removeRow(tableResponsables.getRowCount() - 1);
        TextButton(); 
      
    }
   
    
    public void TextButton() {
        tableResponsables.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableResponsables.rowAtPoint(evt.getPoint());
                int col = tableResponsables.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    
                    
                    if (tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 7) == "Actif") {
                        btnDesactiver.setText("Désactiver");
                    } else if (tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 7) == "Non Actif") {
                        btnDesactiver.setText("Activer");
                    }
                    
                }
            }
        });
        
        
    }
    
    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded
    
    private void btnDesactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactiverActionPerformed
        
        String s = tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 7).toString();
//        System.out.println("s");
        if (s.equals("Actif")) {
//            System.out.println(tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 7));
            desactiver_responsable();
            afficher();
        
        }
        if (s.equals("Non Actif")) {
//            System.out.println(tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 7));
            activer_responsable();
            afficher();
        }
    }//GEN-LAST:event_btnDesactiverActionPerformed

    private void tableResponsablesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableResponsablesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tableResponsablesFocusLost
    public void activer_responsable() {
        ResponsableDAO r = new ResponsableDAO();
        int x = Integer.parseInt(tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 3).toString());
       
        
        Responsable res;
        res = r.findResponsabletByCin(x);
//        System.out.println("5edmet el find mta3 desactiver responsable :p");
    
        r.activerResponsable(res);
        
        
    }
    
    public void desactiver_responsable() {
        ResponsableDAO r = new ResponsableDAO();
        // Citoyen cc1=tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(),tab)
        int x = Integer.parseInt(tableResponsables.getValueAt(tableResponsables.getSelectedRow(), 3).toString());
        
        
        Responsable res;
        res = r.findResponsabletByCin(x);
//        System.out.println("5edmet el find mta3 desactiver responsable :p");
//        System.out.println(res.getCin());
        r.desactiverResponsable(res);
        
   
    
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesactiver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableResponsables;
    // End of variables declaration//GEN-END:variables
}
