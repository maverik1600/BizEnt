/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

/**
 *
 * @author Nahuel
 */
public class TipoInversion {


    private int idTipoInv;
    private String descripcion;
    
    public TipoInversion(int idTipoInv, String descripcion) {
        this.idTipoInv = idTipoInv;
        this.descripcion = descripcion;
    }

    public int getIdTipoInv() {
        return idTipoInv;
    }

    public void setIdTipoInv(int idTipoInv) {
        this.idTipoInv = idTipoInv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String toString() { return getDescripcion(); }
}
