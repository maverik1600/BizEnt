/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;
import java.util.Calendar;
/**
 *
 * @author Nahuel
 */
public class CostoInversion {
     private int idCostInv;
     private double monto;
     private Calendar fecha;
     private String descripcion;

    public CostoInversion(int idCostInv, double monto, Calendar fecha, String descripcion) {
        this.idCostInv = idCostInv;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getIdCostInv() {
        return idCostInv;
    }

    public void setIdCostInv(int idCostInv) {
        this.idCostInv = idCostInv;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     
     
}
