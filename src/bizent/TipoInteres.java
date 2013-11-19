/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

/**
 *
 * @author Nahuel
 */
public class TipoInteres {
     private int idTipoInt;
     private String abreviatura;
     private String descripcion;

    public TipoInteres(int idTipoInt, String abreviatura, String descripcion) {
        this.idTipoInt = idTipoInt;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public int getIdTipoInt() {
        return idTipoInt;
    }

    public void setIdTipoInt(int idTipoInt) {
        this.idTipoInt = idTipoInt;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     
     public String toString() { return getAbreviatura(); }
}
