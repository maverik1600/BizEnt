package bizent;

import java.sql.*;
import java.util.*;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ggmoy
 */
public final class SQLiteDB implements Database {
    private DateFormat                   dateFormat            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private CuentasTableModel            cuentasTableModel     = new CuentasTableModel();
    private MovimientosTableModel        movimientosTableModel = new MovimientosTableModel();
    private DefaultTreeModel             categoriasTreeModel   = new DefaultTreeModel(new DefaultMutableTreeNode());
    private DefaultComboBoxModel<Cuenta> cuentasComboBoxModel  = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<TipoInversion> tiposInversionComboBoxModel  = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<TipoInteres> tiposInteresComboBoxModel  = new DefaultComboBoxModel<>();
    private VencimientosTableModel        vencimientosTableModel = new VencimientosTableModel();
    private DefaultTableModel            inversionesTableModel = new InversionesTableModel (new Object[0][0], new Object[0]);
    private String     driver = "org.sqlite.JDBC";
    private String     dbname;
    private Connection conn;


    /* Constructor */
    public SQLiteDB(String dbname) throws ClassNotFoundException, SQLException {
        this.dbname = dbname;

        /* Load the driver and connect to the database */
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbname + ".biz");
        } catch (ClassNotFoundException|SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public boolean createTables() {
        String query;

        query = "CREATE TABLE cuentas (id     INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                      "fecha  DATETIME NOT NULL, " +
                                      "nombre CHAR(30) NOT NULL, " +
                                      "status BOOLEAN  NOT NULL, " +
                                      "cbu    CHAR(22) NOT NULL, " +
                                      "saldo  DOUBLE   NOT NULL)";
        if (executeUpdate(query)) { return true; }

        /**
         * Movimientos
         */
        query = "CREATE TABLE movimientos (id       INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                          "idMovRel INTEGER,           " +
                                          "idCuenta INTEGER  NOT NULL, " +
                                          "idCateg  INTEGER  NOT NULL, " +
                                          "fecha    DATETIME NOT NULL, " +
                                          "descri   CHAR(30) NOT NULL, " +
                                          "monto    DOUBLE   NOT NULL)";
        if (executeUpdate(query)) { return true; }

        
        /*
         * Vencimientos
         */
        
        query = "CREATE TABLE vencimientos (id     INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                      "idCateg  INTEGER  NOT NULL, " +
                                      "nombre CHAR(30) NOT NULL, " +
                                      "monto  DOUBLE NOT NULL," +
                                      "fecha  DATE NOT NULL, " +
                                      "registrado BOOLEAN  NOT NULL, " +
                                      "diasAnticip  DATETIME)";
        if (executeUpdate(query)) { return true; }
        
        /**
         * Tabla Categorías
         */
        query = "CREATE TABLE categorias (id     INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         "pid    INTEGER NOT NULL, "   +
                                         "nombre CHAR(30) NOT NULL)";
        if (executeUpdate(query)) { return true; }

        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (1, 0, 'Categorías')"))  { return true; }
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (2, 1, 'Egresos')"))     { return true; }
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (3, 1, 'Ingresos')"))    { return true; }
        //if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (4, 1, 'Inversiones')")) { return true; }

        /* Transferencias */
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (5, 2, 'Transferencia')")) { return true; }
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (6, 3, 'Transferencia')")) { return true; }

        /* Inversiones pid = 4 */
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (50, 2, 'Plazo Fijo')"))    { return true; } //Egresos
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (51, 3, 'Plazo Fijo')"))    { return true; } //Ingresos

        /**
         * Egresos pid = 2
         */
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (1000, 2, 'Educación')"))     { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (1000,    'Primaria')"))      { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (1000,    'Secundaria')"))    { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (1000,    'Universitaria')")) { return true; }

        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (2000, 2, 'Impuestos')")) { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (2000,    'Municipal')")) { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (2000,    'ARBA')"))      { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (2000,    'Rentas')"))    { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (2000,    'Patentes')"))  { return true; }

        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (3000, 2, 'Servicios')"))    { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (3000,    'Gas Natural')"))  { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (3000,    'Electricidad')")) { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (3000,    'Teléfono')"))     { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (3000,    'Internet')"))     { return true; }

        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (4000, 2, 'Supermercado')"))          { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (4000,    'Comestibles')"))           { return true; }
        if (executeUpdate("INSERT INTO categorias (pid, nombre)     values (4000,    'Artículos de Limpieza')")) { return true; }

        /**
         * Ingresos pid = 3
         */
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (5000, 3, 'Sueldos')"))    { return true; }
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (6000, 3, 'Alquileres')")) { return true; }
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (7000, 3, 'Regalos')"))    { return true; }
        if (executeUpdate("INSERT INTO categorias (id, pid, nombre) values (8000, 3, 'Regalos')"))    { return true; }

        
        /****************************************************************
         * 
         *                 MÓDULO DE INVERSIONES
         *    
         * Responsable: Nahuel.
         ****************************************************************/
         /*
          * Tablas:
          * -Inversiones
          * -TiposInversiones
          * -CostosInversiones
          * -InteresesInversiones
          * -TiposInteres
          * -FactorAjusteInversiones
          * -TiposIndicadores
          * -CobrosPorInversiones
          */
        
         /**
         * Tabla Inversiones
         */        
       query = "CREATE TABLE inversiones (idInv             INTEGER   PRIMARY KEY AUTOINCREMENT, " + ""+
                                          "descripcion      CHAR(120),          " +
                                          "idTipoInv        INTEGER   NOT NULL, " +
                                          "fechaCreacion    DATETIME  NOT NULL, " +
                                          "inversionInicial DOUBLE    NOT NULL, " +
                                          "fechaVencimiento DATETIME,           " +
                                          "idMovSrc         INTEGER   NOT NULL)";
        if (executeUpdate(query)) { return true; }      
        
        
         /**
         * Tabla TiposInversiones
         */        
        query = "CREATE TABLE tiposInversiones (idTipoInv    INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                                "descripcion CHAR(120) NOT NULL       )";
        if (executeUpdate(query)) { return true; }
        
        if (executeUpdate("INSERT INTO tiposInversiones (idTipoInv, descripcion) values (1, 'Plazo Fijo Tradicional')"))     { return true; }
        
         /**
         * Tabla CostosInversiones
         */
        
       query = "CREATE TABLE costosInversiones (idCostInv         INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                                "idInv            INTEGER   NOT NULL, " +
                                                "monto            DOUBLE    NOT NULL, " +
                                                "fecha            DATETIME  NOT NULL, " +
                                                "descripcion      CHAR(120) NOT NULL )";
       
        if (executeUpdate(query)) { return true; }   
        
         /**
         * Tabla InteresesInversiones
         */
        
       query = "CREATE TABLE interesesInversiones (idIntInv    INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                                  "idInv       INTEGER   NOT NULL, " +
                                                  "tasaInteres DOUBLE    NOT NULL, " +
                                                  "idTipoInt   INTEGER,            " + 
                                                  "periodos    INTEGER            )";
       
        if (executeUpdate(query)) { return true; }   
        
         /**
         * Tabla TiposInteres
         */   
        
       query = "CREATE TABLE tiposInteres (idTipoInt   INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                          "abreviatura CHAR(30) NOT NULL," +
                                          "descripcion CHAR(120)        )";
       
        if (executeUpdate(query)) { return true; }  
        
        if (executeUpdate("INSERT INTO tiposInteres (idTipoInt, abreviatura, descripcion) values (1, 'TNA', 'Tasa Nominal Anual')"))     { return true; }
        if (executeUpdate("INSERT INTO tiposInteres (idTipoInt, abreviatura, descripcion) values (2, 'TEA', 'Tasa Efectiva Anual')"))     { return true; }
         
        /**
         * Tabla FactorAjusteInversiones
         */   
        
       query = "CREATE TABLE factorAjusteInversiones (idFactAjustInv       INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                                     "idInv                INTEGER NOT NULL ," +
                                                     "indicadorInicio      DOUBLE  NOT NULL ," +
                                                     "indicadorActualizado DOUBLE,           " +
                                                     "factorAjuste         DOUBLE,           " +
                                                     "idTipoInd            INTEGER NOT NULL )";
       
        if (executeUpdate(query)) { return true; }  
        
         /**
         * Tabla TiposIndicadores
         */   
                
       query = "CREATE TABLE tiposIndicadores (idTipoInd    INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                               "abreviatura CHAR(30) NOT NULL ," +
                                               "descripcion CHAR(120)         )";
       
        if (executeUpdate(query)) { return true; }  
        
        if (executeUpdate("INSERT INTO tiposIndicadores (idTipoInd, abreviatura, descripcion) values (1, 'CER', 'Coeficiente de Estabilizacion de Referencia')"))     { return true; }
        
         /**
         * Tabla CobrosPorInversiones
         */   
        
       query = "CREATE TABLE cobrosPorInversiones (idCobrosInv INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                                                  "idInv       INTEGER   NOT NULL ," +
                                                  "fechaCobro  DATETIME  NOT NULL ," +
                                                  "monto       DOUBLE    NOT NULL ," +
                                                  "idMovDst    INTEGER            )";
       
        if (executeUpdate(query)) { return true; }  
        return false;
    }

    @Override
    public boolean insertCuenta(Cuenta cuenta) {
        String query = "INSERT INTO cuentas (fecha, nombre, status, cbu, saldo) " +
                                    "VALUES (" + cuenta.getSQLInsertValues() + ")";

        if (executeUpdate(query)) {
            return true;
        }

        updateCuentasTableModel();
        updateCuentasComboBoxModel();

        /* Insertamos la nueva cuenta */
        insertMovimiento(new Movimiento(0, 0, getCuentaLastIns(), getCategoria(3), cuenta.getFecha(), "Saldo Inicial", cuenta.getSaldo()));
        
        return false;
    }

    @Override
    public boolean updateCuenta(Cuenta cuenta) {
        String query = "UPDATE cuentas set nombre = '" + cuenta.getNombre() + "', " +
                                          "status = "  + (cuenta.getStatus() ? 1 : 0) + ", "  +
                                             "cbu = '" + cuenta.getCBU() + "', " +
                                           "saldo = "  + cuenta.getSaldo() +
                       " WHERE id = " + cuenta.getId();

        if (executeUpdate(query)) {
            return true;
        }

        updateCuentasTableModel();
        updateCuentasComboBoxModel();

        return false;
    }

    @Override
    public boolean existsCuenta(String nombre) {
        boolean found = false;
        String  query = "SELECT 1 FROM cuentas WHERE nombre = '" + nombre + "'";

        try {
            found = executeQuery(query).next();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        return found;
    }

    @Override
    public Cuenta getCuenta(int id) {
        Cuenta     cuenta = null;
        ResultSet  rset   = executeQuery("SELECT * FROM cuentas WHERE id = " + id);

        try {
            rset.next();
            cuenta = new Cuenta(id,
                                dateFormat.parse(rset.getString("fecha")),
                                rset.getString("nombre"),
                                rset.getBoolean("status"),
                                rset.getString("cbu"),
                                rset.getDouble("saldo"));
        } catch (ParseException | SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
        }

        return cuenta;
    }
    private Cuenta getCuentaLastIns() {
        Cuenta    cuenta = null;
        ResultSet rset   = executeQuery("SELECT max(id) FROM cuentas");

        try {
            rset.next();
            cuenta = getCuenta(rset.getInt(1));
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
        }

        return cuenta;
    }

    @Override
    public Movimiento getMovimiento(int id) {
        Movimiento movimiento = null;
        ResultSet  rset       = executeQuery("SELECT * FROM movimientos WHERE id = " + id);

        try {
            rset.next();

            movimiento = new Movimiento(rset.getInt("id"),
                                        rset.getInt("idMovRel"),
                                        getCuenta(rset.getInt("idCuenta")),
                                        getCategoria(rset.getInt("idCateg")),
                                        dateFormat.parse(rset.getString("fecha")),
                                        rset.getString("descri"),
                                        rset.getDouble("monto"));
        } catch (ParseException | SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
        }

        return movimiento;
    }
    private Movimiento getMovimientoLastIns() {
        Movimiento movimiento = null;
        ResultSet  rset       = executeQuery("SELECT max(id) FROM movimientos");

        try {
            rset.next();
            movimiento = getMovimiento(rset.getInt(1));
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
        }

        return movimiento;
    }
    
    
    @Override
    public boolean deleteCategoria(Categoria categ) {
        String query = "DELETE FROM categorias WHERE id = " + categ.getId();

        if (executeUpdate(query)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insertCategoria(Categoria categ) {
        String query = "INSERT INTO categorias (pid, nombre) " +
                                       "VALUES (" + categ.getSQLInsertValues() + ")";

        if (executeUpdate(query)) {
            return true;
        }

        try {
            ResultSet rset = executeQuery("SELECT MAX(id) FROM categorias");
            rset.next();
            categ.setId(rset.getInt(1));
            System.out.println("Nueva categoría: " + categ.getId());
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            return true;
        }

        return false;
    }

    @Override
    public Categoria getCategoria(int id) {
        Categoria categ = null;
        ResultSet rset  = executeQuery("SELECT * FROM categorias WHERE id = " + id);

        try {
            rset.next();
            categ = new Categoria(rset.getInt("id"),
                                  rset.getInt("pid"),
                                  rset.getString("nombre"));
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        return categ;
    }

    @Override
    public boolean editCategoria(Categoria categ) {
        String query = "UPDATE categorias set nombre = '" + categ.getName() + "' WHERE id = " + categ.getId();

        if (executeUpdate(query)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsCategoria(Categoria categ) {
        boolean found = false;
        String query  = "SELECT 1 FROM categorias WHERE pid    = "  + categ.getPid()    + " AND " +
                                                       "nombre = '" + categ.getName() + "'";

        try {
            found = executeQuery(query).next();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        return found;
    }

    @Override
    public boolean existsCBU(String cbu) {
        boolean found = false;
        String  query = "SELECT cbu FROM cuentas WHERE cbu = '" + cbu + "'";

        try {
            found = executeQuery(query).next();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        return found;
    }

    @Override
    public TableModel getCuentasTableModel()    { return cuentasTableModel; }
    public void       updateCuentasTableModel() {
        ResultSet rset = executeQuery("SELECT id FROM cuentas ORDER BY nombre");

        try {
            cuentasTableModel.clear();
            while (rset.next()) {
                cuentasTableModel.addRow(getCuenta(rset.getInt("id")).getArray());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    @Override
    public DefaultTreeModel getCategoriasTreeModel() { return categoriasTreeModel; }
    public DefaultTreeModel createCategoriasTreeModel() {
        ResultSet rset = executeQuery("SELECT id FROM categorias ORDER BY pid, nombre");

        try {
            while (rset.next()) {
                Categoria categ = getCategoria(rset.getInt("id"));

                if (categ.getPid() == 0) {
                    ((DefaultMutableTreeNode) categoriasTreeModel.getRoot()).setUserObject(categ);
                } else {
                    Enumeration e = ((DefaultMutableTreeNode) categoriasTreeModel.getRoot()).depthFirstEnumeration();
                    while(e.hasMoreElements()) {
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) e.nextElement();

                        if (((Categoria) parentNode.getUserObject()).getId() == categ.getPid()) {
                            parentNode.add(new DefaultMutableTreeNode(categ));
                       }
                   }
                }
            }
        } catch (SQLException e ) {
            System.out.println("ERROR");
        }

        return categoriasTreeModel;
    }

    @Override
    public  DefaultComboBoxModel<Cuenta> getCuentasComboBoxModel()    { return cuentasComboBoxModel; }
    private void                         updateCuentasComboBoxModel() {
        ResultSet rset = executeQuery("SELECT id FROM cuentas ORDER BY nombre");

        cuentasComboBoxModel.removeAllElements();
        try {
            while (rset.next()) {
                cuentasComboBoxModel.addElement(getCuenta(rset.getInt("id")));
            }
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public DefaultComboBoxModel<Cuenta> getCuentasCmbModel()  {
        DefaultComboBoxModel<Cuenta> cuentasCmbModel  = new DefaultComboBoxModel<>();
        ResultSet rset = executeQuery("SELECT id FROM cuentas WHERE status = 1 ORDER BY nombre");

        cuentasCmbModel.removeAllElements();
        try {
            while (rset.next()) {
                cuentasCmbModel.addElement(getCuenta(rset.getInt("id")));
            }
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
        
        return cuentasCmbModel;
    }

    @Override
    public boolean insertMovimiento(Movimiento movimiento) {
        String query = "INSERT INTO movimientos (idMovRel, idCuenta, idCateg, fecha, descri, monto) " +
                                        "VALUES (" + movimiento.getSQLInsertValues() + ")";

        if (executeUpdate(query)) {
            return true;
        } else {
            movimiento.setId(getMovimientoLastIns().getId());
        }
        updateMovimientosTableModel(movimiento.getCuenta());

        /* Actualizo la cuenta */
        Cuenta cuenta = movimiento.getCuenta();
        if (esIngreso(movimiento.getCategoria().getId())) {
            cuenta.setSaldo(cuenta.getSaldo() + movimiento.getMonto());
        } else {
            cuenta.setSaldo(cuenta.getSaldo() - movimiento.getMonto());
        }
        updateCuenta(cuenta);

        return false;
    }

    @Override
    public boolean updateMovimiento(Movimiento newMovimiento) {
        Movimiento oldMovimiento = BizEnt.db.getMovimiento(newMovimiento.getId());
        Cuenta     cuenta        = newMovimiento.getCuenta();
        String     query         = "UPDATE movimientos set idCateg = "  + newMovimiento.getCategoria().getId() + ", " +
                                                           "descri = '" + newMovimiento.getDescri() + "', " +
                                                           "fecha = '" + new Timestamp(newMovimiento.getFecha().getTime()) + "', " +
                                                           "monto = "  + newMovimiento.getMonto() + ", " +
                                                           "idMovRel = "  + newMovimiento.getIdMovRel() + ", " +
                                                           "idCuenta = "  + newMovimiento.getCuenta().getId() +
                                   " WHERE id = " + newMovimiento.getId();

        /* Actualizo el movimiento */
        if (executeUpdate(query)) {
            return true;
        }
        updateMovimientosTableModel(newMovimiento.getCuenta());

        if (newMovimiento.getCuenta().getId() == oldMovimiento.getCuenta().getId()) {
            /* Actualizo la cuenta */
            if (esIngreso(oldMovimiento.getCategoria().getId()) == esIngreso(newMovimiento.getCategoria().getId())) {
                if (oldMovimiento.getMonto() != newMovimiento.getMonto()) {
                    if (esIngreso(newMovimiento.getCategoria().getId())) {
                        cuenta.setSaldo(cuenta.getSaldo() - oldMovimiento.getMonto());
                        cuenta.setSaldo(cuenta.getSaldo() + newMovimiento.getMonto());
                    } else {
                        cuenta.setSaldo(cuenta.getSaldo() + oldMovimiento.getMonto());
                        cuenta.setSaldo(cuenta.getSaldo() - newMovimiento.getMonto());
                    }
                    updateCuenta(cuenta);
                }
            } else {
                if (esIngreso(oldMovimiento.getCategoria().getId())) {
                    cuenta.setSaldo(cuenta.getSaldo() - oldMovimiento.getMonto());
                    cuenta.setSaldo(cuenta.getSaldo() - newMovimiento.getMonto());
                } else {
                    cuenta.setSaldo(cuenta.getSaldo() + oldMovimiento.getMonto());
                    cuenta.setSaldo(cuenta.getSaldo() + newMovimiento.getMonto());
                }
                updateCuenta(cuenta);
            }
        } else {
            /* Actualizo la vieja */
            cuenta = BizEnt.db.getCuenta(oldMovimiento.getCuenta().getId());
            if (esIngreso(oldMovimiento.getCategoria().getId())) {
                cuenta.setSaldo(cuenta.getSaldo() - oldMovimiento.getMonto());
System.out.println("Le resto a cuenta: " + cuenta.getNombre() + " $" + oldMovimiento.getMonto());
            } else {
                cuenta.setSaldo(cuenta.getSaldo() + oldMovimiento.getMonto());
System.out.println("Le sumo a cuenta: " + cuenta.getNombre() + " $" + oldMovimiento.getMonto());
            }
            updateCuenta(cuenta);

            /* Actualizo la nueva */
            cuenta = BizEnt.db.getCuenta(newMovimiento.getCuenta().getId());
            if (esIngreso(newMovimiento.getCategoria().getId())) {
                cuenta.setSaldo(cuenta.getSaldo() + newMovimiento.getMonto());
System.out.println("Le sumo a cuenta: " + cuenta.getNombre() + " $" + newMovimiento.getMonto());
            } else {
                cuenta.setSaldo(cuenta.getSaldo() - newMovimiento.getMonto());
System.out.println("Le resto a cuenta: " + cuenta.getNombre() + " $" + newMovimiento.getMonto());
            }
            updateCuenta(cuenta);
System.out.println(BizEnt.db.getCuenta(newMovimiento.getCuenta().getId()).getSaldo() + " | " + BizEnt.db.getCuenta(oldMovimiento.getCuenta().getId()).getSaldo());
        }

        return false;
    }
    
    @Override
    public boolean deleteMovimiento(Movimiento movimiento) {
        String query = "DELETE FROM movimientos WHERE id = " + movimiento.getId();
        if (executeUpdate(query)) {
            return true;
        }
        updateMovimientosTableModel(movimiento.getCuenta());

        /* Actualizo la cuenta */
        Cuenta cuenta = movimiento.getCuenta();
        if (esIngreso(movimiento.getCategoria().getId())) {
            cuenta.setSaldo(cuenta.getSaldo() - movimiento.getMonto());
        } else {
            cuenta.setSaldo(cuenta.getSaldo() + movimiento.getMonto());
        }
        updateCuenta(cuenta);

        return false;
    }

    @Override
    public TableModel getMovimientosTableModel() { return movimientosTableModel; }
    public void       updateMovimientosTableModel(Cuenta cuenta) { updateMovimientosTableModel(cuenta, null); }
    public void       updateMovimientosTableModel(Cuenta cuenta, DefaultMutableTreeNode node) {
        Movimiento movimiento;
        double     saldo  = 0;
        Object     data[] = new Object[movimientosTableModel.getColumnCount()];
        String     query  = "SELECT id FROM movimientos WHERE idCuenta = " + cuenta.getId();

        /* What categories to include */
        if (node != null) {
            String path = "";
            Enumeration<DefaultMutableTreeNode> e = node.depthFirstEnumeration();
            while (e.hasMoreElements()) {
                if (!path.equals("")) { path += ", "; }
                path += ((Categoria) e.nextElement().getUserObject()).getId();
            }
            query += " AND idCateg IN (" + path + ")";
        }

        /* Fill rows */
        ResultSet rset = executeQuery(query + " ORDER BY fecha");
        try {
            movimientosTableModel.clear();
            while (rset.next()) {
                movimiento = getMovimiento(rset.getInt("id"));
                data[0] = movimiento.getId();
                data[1] = movimiento.getFecha();
                data[2] = movimiento.getCategoria().getName();
                data[3] = movimiento.getDescri();

                if (esIngreso(movimiento.getCategoria().getId())) {
                    data[4] = movimiento.getMonto();
                    data[5] = 0d;
                    saldo  += movimiento.getMonto();
                } else {
                    data[4] = 0d;
                    data[5] = movimiento.getMonto();
                    saldo  -= movimiento.getMonto();
                }

                data[6] = saldo;
                movimientosTableModel.addRow(data);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    @Override
    public boolean esIngreso(int idCateg) {
        boolean retVal = false;

        if (idCateg > 3) {
            ResultSet rset = executeQuery("SELECT pid FROM categorias WHERE id = " + idCateg);
            try {
                rset.next();
                retVal = esIngreso(rset.getInt("pid"));
            } catch (SQLException ex) {
                System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            }            
        } else if (idCateg == 3) {
            retVal = true;
        } else if (idCateg == 2) {
            retVal = false;
        }

        return retVal;
   } 

    
        
  public boolean insertVencimiento(Vencimiento v) {
      
      String query = "INSERT INTO vencimientos (idCateg,nombre, monto, fecha, registrado, diasAnticip) " +
                                    "VALUES (" + v.getSQLInsertValues() + ")";


        if (executeUpdate(query)==false) {
            updateVencimientosTableModel();
            PantallaVencimientos.setLabel("Todos los vencimientos:");
            Calendario.resetearColores();
            return true;
        }
        return false;
    }


    public boolean updateVencimiento(Vencimiento v) {
        String query;
  if(v.getDiasAnticip()!=null)
  {
        query = "UPDATE vencimientos set nombre = '" + v.getNombre() + "', " +
                                          "idCateg = '"  + (v.getIdCateg()) + "', "  +
                                          "fecha = '"+ (v.getTime(v.getFecha())) + "', "  +
                                          "registrado = '"+ (v.getRegistrado()) +"', "  +
                                          "diasAnticip = '"  + (v.getTime(v.getDiasAnticip())) + "', "  +
                                          "monto  = '" + v.getMonto()  + "' WHERE id = " + v.getId();
      
  }
  else
        {
        query = "UPDATE vencimientos set nombre = '" + v.getNombre() + "', " +
                                          "idCateg = '"  + (v.getIdCateg()) + "', "  +
                                          "fecha = '"+ (v.getTime(v.getFecha()))+"', "  +
                                          "registrado = "+(v.getRegistrado()) +", "  +
                                          "diasAnticip = null, "  +
                                          "monto  = " + v.getMonto()  + " WHERE id = " + v.getId();

  }
        if (executeUpdate(query))
        {
            updateVencimientosTableModel();
            PantallaVencimientos.setLabel("Todos los vencimientos:");
            Calendario.resetearColores();
            return true;
        }
        updateVencimientosTableModel();
        PantallaVencimientos.setLabel("Todos los vencimientos:");
        Calendario.resetearColores();
        return false;
    }
    
        public Vencimiento getVencimiento(int id) {
        Vencimiento v= null;
        ResultSet  rset   = executeQuery("SELECT * FROM vencimientos WHERE id = " + id);

        try {
            rset.next();
            
            v =new Vencimiento(id);
            v.setCateg(rset.getInt("idCateg"));
            v.setFecha(dateFormat.parse(rset.getString("fecha")));
            v.setNombre(rset.getString("nombre"));
            v.setMonto(rset.getDouble("monto"));
            v.setRegistrado(rset.getBoolean("registrado"));//dateFormat.parse(rset.getString("fecha")));
            
            if (rset.getString("diasAnticip")!=null)
            {
                v.setDiasAnticip(dateFormat.parse(rset.getString("diasAnticip")));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
        } catch (ParseException ex) {
            //Logger.getLogger(SQLiteDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v;
    }


    public TableModel getVencimientosTableModel()    {
        if(vencimientosTableModel==(null))
        {
            System.out.print("tabla null");
        }  
        return vencimientosTableModel; }
    
    public void updateVencimientosTableModel() {
       ResultSet  rset   = executeQuery("SELECT id FROM vencimientos order by fecha");
        try {
            vencimientosTableModel.clear();
            while (rset.next()) {
                int a=rset.getInt("id");
                vencimientosTableModel.addRow(getVencimiento(a).getArray());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
    public void updateVencimientosTableModel(java.util.Date f, java.util.Date e) {
        ResultSet  rset   = executeQuery("SELECT * FROM vencimientos WHERE fecha between '"+new Timestamp(f.getTime())+"' AND '"+new Timestamp(e.getTime())+"' order by fecha");//'"+f.get(Calendar.YEAR)+"-"+f.get(Calendar.MONTH)+"-"+f.get(Calendar.DATE)+"'");
        try {
            vencimientosTableModel.clear();
            while (rset.next()) {
                int a=rset.getInt("id");
                
                vencimientosTableModel.addRow(getVencimiento(a).getArray());
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
    
        public void updateVencimientosTableModel(Calendar f) {
            f.set(Calendar.HOUR_OF_DAY, 0);
            f.set(Calendar.MINUTE, 0);
            f.set(Calendar.SECOND, 0);
            f.set(Calendar.MILLISECOND, 0);
            java.util.Date d= f.getTime();
            f.set(Calendar.HOUR_OF_DAY, 23);
            f.set(Calendar.MINUTE, 59);
            f.set(Calendar.SECOND, 59);
            f.set(Calendar.MILLISECOND, 999);
            String ab="SELECT * FROM vencimientos WHERE fecha between '"+new Timestamp(d.getTime())+"' AND '"+new Timestamp(f.getTime().getTime())+"' order by fecha";
            
        ResultSet  rset   = executeQuery(ab);
        try {
            vencimientosTableModel.clear();
            while (rset.next()) {
                int a=rset.getInt("id");
                
                vencimientosTableModel.addRow(getVencimiento(a).getArray());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
    
    public String[] getAlertasVencimientos() {
        String[] s=new String[2];
        Calendar f= Calendar.getInstance();
            f.set(Calendar.HOUR_OF_DAY, 23);
            f.set(Calendar.MINUTE, 59);
            f.set(Calendar.SECOND, 59);
            f.set(Calendar.MILLISECOND, 999);
            java.util.Date d= f.getTime();
            f.set(Calendar.HOUR_OF_DAY, 0);
            f.set(Calendar.MINUTE, 0);
            f.set(Calendar.SECOND, 0);
            f.set(Calendar.MILLISECOND, 0);
            f.add(Calendar.DATE, 1);
            String prox="";
            String venc="";
            Vencimiento v;
            Calendar c= Calendar.getInstance();
            //String ab="SELECT * FROM vencimientos WHERE diasAnticip < '"+new Timestamp(d.getTime())+"' AND diasAnticip not NULL";
        String ab="SELECT * FROM vencimientos WHERE diasAnticip < '"+new Timestamp(d.getTime())+"' AND registrado = 0 AND fecha > '"+new Timestamp(f.getTime().getTime())+"' order by fecha";
        ResultSet  rset   = executeQuery(ab);
        
        try {
            while (rset.next()) {
                int a=rset.getInt("id");
                v=getVencimiento(a);
                c.setTime(v.getFecha());
                prox=prox+c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+"   "+v.getCateg()+": "+v.getNombre()+"\n";
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        
        //Vencimientos a Efectuar
        ab="SELECT * FROM vencimientos WHERE fecha < '"+new Timestamp(f.getTime().getTime())+"' AND registrado = 0 order by fecha";
        rset   = executeQuery(ab);
        try {
            while (rset.next()) {
                int a=rset.getInt("id");
                v=getVencimiento(a);
                c.setTime(v.getFecha());
                venc=venc+c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+"   "+v.getCateg()+": "+v.getNombre()+"\n";
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        s[0]=venc;
        s[1]=prox;
        return s;
    }
    
   public ArrayList <Calendar> getVencimientosMes(Calendar f) {
            f.set(Calendar.HOUR_OF_DAY, 0);
            f.set(Calendar.MINUTE, 0);
            f.set(Calendar.SECOND, 0);
            f.set(Calendar.MILLISECOND, 0);
            f.set(Calendar.DATE, 0);
            java.util.Date d= f.getTime();
            int b=(f.get(Calendar.MONTH)+1);
            f.set(Calendar.MONTH, b);
       
            String ab="SELECT fecha FROM vencimientos WHERE fecha between '"+new Timestamp(d.getTime())+"' AND '"+new Timestamp(f.getTime().getTime())+"' order by fecha";

            ArrayList <Calendar> v=new ArrayList <Calendar>();
            
        ResultSet  rset   = executeQuery(ab);
        try {
            while (rset.next()) {
            Calendar cal=Calendar.getInstance();
            cal.setTime(dateFormat.parse(rset.getString("fecha")));
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            v.add(cal);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
        } catch (ParseException ex) {
            //Logger.getLogger(SQLiteDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v;
    }
        
    public boolean deleteVencimiento(Vencimiento v) {
        String query = "DELETE FROM vencimientos WHERE id = " + v.getId();
        Calendario.resetearColores();
        if (executeUpdate(query)) {
            return true;
        }
        updateVencimientosTableModel();
        PantallaVencimientos.setLabel("Todos los vencimientos:");

        return false;
    }
    
    public boolean deleteVencimiento(int id) {
        String query = "DELETE FROM vencimientos WHERE id = " +id;
        if (executeUpdate(query)) {
            return true;
        }
        updateVencimientosTableModel();
        PantallaVencimientos.setLabel("Todos los vencimientos:");
        Calendario.resetearColores();

        return false;
    }
    
    @Override
    public void loadDataModels() {
        updateCuentasComboBoxModel();
        updateCuentasTableModel();
        updateVencimientosTableModel();
        updateInversionesTableModel();
        updateTiposInversionComboBoxModel();
        updateTiposInteresComboBoxModel();
        PantallaVencimientos.setLabel("Todos los vencimientos:");
    }

    private boolean executeUpdate(String query) {
        boolean error = false;

        try {
            conn.createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            error = true;
        }

        return error;
    }

    private ResultSet executeQuery(String query) {
        ResultSet rset = null;

        try {
            rset = conn.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        return rset;
    }
        
       
         /****************************************************************
         * 
         *                 MÓDULO DE INVERSIONES
         *    
         * Responsable: Nahuel.
         ****************************************************************/
         /*
          * Métodos:
          * public TableModel getInversionesTableModel()
          * public void updateInversionesTableModel() //arma la tabla para la solapa inversiones.
          * public DefaultComboBoxModel<TipoInversion> getTiposInversionComboBoxModel()
          */
    
    @Override
    public TableModel getInversionesTableModel() { return inversionesTableModel; }
    
    @Override
    public void updateInversionesTableModel() {
        int               rowsCount;
        Object[][]        data      = null;
        ArrayList<String> colNames  = new ArrayList<>();
        ResultSet         rset      = executeQuery("SELECT inversiones.idInv, inversiones.descripcion, tiposInversiones.descripcion, inversiones.fechaCreacion, inversiones.inversionInicial, inversiones.fechaVencimiento FROM inversiones INNER JOIN tiposInversiones ON inversiones.idTipoInv = tiposInversiones.idTipoInv");

        /* Set column names */
        colNames.add("ID");
        colNames.add("Descripción");
        colNames.add("Tipo de inversión");
        colNames.add("Fecha de creación");
        colNames.add("Inversión inicial");
        colNames.add("Vencimiento");

        /* Get number of rows */
        try {
            rowsCount = executeQuery("SELECT count(*) FROM inversiones").getInt(1);
            if (rowsCount > 0) {
                data = new Object[rowsCount][colNames.size()];
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        /* Fill rows */
        try {
            int i = 0;
            while (rset.next()) {
                data[i][0] = rset.getInt(1);
                data[i][1] = rset.getString(2);
                data[i][2] = rset.getString(3);
                data[i][3] = dateFormat.parse(rset.getString(4));
                data[i][4] = rset.getDouble(5);
                data[i][5] = dateFormat.parse(rset.getString(6));
                i++;
            }
        } catch (ParseException | SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        inversionesTableModel.setDataVector(data, colNames.toArray());
    }
    
    @Override
    public DefaultComboBoxModel<TipoInversion> getTiposInversionComboBoxModel(){return tiposInversionComboBoxModel;}
    public void updateTiposInversionComboBoxModel(){
        
        ResultSet rset = executeQuery("SELECT idTipoInv, descripcion FROM tiposInversiones ORDER BY descripcion");

        tiposInversionComboBoxModel.removeAllElements();
        
        try {
            while (rset.next()) {
                tiposInversionComboBoxModel.addElement(new TipoInversion(rset.getInt(1),rset.getString(2)));
            }
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
 
    }
    
    @Override
    public DefaultComboBoxModel<TipoInteres> getTiposInteresComboBoxModel(){ return tiposInteresComboBoxModel;}
    public void updateTiposInteresComboBoxModel()
    {
        
        ResultSet rset = executeQuery("SELECT idTipoInt, abreviatura, descripcion FROM tiposInteres");

        tiposInteresComboBoxModel.removeAllElements();
        
        try {
            while (rset.next()) {
                tiposInteresComboBoxModel.addElement(new TipoInteres(rset.getInt(1),rset.getString(2),rset.getString(2)));
            }
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
    }
    
    @Override
    public boolean insertInversion(Inversion inv)
    {
        
        /* Insert Movimiento */
        insertMovimiento(inv.getMovSrc());
        
        /* Insert Inversion */
        

        String query = "INSERT INTO inversiones (descripcion, idTipoInv, fechaCreacion, inversionInicial, fechaVencimiento, idMovSrc) " +
                           "VALUES (" + inv.getSQLInsertValues() +")";
        executeUpdate(query);

        /* ID de la inversion recientemente agregada */
        
        ResultSet rset = executeQuery("SELECT last_insert_rowid()");
        
        int idInv=-1;
        try{
            idInv = rset.getInt(1);
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
        
        
        /* Insert InteresesInversiones*/
 
        query = "INSERT INTO InteresesInversiones (idInv, tasaInteres, idTipoInt, periodos)" +
                        "VALUES (" + idInv + ", " + inv.getInteresesInv().get(0).getTasaInteres() + ", " + inv.getInteresesInv().get(0).getTipoInt().getIdTipoInt() + ", " + inv.getInteresesInv().get(0).getPeriodos() + ")";
        
        executeUpdate(query);

        
        /* insert CobrosPorInversiones */
        
        query = "INSERT INTO CobrosPorInversiones (idInv, fechaCobro, monto)" +
                        "VALUES (" + idInv + ", '" + new Timestamp(inv.getCobrosInv().get(0).getFechaCobro().getTime().getTime()) + "', " + inv.getCobrosInv().get(0).getMonto() + ")";
        
        executeUpdate(query);
 
        
        
        /* Rollback*/
        

        updateInversionesTableModel();
        
        return true;
    }
    
    public Inversion  getInversion(int idInv)
    {
        return new Inversion();
    }
    
    public ArrayList<CostoInversion> getCostosInv(int idInv)
    {
        return new ArrayList<CostoInversion>();
    }
    
    public ArrayList<InteresInversion> getInteresesInv(int idInv)
    {
        return new ArrayList<InteresInversion>();
    }
    
    public ArrayList<FactorAjusteInversion> getFactAjustInv(int idInv)
    {
        return new ArrayList<FactorAjusteInversion>();
    }
    
    public ArrayList<CobroPorInversion> getCobrosInv(int idInv)
    {
        ArrayList<CobroPorInversion> cobros = new ArrayList<CobroPorInversion>();
        
       ResultSet rset = executeQuery("SELECT idCobrosInv, fechaCobro, monto, idMovDst FROM CobrosPorInversiones WHERE idInv ="+ idInv);

        try {
            while (rset.next()) {
                
                Movimiento movDst = null;

                if(rset.getInt(4)!=0){
                    movDst = getMovimiento(rset.getInt(4));
                }
                
                Calendar cal=Calendar.getInstance();
                try{
                cal.setTime(dateFormat.parse(rset.getString(2)));
                } catch (SQLException ex) {
                System.err.println(ex.getClass().getName() + ": " + ex.getMessage());            
                } catch (ParseException ex) {
                 //Logger.getLogger(SQLiteDB.class.getName()).log(Level.SEVERE, null, ex);
                }

                cobros.add(new CobroPorInversion(rset.getInt(1),cal,rset.getDouble(3),movDst));
            }
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
        
        return cobros;
    }
    
    public boolean realizarCobroInv(CobroPorInversion cobroInv){
        
        /* Insert Movimiento */
        insertMovimiento(cobroInv.getMovDst());
        
        
        /* ID del movimiento recientemente agregado */
        
        ResultSet rset = executeQuery("SELECT last_insert_rowid()");
        
        int idMov=-1;
        try{
            idMov = rset.getInt(1);
        } catch (SQLException e ) {
            System.out.println("ERROR: " + e);
        }
        
        /* inserto el id del Movimiento, en idMovDst */
          
        String   query         = "UPDATE CobrosPorInversiones set idCobrosInv = "  + cobroInv.getIdCobrosInv() + ", " +
                                                           "fechaCobro = '" + new Timestamp(cobroInv.getFechaCobro().getTime().getTime()) + "', " +
                                                           "monto = " + cobroInv.getMonto() + ", " +
                                                           "idMovDst = "  + idMov +
                                   " WHERE idCobrosInv = " + cobroInv.getIdCobrosInv();
        executeUpdate(query);
        
        return true;
    }
}
