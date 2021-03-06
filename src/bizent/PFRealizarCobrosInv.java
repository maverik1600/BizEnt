/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;
import java.util.Date;
import java.text.*;
/**
 *
 * @author Nahuel
 */
public class PFRealizarCobrosInv extends javax.swing.JDialog {

    /**
     * Creates new form RealizarCobrosInv
     */
    CobroPorInversion cobroInv;
    String descri = "";

    public PFRealizarCobrosInv(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setComponents();
    }
    
    public PFRealizarCobrosInv(java.awt.Frame parent, boolean modal, int idInv, String descripcion, String tipoInv, Object vencimiento) {
        super(parent, modal);
        initComponents();
        setComponents();
        txtDescripcion.setText(descripcion);
        txtTipoInv.setText(tipoInv);
        Date a = (Date)vencimiento;
        txtFechaCobro.setText(String.valueOf(a.getDate())+"-"+String.valueOf(a.getMonth()+1)+"-"+String.valueOf(a.getYear()+1900));
        
        cobroInv = BizEnt.db.getCobrosInv(idInv).get(0);
        descri = descripcion;
        
        double monto = cobroInv.getMonto();           
        DecimalFormat df = new DecimalFormat("#.##"); 
        txtMonto.setText(String.valueOf(df.format(monto)));
                
                
        cmbCuentas.setModel(BizEnt.db.getCuentasComboBoxModel());
        if(BizEnt.db.getCuentasTableModel().getRowCount() > 0)
        {
            cmbCuentas.setSelectedIndex(0);
        }
    }
    
    private void setComponents(){
        txtTipoInv.setEditable(false);
        txtDescripcion.setEditable(false);
        txtMonto.setEditable(false);
        txtFechaCobro.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipoInv = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFechaCobro = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        cmbCuentas = new javax.swing.JComboBox();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtTipoInv = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFechaCobro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Cobro");

        lblTipoInv.setText("Tipo de Inversión:");

        lblDescripcion.setText("Descripción:");

        lblFechaCobro.setText("Fecha de Cobro:");

        lblCuenta.setText("Cuenta:");

        cmbCuentas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caja", "Citibank", "Credicop" }));

        lblMonto.setText("Monto:");

        btnAceptar.setText("Cobrar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipoInv)
                    .addComponent(lblDescripcion)
                    .addComponent(lblFechaCobro)
                    .addComponent(lblMonto)
                    .addComponent(lblCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addComponent(txtTipoInv))
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoInv)
                    .addComponent(txtTipoInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaCobro)
                    .addComponent(txtFechaCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuenta)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        cobroInv.setMovDst(new Movimiento(0,0,((Cuenta) cmbCuentas.getSelectedItem()), BizEnt.db.getCategoria(51), cobroInv.getFechaCobro().getTime() , descri, cobroInv.getMonto()));
        
        BizEnt.db.realizarCobroInv(cobroInv);
        
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed


    /*
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RealizarCobrosInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RealizarCobrosInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RealizarCobrosInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RealizarCobrosInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                RealizarCobrosInv dialog = new RealizarCobrosInv(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbCuentas;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaCobro;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTipoInv;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaCobro;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTipoInv;
    // End of variables declaration//GEN-END:variables


}
