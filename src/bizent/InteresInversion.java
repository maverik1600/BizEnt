/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

/**
 *
 * @author Nahuel
 */
public class InteresInversion {
    private int idIntInv;
    private double tasaInteres;
    private TipoInteres tipoInt;
    private int periodos;

    public InteresInversion(int idIntInv, double tasaInteres, TipoInteres tipoInt, int periodos) {
        this.idIntInv = idIntInv;
        this.tasaInteres = tasaInteres;
        this.tipoInt = tipoInt;
        this.periodos = periodos;
    }

    public int getIdIntInv() {
        return idIntInv;
    }

    public void setIdIntInv(int idIntInv) {
        this.idIntInv = idIntInv;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public TipoInteres getTipoInt() {
        return tipoInt;
    }

    public void setTipoInt(TipoInteres tipoInt) {
        this.tipoInt = tipoInt;
    }

    public int getPeriodos() {
        return periodos;
    }

    public void setPeriodos(int periodos) {
        this.periodos = periodos;
    }
    
    
}
