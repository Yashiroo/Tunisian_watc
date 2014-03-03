/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import metier.SendtoEmailList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metier.GestionCitoyen;
import metier.GestionResponsable;
import metier.SendtoEmailList;

/**
 *
 * @author Yashiro
 */
public class SendEmails extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form SendEmails
     */
    public SendEmails() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sendListResp = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        sendArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        radioRes = new javax.swing.JRadioButton();
        radioCit = new javax.swing.JRadioButton();
        sujet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        sendButton.setText("Envoyer");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Envoyer un Email");

        sendListResp.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Tous" }));
        sendListResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendListRespActionPerformed(evt);
            }
        });

        sendArea.setColumns(20);
        sendArea.setRows(5);
        jScrollPane1.setViewportView(sendArea);

        jLabel2.setText("Adresse :");

        buttonGroup1.add(radioRes);
        radioRes.setText("Responsable");

        buttonGroup1.add(radioCit);
        radioCit.setText("Citoyen");

        jLabel3.setText("Sujet :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(radioRes)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(radioCit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(sendListResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(sujet, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(sendButton)
                            .addGap(61, 61, 61)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioRes)
                            .addComponent(radioCit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sendListResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sujet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendListRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendListRespActionPerformed

           
    }//GEN-LAST:event_sendListRespActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if(sendListResp.getSelectedItem()!=null)
        {
            String[] st = new String[1];
            st[0]=sendListResp.getSelectedItem().toString();
            SendtoEmailList.sendFromGMail("f114524@gmail.com", "QI9A5fve", st  , sujet.getText(), sendArea.getText());
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioCit;
    private javax.swing.JRadioButton radioRes;
    private javax.swing.JTextArea sendArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JComboBox sendListResp;
    private javax.swing.JTextField sujet;
    // End of variables declaration//GEN-END:variables

public void afficher(){
    
        
        radioRes.addActionListener(this);
        radioCit.addActionListener(this);
        
    
}
 

    @Override
    public void actionPerformed(ActionEvent e) {
        if(radioRes.isSelected()){
        sendListResp.removeAllItems();
        GestionResponsable gr = new GestionResponsable();
        String[] ar = gr.getEmails();
        
        for(String s:ar){
             sendListResp.addItem(s);
        }
        }
        
        else if(radioCit.isSelected()){
        sendListResp.removeAllItems();
        GestionCitoyen gc = new GestionCitoyen();
        String[] ar2 = gc.getEmails();
        for(String s:ar2){
             sendListResp.addItem(s);
        }
        }
        
        
        
        
        
        
        
        
        
    }






}