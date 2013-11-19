/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.text.PlainDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


/**
 *
 * @author Surai
 */
public class AddVencimiento extends javax.swing.JDialog {
    private Vencimiento vencimiento;

    public AddVencimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCateg = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        ((PlainDocument) txtNombre.getDocument()).setDocumentFilter(new CustDocumentFilter("^[a-zA-Z0-9_\\- ]{0,30}$"));
        lblNombre = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        ((PlainDocument) txtMonto.getDocument()).setDocumentFilter(new CustDocumentFilter("^[0-9]*[.]{0,1}[0-9]{0,2}$"));
        lblFecha = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();
        ckboxSi = new javax.swing.JCheckBox();
        lblFecha2 = new javax.swing.JLabel();
        cmboxEstado = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane3 = new javax.swing.JScrollPane();
        categTree = new javax.swing.JTree();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vencimiento");

        jLabelCateg.setText("Categoría :");

        lblNombre.setText("Nombre: ");

        lblMonto.setText("Monto: ");

        lblFecha.setText("Fecha: ");

        lblFecha1.setText("¿Desea Programar una Alarma?");

        ckboxSi.setText("Sí");
        ckboxSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckboxSiActionPerformed(evt);
            }
        });

        lblFecha2.setText("Día: ");
        lblFecha2.setFocusable(false);
        lblFecha2.setVisible(false);

        cmboxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a efectuar", "Efectuado" }));
        cmboxEstado.setVisible(false);
        cmboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxEstadoActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado: ");
        lblEstado.setVisible(false);

        btnAceptar.setText("Aceptar");
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

        jXDatePicker2.setVisible(false);

        jScrollPane3.setViewportView(categTree);

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCateg)
                            .addComponent(lblMonto)
                            .addComponent(lblFecha)
                            .addComponent(lblNombre))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(217, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3))
                                .addGap(25, 25, 25))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addGap(183, 183, 183)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ckboxSi))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblFecha2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCateg)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFecha)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha1)
                    .addComponent(ckboxSi))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha2)
                            .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addComponent(cmboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    
    private void cmboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxEstadoActionPerformed

    private void ckboxSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckboxSiActionPerformed
        if(ckboxSi.isSelected())
        {
            lblFecha2.setVisible(true);
            jXDatePicker2.setVisible(true);
        }
        else
        {
            lblFecha2.setVisible(false);
            jXDatePicker2.setVisible(false);
        }
    }//GEN-LAST:event_ckboxSiActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtNombre.getText().isEmpty()) {
            //BizEnt.showERROR(this, "El nombre no puede estar vacio.");
            vencimiento.setNombre(" ");
        }
        else
        {
            vencimiento.setNombre(txtNombre.getText());
        }
        Calendar aux=Calendar.getInstance();
        aux.set(Calendar.HOUR, 0);
        aux.set(Calendar.MINUTE, 0);
        aux.set(Calendar.SECOND, 0);
        aux.set(Calendar.MILLISECOND, 0);
        
        if ((jXDatePicker1.getDate()).compareTo(aux.getTime())<0) {
                BizEnt.showERROR(this, "La fecha de vencimiento no puede ser anterior a la actual.");
                return;
         } else {
                
                if(vencimiento.getId()!=0)
                {
                    aux.setTime(vencimiento.getFecha());
                    Calendar a=Calendar.getInstance();
                    vencimiento.setFecha(jXDatePicker1.getDate());
                    a.setTime(vencimiento.getFecha());
                    int resta=a.get(Calendar.DAY_OF_YEAR)-aux.get(Calendar.DAY_OF_YEAR);
                    int restaA=a.get(Calendar.YEAR)-aux.get(Calendar.YEAR);
                    if (resta>30||resta<-30)
                    {
                        resta=JOptionPane.showConfirmDialog(getParent(),"La diferencia entre la fecha ingresada y la anterior es mayor a un mes\n¿Está seguro de que desea continuar?","Fecha", JOptionPane.YES_NO_OPTION);
                        if (resta==1)
                        {
                            vencimiento.setFecha(a);
                            return;
                        }
                    }
                    else if(restaA!=0)
                    {
                        if((a.get(Calendar.MONTH)!=0||a.get(Calendar.MONTH)!=11)||((restaA>1)||(restaA<-1)))
                        {
                            resta=JOptionPane.showConfirmDialog(getParent(),"El año que está ingresando en la fecha es diferente al año actual del vencimiento.\n¿Está seguro de que desea continuar?","Fecha", JOptionPane.YES_NO_OPTION);
                            if (resta==1)
                            {
                            vencimiento.setFecha(a);
                            return;
                            }
                        }
                    }
                }
                else
                {
                    vencimiento.setFecha(jXDatePicker1.getDate());
                }
        }
        
        if (getSelectedCateg() == null || getSelectedCateg().getId() == 1) {
            BizEnt.showERROR(this, "Debe seleccionar una categoría.");
            return;
        } else {
            vencimiento.setCateg(getSelectedCateg());
        }
            
            if (ckboxSi.isSelected()) {
                Calendar a=Calendar.getInstance();
                a.set(Calendar.HOUR, 0);
                a.set(Calendar.MINUTE, 0);
                a.set(Calendar.SECOND, 0);
                a.set(Calendar.MILLISECOND, 0);
                if ((jXDatePicker2.getDate()).compareTo(a.getTime())<0) {
                BizEnt.showERROR(this, "La fecha de alarma no puede ser anterior a la actual.");
                return;
                }
                else
                {
                    Date d=jXDatePicker2.getDate();
                    vencimiento.setDiasAnticip(d);
                }
            } else {
                vencimiento.setDiasAnticip(null);
            }
       

        try {
            vencimiento.setMonto(Double.parseDouble(txtMonto.getText()));
        } catch (java.lang.NumberFormatException e) {
            BizEnt.showERROR(this, "El monto debe ser numérico.");
            return;
        }
        if (vencimiento.getId() == 0) {
            insertVencimiento();
        } else
        {
            if(cmboxEstado.getSelectedIndex()==1)
            {
                vencimiento.setRegistrado(true);
            }
            BizEnt.db.updateVencimiento(vencimiento);} {

        }

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed
    
    private void insertVencimiento()
    {
       
        vencimiento.setRegistrado(false);

        /* Alta en la base de datos */
        if (BizEnt.db.insertVencimiento(vencimiento)==false) {
            BizEnt.showERROR(this, "No se pudo agregar el vencimiento.");
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVencimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddVencimiento dialog = new AddVencimiento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public AddVencimiento(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();

        categTree.setModel(BizEnt.db.getCategoriasTreeModel());
        if (id > 0) {
            cmboxEstado.setVisible(true);
            vencimiento = BizEnt.db.getVencimiento(id);
            lblEstado.setVisible(true);
            if (vencimiento.isRegistrado()) {
                cmboxEstado.setSelectedIndex(1);
                cmboxEstado.setEnabled(false);
                txtMonto.setEnabled(false);

                categTree.setEnabled(false);
                jXDatePicker2.setEnabled(false);
                ckboxSi.setEnabled(false);
            } else {
                cmboxEstado.setSelectedIndex(0);
            }
            txtNombre.setText(vencimiento.getNombre());
            
            categTree.setModel(BizEnt.db.getCategoriasTreeModel());
            selectTreeNode(vencimiento.getCateg());
            
            try
            {
            txtMonto.setText(Double.toString(vencimiento.getMonto()));
            }
            catch(Exception e)
            {
                
            }
            jXDatePicker1.setDate(vencimiento.getFecha());
            if (vencimiento.getDiasAnticip()!=null)
            {
                ckboxSi.setSelected(true);
                jXDatePicker2.setVisible(true);
                lblFecha2.setVisible(true);
                jXDatePicker2.setDate(vencimiento.getDiasAnticip());
            }
            else
            {
                 ckboxSi.setSelected(false);
            }

        }
        else
        {
            vencimiento=new Vencimiento(0);
            if(Calendar.getInstance().compareTo(Calendario.getDate())==-1)
            {
                Date d=Calendario.getDate().getTime();
                jXDatePicker1.setDate(d);
            }
        }
        
    }
        private void selectTreeNode(Categoria categ) {
        DefaultMutableTreeNode rootNode       = (DefaultMutableTreeNode) categTree.getModel().getRoot();
        Enumeration<DefaultMutableTreeNode> e = rootNode.depthFirstEnumeration();

        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = e.nextElement();
            if (node.toString().equals(categ.getName())) {
                categTree.setSelectionPath(new TreePath(node.getPath()));
            }
        }
    }
        private Categoria getSelectedCateg() {
        TreePath currentSelection = categTree.getSelectionPath();

        if (currentSelection != null) {
            return (Categoria) (((DefaultMutableTreeNode) currentSelection.getLastPathComponent()).getUserObject());
        }

        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTree categTree;
    private javax.swing.JCheckBox ckboxSi;
    private javax.swing.JComboBox cmboxEstado;
    private javax.swing.JLabel jLabelCateg;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
