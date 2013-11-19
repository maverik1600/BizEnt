/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nahuel
 */
public class InversionesTableModel extends DefaultTableModel {
    Class[] types = new Class [] { java.lang.Integer.class, //"ID"
                                   java.lang.Object.class,  //"Descripción"
                                   java.lang.Object.class,  //"Tipo de inversión"
                                   java.lang.Object.class,  //"Fecha de creación"
                                   java.lang.Double.class,  //"Inversion inicial"
                                   java.lang.Object.class};  //"Vencimiento"
    
    public InversionesTableModel(Object[][] data, Object[] columns) {
        super(data, columns);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;               
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
}
