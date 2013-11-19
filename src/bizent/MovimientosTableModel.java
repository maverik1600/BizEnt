package bizent;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GustavoG
 */
public class MovimientosTableModel extends DefaultTableModel {
    Class[] types = new Class [] { java.lang.Integer.class,
                                   java.lang.Object.class,
                                   java.lang.Object.class,
                                   java.lang.Object.class,
                                   java.lang.Double.class,
                                   java.lang.Double.class,
                                   java.lang.Double.class };

    public MovimientosTableModel() {
        super();
        addColumn("ID");
        addColumn("Fecha");
        addColumn("Categoría");
        addColumn("Descripción");
        addColumn("Ingreso");
        addColumn("Egreso");
        addColumn("Saldo");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;               
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    public void clear() {
        while (this.getRowCount() > 0) {
            this.removeRow(0);
        }
    }
}
