/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import javax.swing.text.PlainDocument;

/**
 *
 * @author ggmoy
 */
public class AddCuenta extends javax.swing.JDialog {
    private Cuenta cuenta;

    /**
     * Creates new form AddCuenta
     */
    public AddCuenta(java.awt.Frame parent, boolean modal) {
        this(parent, modal, 0);
    }

    /**
     * If id is equal to cero, so we are adding a new account.  Otherwise, what
     * we are doing is editing an existing account.
     */
    public AddCuenta(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();

        /* Editing and existing account? */
        if (id > 0) {
            /* Pull the account object from the database */
            cuenta = BizEnt.db.getCuenta(id);

            /* Fill the GUI components */
            txtNombre.setText(cuenta.getNombre());

            if (cuenta.getStatus()) {
                cmbStatus.setSelectedIndex(1);
            } else {
                cmbStatus.setSelectedIndex(0);
            }

            txtCBU.setText(cuenta.getCBU());
            if (cuenta.getCBU().equals("")) {
                cmbTipo.setSelectedIndex(1);
            }

            txtSaldo.setText(Double.toString(cuenta.getSaldo()));
            txtSaldo.setEnabled(false);

        /* OK, so the account is new... */
        } else {
            cuenta = new Cuenta("bogus", 0);
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
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        ((PlainDocument) txtNombre.getDocument()).setDocumentFilter(new CustDocumentFilter("^[a-zA-Z0-9_\\- ]{0,30}$"));
        txtSaldo = new javax.swing.JTextField();
        ((PlainDocument) txtSaldo.getDocument()).setDocumentFilter(new CustDocumentFilter("^[0-9]*[.]{0,1}[0-9]{0,2}$"));
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        lblCBU = new javax.swing.JLabel();
        txtCBU = new javax.swing.JTextField();
        ((PlainDocument) txtCBU.getDocument()).setDocumentFilter(new CustDocumentFilter("^\\d{0,22}$"));
        jLabel3 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Cuenta");
        setName("Agregar Cuenta"); // NOI18N
        setResizable(false);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Saldo:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Banco", "Caja" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        lblCBU.setText("CBU:");

        jLabel3.setText("Estado:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Deshabilitada", "Habilitada" }));
        cmbStatus.setSelectedIndex(1);
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCBU, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCBU, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCBU)
                    .addComponent(txtCBU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (cuenta.getId() == 0) {
            insertCuenta();
        } else if (updateCuenta()) {
            return;
        }

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if (cmbTipo.getSelectedItem().equals("Banco")) {
            txtCBU.setEnabled(true);
        } else {
            txtCBU.setEnabled(false);
            txtCBU.setText("");
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void insertCuenta() {
        /* Verifico la informacion ingresada en el campo Nombre */
        if (txtNombre.getText().isEmpty()) {
            BizEnt.showERROR(this, "El nombre no puede estar vacio.");
            return;
        } else {
            cuenta.setNombre(txtNombre.getText());
        }

        /* Verifico CBU */
        if (cmbTipo.getSelectedItem().equals("Banco")) {
            if (txtCBU.getText().isEmpty()) {
                BizEnt.showERROR(this, "El CBU no puede estar vacio.");
                return;
            } else if (BizEnt.db.existsCBU(txtCBU.getText())) {
                BizEnt.showERROR(this, "El CBU ingresado ya existe.");
                return;
            } else {
                cuenta.setCBU(txtCBU.getText());
            }
        } else {
            txtCBU.setText("");
        }

        /* Actualizo los datos de la cuenta */
        try {
            cuenta.setSaldo(Double.parseDouble(txtSaldo.getText()));
        } catch (java.lang.NumberFormatException e) {
            BizEnt.showERROR(this, "El saldo debe ser tipo numerico.");
            return;
        }

        /* Estado de la cuenta */
        if (cmbStatus.getSelectedIndex() == 0) {
            cuenta.setStatus(false);
        } else {
            cuenta.setStatus(true);
        }

        /* Insertamos la nueva cuenta */
        if (BizEnt.db.insertCuenta(cuenta)) {
            BizEnt.showERROR(this, "La cuenta no pudo ser agregada.");
        }
    }

    private boolean updateCuenta() {
        /* Verifico la informacion ingresada en el campo Nombre */
        if (!txtNombre.getText().equals(cuenta.getNombre())) {
            if (txtNombre.getText().isEmpty()) {
                BizEnt.showERROR(this, "El nombre no puede estar vacio.");
                return true;
            } else if (BizEnt.db.existsCuenta(txtNombre.getText())) {
                BizEnt.showERROR(this, "El nombre de cuenta ingresado ya existe.");
                return true;
            } else {
                cuenta.setNombre(txtNombre.getText());
            }
        }

        /* Verifico CBU */
        if (!txtCBU.getText().equals(cuenta.getCBU())) {
            if (cmbTipo.getSelectedItem().equals("Banco")) {
                if (txtCBU.getText().isEmpty()) {
                    BizEnt.showERROR(this, "El CBU no puede estar vacio.");
                    return true;
                } else if (BizEnt.db.existsCBU(txtCBU.getText())) {
                    BizEnt.showERROR(this, "El CBU ingresado ya existe.");
                    return true;
                } else {
                    cuenta.setCBU(txtCBU.getText());
                }
            } else {
                cuenta.setCBU("");
            }
        }

        /* Estado de la cuenta */
        if (cmbStatus.getSelectedIndex() == 0) {
            cuenta.setStatus(false);
        } else {
            cuenta.setStatus(true);
        }

        /* Actualizamos el nombre de la cuenta */
        if (BizEnt.db.updateCuenta(cuenta)) {
            BizEnt.showERROR(this, "La cuenta no pudo ser actualizada.");
        }

        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCBU;
    private javax.swing.JTextField txtCBU;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
