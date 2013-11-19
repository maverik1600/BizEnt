/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

/**
 *
 * @author Nahuel
 */
public class TipoIndicador {
     private int idTipoInd;
     private String abreviatura;
     private String descripcion;

    public TipoIndicador(int idTipoInd, String abreviatura, String descripcion) {
        this.idTipoInd = idTipoInd;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public int getIdTipoInd() {
        return idTipoInd;
    }

    public void setIdTipoInd(int idTipoInd) {
        this.idTipoInd = idTipoInd;
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
