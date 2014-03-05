/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CitoyenDAO;
import Entities.Citoyen;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yashiro
 */
public class CompteCitoyen extends javax.swing.JPanel {
//
//    CitoyenDAO cd=new CitoyenDAO();
//    List<Citoyen> liste=cd.getAllCitoyens();
//    TableModelClient model1=new TableModelClient(liste);
   /**
     * Creates new form statistiques
     */
    public CompteCitoyen() {
        initComponents();
                 CitoyenDAO RES = new CitoyenDAO();
        List<Citoyen> listcit = new ArrayList<Citoyen>();
        listcit=RES.DisplayAllCitoyen();
        String[] colName = new String[] {
           "cin", "Nom", "Prénom","adresse_mail","telephone"
            };
         
        DefaultTableModel model = new DefaultTableModel(colName, WIDTH);
        tableCitoyens.setModel(model);
        
        int i=0;
        int j=0;
        String status="Inconnu";
        for(Citoyen c:listcit)
        {
               // if(c.getStatus()==1)
                //    status="Actif";
              //  else if(c.getStatus()==0)
                 //   status="Non Actif";
                model.addRow(new Object[]{"", "", ""});
                
                
               tableCitoyens.getModel().setValueAt(c.getCin(),i,j);
                tableCitoyens.getModel().setValueAt(c.getNom(),i,j+1);
                tableCitoyens.getModel().setValueAt(c.getPrenom(),i,j+2);
               tableCitoyens.getModel().setValueAt(c.getAdress_mail(),i,j+3);
             tableCitoyens.getModel().setValueAt(c.getPhone(),i,j+4);
                
               // tableCitoyens.getModel().setValueAt(status,i,j+5);
            
           i+=1;
           //j+=1;
            
        }
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
        tableCitoyens = new javax.swing.JTable();
        btnActiver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("     Citoyens");

        tableCitoyens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCitoyensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCitoyens);

        btnActiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActiverActionPerformed(evt);
            }
        });

        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActiver, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActiver, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    }//GEN-LAST:event_formComponentShown

    private void btnActiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActiverActionPerformed
   

        String s = tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(), 6).toString();

        if (s.equals("Actif")) {
            System.out.println(tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(), 6));
            desactiver_citoyen();
            afficher();
           

        }
        if (s.equals("Non Actif")) {
            System.out.println(tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(), 6));
            activer_citoyen();
             afficher();

        }
    }//GEN-LAST:event_btnActiverActionPerformed

    private void tableCitoyensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCitoyensMouseClicked

    }//GEN-LAST:event_tableCitoyensMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                String requete = "delete from Citoyen where cin=?";
        try {
            
           int response = JOptionPane.showConfirmDialog(null, "vous voulez supprimer ?");
               DefaultTableModel model=(DefaultTableModel) tableCitoyens.getModel();
               System.out.print(response);
   if (tableCitoyens.getSelectedRow()==-1)
   {
       
       if (tableCitoyens.getRowCount()==0)
       {
           JOptionPane.showMessageDialog(null, "is empty");
       }
       
       else{
             JOptionPane.showMessageDialog(null, "you must select a row");
         
       }
   }
   else {
            int row = tableCitoyens.getSelectedRow();
            int col =tableCitoyens.getSelectedColumn();
            int data = (int)tableCitoyens.getValueAt(row,3);
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,data);
            ps.executeUpdate();
       model.removeRow(tableCitoyens.getSelectedRow());
       
   }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActiver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCitoyens;
    // End of variables declaration//GEN-END:variables

    public void afficher() {
        CitoyenDAO cit = new CitoyenDAO();
        List<Citoyen> listcit = new ArrayList<Citoyen>();
        listcit = cit.getAllCitoyens();
        String[] colName = new String[]{
            "Pseudo", "Nom", "Prénom", "cin", "Email", "Téléphone", "Etat"
        };

        DefaultTableModel model = new DefaultTableModel(colName, WIDTH);
   

        tableCitoyens.setModel(model);
        

        int i = 0;
        int j = 0;
        String status = "Inconnu";
        for (Citoyen c : listcit) {
            if (c.getStatus() == 1) {
                status = "Actif";
            } else if (c.getStatus() == 0) {
                status = "Non Actif";
            }
            model.addRow(new Object[]{"", "", ""});


            tableCitoyens.getModel().setValueAt(c.getLogin(), i, j);
            tableCitoyens.getModel().setValueAt(c.getNom(), i, j + 1);
            tableCitoyens.getModel().setValueAt(c.getPrenom(), i, j + 2);
            tableCitoyens.getModel().setValueAt(c.getCin(), i, j + 3);
            tableCitoyens.getModel().setValueAt(c.getAdress_mail(), i, j + 4);
            tableCitoyens.getModel().setValueAt(c.getPhone(), i, j + 5);

            tableCitoyens.getModel().setValueAt(status, i, j + 6);

            i += 1;

        }
       
         model.removeRow(tableCitoyens.getRowCount() - 1);
       
          TextButton();
    }

    public void TextButton() {
        tableCitoyens.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int row = tableCitoyens.rowAtPoint(evt.getPoint());
                int col = tableCitoyens.columnAtPoint(evt.getPoint());
               // model1.isCellEditable(row, col);
                if (row >= 0 && col >= 0) {
                    String s = tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(), 6).toString();
                    switch (s) {
                        case "Actif":
                            btnActiver.setText("Désactiver");
                            break;
                        case "Non Actif":
                            btnActiver.setText("Activer");
                            break;
                    }


                }
            }
        });
    }

    public void activer_citoyen() {
        CitoyenDAO c = new CitoyenDAO();
        // Citoyen cc1=tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(),tab)
        int x = Integer.parseInt(tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(), 3).toString());


        Citoyen cc;
        cc = c.findCitoyentByCin(x);
        
        //System.out.println(cc.getCin());
        c.activerCitoyen(cc);





    }

    public void desactiver_citoyen() {
        CitoyenDAO c = new CitoyenDAO();
    
        int x = Integer.parseInt(tableCitoyens.getValueAt(tableCitoyens.getSelectedRow(), 3).toString());


        Citoyen cc;
        cc = c.findCitoyentByCin(x);
        System.out.println("5edmet el find mta3 desactiver :p");
      
        c.desactiverCitoyen(cc);

    }

    

    }

