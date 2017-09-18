/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.capturadeerrores;

import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author Particular
 */
public class ConsolaDeErrores extends javax.swing.JFrame {

    /**
     * Creates new form ConsolaDeErrores
     */
    public ConsolaDeErrores() {
        initComponents();
        this.txtAreaConsola.setEnabled(true);
        this.txtAreaConsola.setEditable(false);
        this.txtAreaConsola.setSelectedTextColor(Color.black);
        this.txtAreaConsola.setSelectionColor(Color.ORANGE);
        
        
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
        txtAreaConsola = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAreaConsola.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaConsola.setColumns(20);
        txtAreaConsola.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        txtAreaConsola.setLineWrap(true);
        txtAreaConsola.setRows(5);
        txtAreaConsola.setRequestFocusEnabled(false);
        txtAreaConsola.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(txtAreaConsola);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTextArea getTxtAreaConsola() {
        
        
        return txtAreaConsola;
    }

    public void setTxtAreaConsola(JTextArea txtAreaConsola) {
        this.txtAreaConsola = txtAreaConsola;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsolaDeErrores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsolaDeErrores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsolaDeErrores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsolaDeErrores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsolaDeErrores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaConsola;
    // End of variables declaration//GEN-END:variables
}
