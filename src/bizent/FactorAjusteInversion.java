/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

/**
 *
 * @author Nahuel
 */
public class FactorAjusteInversion {
    private int idFactAjustInv;
    private double indicadorInicio;
    private double indicadorActualizado;
    private double factorAjuste;
    private TipoIndicador tipoInd;

    public FactorAjusteInversion(int idFactAjustInv, double indicadorInicio, double indicadorActualizado, double factorAjuste, TipoIndicador tipoInd) {
        this.idFactAjustInv = idFactAjustInv;
        this.indicadorInicio = indicadorInicio;
        this.indicadorActualizado = indicadorActualizado;
        this.factorAjuste = factorAjuste;
        this.tipoInd = tipoInd;
    }

    public int getIdFactAjustInv() {
        return idFactAjustInv;
    }

    public void setIdFactAjustInv(int idFactAjustInv) {
        this.idFactAjustInv = idFactAjustInv;
    }

    public double getIndicadorInicio() {
        return indicadorInicio;
    }

    public void setIndicadorInicio(double indicadorInicio) {
        this.indicadorInicio = indicadorInicio;
    }

    public double getIndicadorActualizado() {
        return indicadorActualizado;
    }

    public void setIndicadorActualizado(double indicadorActualizado) {
        this.indicadorActualizado = indicadorActualizado;
    }

    public double getFactorAjuste() {
        return factorAjuste;
    }

    public void setFactorAjuste(double factorAjuste) {
        this.factorAjuste = factorAjuste;
    }

    public TipoIndicador getTipoInd() {
        return tipoInd;
    }

    public void setTipoInd(TipoIndicador tipoInd) {
        this.tipoInd = tipoInd;
    }
    
    
}
