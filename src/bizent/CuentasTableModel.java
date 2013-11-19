package bizent;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ggmoy
 */
public class CuentasTableModel extends DefaultTableModel {
    Class[]  types    = new Class [] { java.lang.Integer.class,
                                       java.lang.Object.class,
                                       java.lang.Object.class,
                                       java.lang.Object.class,
                                       java.lang.Object.class,
                                       java.lang.Double.class };

    public CuentasTableModel() {
        super();
        addColumn("ID");
        addColumn("Fecha de creación");
        addColumn("Nombre de cuenta");
        addColumn("Tipo de cuenta");
        addColumn("Estado de cuenta");
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