/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ggmoy
 */
public interface Database {
    public void    loadDataModels();
    public boolean createTables();
    public boolean insertCuenta(Cuenta cuenta);
    public boolean updateCuenta(Cuenta cuenta);
    public boolean existsCuenta(String nombre);
    public Cuenta  getCuenta(int id);

    /* Manejadores de Categorías */
    public boolean    insertCategoria(Categoria categ);
    public boolean    deleteCategoria(Categoria categ);
    public boolean    editCategoria(Categoria categ);
    public boolean    existsCategoria(Categoria categ);
    public Categoria  getCategoria(int id);

    public boolean              existsCBU(String cbu);
    public TableModel           getCuentasTableModel();
    public DefaultTreeModel     getCategoriasTreeModel();
    public DefaultTreeModel     createCategoriasTreeModel();
    public DefaultComboBoxModel<Cuenta> getCuentasComboBoxModel();
    public DefaultComboBoxModel<Cuenta> getCuentasCmbModel();

    public boolean    insertMovimiento(Movimiento movimiento);
    public boolean    updateMovimiento(Movimiento movimiento);
    public boolean    deleteMovimiento(Movimiento movimiento);
    public TableModel getMovimientosTableModel();
    public void       updateMovimientosTableModel(Cuenta cuenta);
    public void       updateMovimientosTableModel(Cuenta cuenta, DefaultMutableTreeNode node);
    public Movimiento getMovimiento(int id);

    public boolean esIngreso(int idCateg);
    
    public Vencimiento getVencimiento(int id);
    public boolean updateVencimiento(Vencimiento v);
    public boolean insertVencimiento(Vencimiento v);
    public boolean deleteVencimiento(Vencimiento v);
    public boolean deleteVencimiento(int id);
    public TableModel getVencimientosTableModel();
    public void updateVencimientosTableModel(Calendar f);
    public void updateVencimientosTableModel();
    public void updateVencimientosTableModel(java.util.Date f, java.util.Date e);
    public ArrayList <Calendar> getVencimientosMes(Calendar f);
    public String[] getAlertasVencimientos();
    
        /* ********************/
    /* Módulo Inversiones */
    /* ********************/
    
    /* GUI principal */
    public TableModel getInversionesTableModel();
    public void updateInversionesTableModel();
    public DefaultComboBoxModel<TipoInversion> getTiposInversionComboBoxModel();
    public DefaultComboBoxModel<TipoInteres> getTiposInteresComboBoxModel();
    
    /* Manejadores de Inversion */
    public boolean    insertInversion(Inversion inv);
//    public boolean    updateInversion(Inversion inv);
//    public boolean    deleteInversion(int idInv);
    public Inversion  getInversion(int idInv);
    
    public boolean realizarCobroInv(CobroPorInversion cobroInv);
    
    public ArrayList<CostoInversion> getCostosInv(int idInv);
    public ArrayList<InteresInversion> getInteresesInv(int idInv);
    public ArrayList<FactorAjusteInversion> getFactAjustInv(int idInv);
    public ArrayList<CobroPorInversion> getCobrosInv(int idInv);
    
}
