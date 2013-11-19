package bizent;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author ggmoy
 */
public class Cuenta {
    private int     id;
    private Date    fecha;
    private String  nombre;
    private boolean status;
    private String  cbu;
    private double  saldo;

    /* Constructores */
    public Cuenta(String nombre, double saldo) {
        this(nombre, true, "", saldo);
    }
    public Cuenta(String nombre, boolean status, String cbu, double saldo) {
        this(0, new Date(), nombre, status, cbu, saldo);
    }
    public Cuenta(int id, Date fecha, String nombre, boolean status, String cbu,  double saldo) {
        this.id     = id;
        this.fecha  = fecha;
        this.nombre = nombre;
        this.status = status;
        this.cbu    = cbu;
        this.saldo  = saldo;
    }

    /* Manejadores de ID */
    public int  getId()       { return this.id; }
    public void setId(int id) { this.id = id;   }

    /* Manejadores de Fecha */
    public Date getFecha()           { return this.fecha;  }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    /* Manejadores de Status */
    public String  getStatusString()         { return this.status ? "Habilitada" : "Deshabilitada"; }
    public boolean getStatus()               { return this.status;   }
    public void    setStatus(boolean status) { this.status = status; }

    /* Manejadores de Nombre */
    public String getNombre()              { return this.nombre; }
    public void   setNombre(String nombre) {
        if (nombre.length() > 30) {
            this.nombre = nombre.substring(1, 30);
        } else {
            this.nombre = nombre;
        }
    }

    /* Manejadores de CBU */
    public String getCBU()           { return this.cbu; }
    public void   setCBU(String cbu) {
        if (cbu.length() > 22) {
            this.cbu = cbu.substring(1, 22);
        } else {
            this.cbu = cbu;
        }
    }

    /* Manejadores de Saldo */
    public double getSaldo()             { return this.saldo;  }
    public void   setSaldo(double saldo) { this.saldo = saldo; }

    public String getAccountType() { return this.cbu.equals("") ? "Caja" : "Banco"; }

    @Override
    public String toString() { return getNombre(); }

    public String getSQLInsertValues() {
//        return "'" + new Timestamp(getFecha().getTime()) + "', '" + getNombre() + "', " + (getStatus() ? 1 : 0) + ", '" + getCBU() + "', " + getSaldo();
        return "'" + new Timestamp(getFecha().getTime()) + "', '" + getNombre() + "', " + (getStatus() ? 1 : 0) + ", '" + getCBU() + "', 0";
    }

    public Object[] getArray() {
        return new Object[] { this.getId(),
                              this.getFecha(),
                              this.getNombre(),
                              this.getAccountType(),
                              this.getStatusString(),
                              this.getSaldo()};
    }
}