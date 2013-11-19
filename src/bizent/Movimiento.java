package bizent;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author ggmoy
 */
public class Movimiento {
    private int       id;
    private int       idMovRel;
    private Cuenta    cuenta;
    private Categoria categ;
    private Date      fecha;
    private String    descri;
    private double    monto;

    public Movimiento(int id, int idMovRel, Cuenta cuenta, Categoria categ, Date fecha, String descri, double monto) {
        this.id       = id;
        this.idMovRel = idMovRel;
        this.cuenta   = cuenta;
        this.categ    = categ;
        this.fecha    = fecha;
        this.descri   = descri;
        this.monto    = monto;
    }

    /* Manejadores de ID */
    public int  getId()       { return this.id; }
    public void setId(int id) { this.id = id;   }

    /* Manejadores de MovRel */
    public int  getIdMovRel()             { return this.idMovRel;   }
    public void setIdMovRel(int idMovRel) { this.idMovRel = idMovRel; }

    /* Manejadores de Cuenta */
    public Cuenta getCuenta()              { return this.cuenta;   }
    public void   setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    /* Manejadores de Categoría */
    public Categoria getCategoria()                { return this.categ;   }
    public void      setCategoria(Categoria categ) { this.categ = categ; }

    /* Manejadores de Fecha */
    public Date getFecha()           { return this.fecha;  }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    /* Manejadores de Descri */
    public String getDescri()              { return this.descri; }
    public void   setDescri(String descri) {
        if (descri.length() > 30) {
            this.descri = descri.substring(1, 30);
        } else {
            this.descri = descri;
        }
    }

    /* Manejadores de Monto */
    public double getMonto()             { return this.monto;  }
    public void   setMonto(double monto) { this.monto = monto; }

    public String getSQLInsertValues() {
        return  idMovRel + ", " + cuenta.getId() + ", " + categ.getId() + ", '" + new Timestamp(getFecha().getTime()) + "', '" +
                getDescri() + "', " + getMonto();
    }
}