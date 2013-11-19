/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

/**
 *
 * @author ggmoy
 */
public class Categoria {
    private int    id;
    private int    pid;
    private String nombre;

    /* Constructores */
    public Categoria(String nombre) {
        this(0, nombre);
    }
    public Categoria(int pid, String nombre) {
        this(0, pid, nombre);
    }
    public Categoria(int id, int pid, String nombre) {
        setId(id);
        setPid(pid);
        setName(nombre);
    }

    /* Manejadores de ID */
    public int  getId()       { return this.id; }
    public void setId(int id) { this.id = id;   }

    /* Manejadores de PID */
    public int  getPid()        { return this.pid; }
    public void setPid(int pid) { this.pid = pid;  }

    /* Manejadores de Nombre */
    public String getName()              { return this.nombre; }
    public void   setName(String nombre) {
        if (nombre.length() > 30) {
            this.nombre = nombre.substring(1, 30);
        } else {
            this.nombre = nombre;
        }
    }

    @Override
    public String toString() { return getName(); }

    public String getSQLInsertValues() {
        return getPid() + ", '" + getName() + "'";
    }
}
