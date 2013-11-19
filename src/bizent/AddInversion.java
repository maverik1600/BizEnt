/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nahuel
 */
public class AddInversion extends javax.swing.JDialog {
    private Inversion inversion = new Inversion();
    /**
     * Creates new form addPlazoFijo
     */
    public AddInversion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombos();
        
    }
    
    private void cargarCombos(){
        cmbCuentas.setModel(BizEnt.db.getCuentasComboBoxModel());
        if(BizEnt.db.getCuentasTableModel().getRowCount() > 0)
         {
            cmbCuentas.setSelectedIndex(0);
         }
        
        cmbTipoInv.setModel(BizEnt.db.getTiposInversionComboBoxModel());
 
        
        cmbTipoInteres.setModel(BizEnt.db.getTiposInteresComboBoxModel());
        
        cmbFechaInicio.setDate(new Date());
        cmbFechaVencimiento.setMinSelectableDate(cmbFechaInicio.getDate());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFechaInicio = new javax.swing.JLabel();
        lblPlazoEnDias = new javax.swing.JLabel();
        lblFechaVenc = new javax.swing.JLabel();
        txtPlazoEnDias = new javax.swing.JTextField();
        lblCapital = new javax.swing.JLabel();
        txtCapital = new javax.swing.JTextField();
        lblCuenta = new javax.swing.JLabel();
        cmbCuentas = new javax.swing.JComboBox();
        lblTasaInteres = new javax.swing.JLabel();
        lblTipoInteres = new javax.swing.JLabel();
        cmbTipoInteres = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTipoInv = new javax.swing.JLabel();
        cmbTipoInv = new javax.swing.JComboBox();
        txtTasaInteres = new javax.swing.JTextField();
        cmbFechaInicio = new com.toedter.calendar.JDateChooser();
        cmbFechaVencimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Inversión");
        setIconImage(null);
        setIconImages(null);

        lblDescripcion.setText("Descripción:");

        lblFechaInicio.setText("Fecha inicio:");

        lblPlazoEnDias.setText("Plazo en días:");

        lblFechaVenc.setText("Fecha de Vencimiento:");

        txtPlazoEnDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlazoEnDiasActionPerformed(evt);
            }
        });
        txtPlazoEnDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlazoEnDiasFocusLost(evt);
            }
        });

        lblCapital.setText("Capital:");

        lblCuenta.setText("Cuenta:");

        cmbCuentas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caja", "Citibank", "Credicop" }));

        lblTasaInteres.setText("Tasa de Interés:");

        lblTipoInteres.setText("Tipo de Interés:");

        cmbTipoInteres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TNA", "TEA" }));

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

        lblTipoInv.setText("Tipo de Inversión:");

        cmbTipoInv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plazo Fijo Tradicional" }));

        cmbFechaInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbFechaInicioFocusLost(evt);
            }
        });

        cmbFechaVencimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmbFechaVencimientoMouseExited(evt);
            }
        });
        cmbFechaVencimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbFechaVencimientoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuenta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipoInv, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPlazoEnDias, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaVenc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCapital, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTasaInteres, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTasaInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoInteres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPlazoEnDias, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuenta)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoInv)
                    .addComponent(cmbTipoInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicio)
                    .addComponent(cmbFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlazoEnDias)
                    .addComponent(txtPlazoEnDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaVenc)
                    .addComponent(cmbFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapital))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTasaInteres)
                    .addComponent(lblTipoInteres)
                    .addComponent(cmbTipoInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTasaInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        /* Verifico que la cuenta tenga dinero suficiente */
        if(((Cuenta) cmbCuentas.getSelectedItem()).getSaldo()<Double.parseDouble(txtCapital.getText())){
            BizEnt.showERROR(this, "La cuenta no posee suficiente dinero.");
            return;
        }else {
            /* Si tiene dinero suficiente: agrego el movimiento*/
            //movimiento con categoria Plazo Fijo id=50. (Esto TEMPORAL)
            inversion.setMovSrc(new Movimiento(0,0,((Cuenta) cmbCuentas.getSelectedItem()), BizEnt.db.getCategoria(50), cmbFechaInicio.getDate(), txtDescripcion.getText(), Double.parseDouble(txtCapital.getText())));
        }
        
        /* Verifico la informacion ingresada en el campo Descripcion */
        if (txtDescripcion.getText().isEmpty()) {
            BizEnt.showERROR(this, "La descripcion no puede estar vacia.");
            return;
        } else {
            inversion.setDescripcion(txtDescripcion.getText());
        }
        
        /* Tipo de Inversion */
        inversion.setTipoInv(((TipoInversion)cmbTipoInv.getSelectedItem()));
        
        inversion.setFechaCreacion(cmbFechaInicio.getCalendar());
        inversion.setInversionInicial(Double.parseDouble(txtCapital.getText()));
        
        /* Fecha Vencimiento */
        inversion.setFechaVencimiento(cmbFechaVencimiento.getCalendar());
        
        /* Cobros: en este caso es un plazo fijo, por es es uno solo*/
        //inversion.getCobrosInv().add(new CobroPorInversion(0, cmbFechaVencimiento.getCalendar(), Inversion.InteresSimplePorDuracion(Double.parseDouble(txtCapital.getText()), Double.parseDouble(txtTasaInteres.getText()), Integer.parseInt(txtPlazoEnDias.getText())), null));
        double capitalInicial = Double.parseDouble(txtCapital.getText());
        double tasaInt = Double.parseDouble(txtTasaInteres.getText())/100;
        double dias = Double.parseDouble(txtPlazoEnDias.getText());
        
        double capitalFinal =  capitalInicial*(1.0+(tasaInt)*(dias/365));
        
        inversion.getCobrosInv().add(new CobroPorInversion(0, cmbFechaVencimiento.getCalendar(), capitalFinal, null));
        
        
        /* Interes y Tipo Interes*/
        //el periodo es 1 porque es un plazo fijo
        inversion.getInteresesInv().add(new InteresInversion(0,Double.parseDouble(txtTasaInteres.getText()), ((TipoInteres) cmbTipoInteres.getSelectedItem()), 1));
        
        /* Insertamos la nueva inversion */
        if (!BizEnt.db.insertInversion(inversion)) {
            BizEnt.showERROR(this, "La inversion no pudo ser agregada.");
        }

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPlazoEnDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlazoEnDiasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPlazoEnDiasActionPerformed

    private void txtPlazoEnDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlazoEnDiasFocusLost
        // TODO add your handling code here:
        if(!txtPlazoEnDias.getText().isEmpty())
        {
        Calendar c = Calendar.getInstance();
        c.setTime(cmbFechaInicio.getDate());
        c.add(Calendar.DATE, Integer.parseInt(txtPlazoEnDias.getText()));
        cmbFechaVencimiento.setCalendar(c);   
        }
    }//GEN-LAST:event_txtPlazoEnDiasFocusLost

    private void cmbFechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbFechaInicioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFechaInicioFocusLost

    private void cmbFechaVencimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbFechaVencimientoFocusLost
        // TODO add your handling code here:
        long diffInMiliSec = cmbFechaVencimiento.getCalendar().getTimeInMillis() - cmbFechaInicio.getCalendar().getTimeInMillis();
        
        long diasDiff = diffInMiliSec / (24*60*60*1000);
        
        txtPlazoEnDias.setText(Long.toString(diasDiff));
        txtPlazoEnDias.setText("Lalala");
    }//GEN-LAST:event_cmbFechaVencimientoFocusLost

    private void cmbFechaVencimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbFechaVencimientoMouseExited
        // TODO add your handling code here:
         long diffInMiliSec = cmbFechaVencimiento.getCalendar().getTimeInMillis() - cmbFechaInicio.getCalendar().getTimeInMillis();
        
        long diasDiff = diffInMiliSec / (24*60*60*1000);
        
        txtPlazoEnDias.setText(Long.toString(diasDiff));
        txtPlazoEnDias.setText("Lalala");
    }//GEN-LAST:event_cmbFechaVencimientoMouseExited

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbCuentas;
    private com.toedter.calendar.JDateChooser cmbFechaInicio;
    private com.toedter.calendar.JDateChooser cmbFechaVencimiento;
    private javax.swing.JComboBox cmbTipoInteres;
    private javax.swing.JComboBox cmbTipoInv;
    private javax.swing.JLabel lblCapital;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaVenc;
    private javax.swing.JLabel lblPlazoEnDias;
    private javax.swing.JLabel lblTasaInteres;
    private javax.swing.JLabel lblTipoInteres;
    private javax.swing.JLabel lblTipoInv;
    private javax.swing.JTextField txtCapital;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPlazoEnDias;
    private javax.swing.JTextField txtTasaInteres;
    // End of variables declaration//GEN-END:variables
}
