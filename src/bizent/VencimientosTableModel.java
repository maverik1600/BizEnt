package bizent;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suri
 */
public class VencimientosTableModel extends DefaultTableModel {
    Class[] types = new Class [] { java.lang.Integer.class,
                                   java.lang.Object.class,
                                   java.lang.String.class,
                                   java.lang.Double.class,
                                   java.util.Calendar.class//,
                                   //java.lang.Boolean.class,
                                   //java.util.Calendar.class
    };

    public VencimientosTableModel() {
        super();
        addColumn("Id");
        addColumn("Categoría");
        addColumn("Nombre");
        addColumn("Monto");
        addColumn("Fecha");
        //addColumn("Registrado");
        //addColumn("Primer Aviso");
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
