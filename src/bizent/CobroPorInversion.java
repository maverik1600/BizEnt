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
public class CobroPorInversion {
    private int idCobrosInv;
    private Calendar fechaCobro;
    private double monto;
    private Movimiento movDst;

    public CobroPorInversion(int idCobrosInv, Calendar fechaCobro, double monto, Movimiento movDst) {
        this.idCobrosInv = idCobrosInv;
        this.fechaCobro = fechaCobro;
        this.monto = monto;
        this.movDst = movDst;
    }

    public int getIdCobrosInv() {
        return idCobrosInv;
    }

    public void setIdCobrosInv(int idCobrosInv) {
        this.idCobrosInv = idCobrosInv;
    }

    public Calendar getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Calendar fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Movimiento getMovDst() {
        return movDst;
    }

    public void setMovDst(Movimiento movDst) {
        this.movDst = movDst;
    }
    
    
}
