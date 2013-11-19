/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;
import java.util.Calendar;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author Nahuel
 */
public class Inversion {
    
    private int                              idInv;
    private String                           descripcion;
    private TipoInversion                    tipoInv;
    private Calendar                         fechaCreacion;
    private double                           inversionInicial;  
    private Calendar                         fechaVencimiento;
    private Movimiento                       movSrc;
    private ArrayList<CostoInversion>        costosInv; /* ArrayList only have gets*/
    private ArrayList<InteresInversion>      interesesInv;
    private ArrayList<FactorAjusteInversion> factoresAjusteInv;
    private ArrayList<CobroPorInversion>     cobrosInv;
    
    public Inversion(){
        costosInv = new ArrayList<CostoInversion>();
        interesesInv = new ArrayList<InteresInversion>();
        factoresAjusteInv = new ArrayList<FactorAjusteInversion>();
        cobrosInv = new ArrayList<CobroPorInversion>();
    }

    public Inversion(int idInv, String descripcion, TipoInversion tipoInv, Calendar fechaCreacion, double inversionInicial, Calendar fechaVencimiento, Movimiento movSrc, Database db) {
        this.idInv = idInv;
        this.descripcion = descripcion;
        this.tipoInv = tipoInv;
        this.fechaCreacion = fechaCreacion;
        this.inversionInicial = inversionInicial;
        this.fechaVencimiento = fechaVencimiento;
        this.movSrc = movSrc;
        costosInv = new ArrayList<CostoInversion>();
        interesesInv = new ArrayList<InteresInversion>();
        factoresAjusteInv = new ArrayList<FactorAjusteInversion>();
        cobrosInv = new ArrayList<CobroPorInversion>();
    }

    public int getIdInv() {
        return idInv;
    }

    public void setIdInv(int idInv) {
        this.idInv = idInv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoInversion getTipoInv() {
        return tipoInv;
    }

    public void setTipoInv(TipoInversion tipoInv) {
        this.tipoInv = tipoInv;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getInversionInicial() {
        return inversionInicial;
    }

    public void setInversionInicial(double inversionInicial) {
        this.inversionInicial = inversionInicial;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Movimiento getMovSrc() {
        return movSrc;
    }

    public void setMovSrc(Movimiento movSrc) {
        this.movSrc = movSrc;
    }

    public ArrayList<CostoInversion> getCostosInv() {
        return costosInv;
    }

    public ArrayList<InteresInversion> getInteresesInv() {
        return interesesInv;
    }

    public ArrayList<FactorAjusteInversion> getFactoresAjusteInv() {
        return factoresAjusteInv;
    }

    public ArrayList<CobroPorInversion> getCobrosInv() {
        return cobrosInv;
    }
    
    public String getSQLInsertValues() {
        return "'"+getDescripcion() + "', " + tipoInv.getIdTipoInv() + ", '" + new Timestamp(getFechaCreacion().getTime().getTime()) + "', " +
                getInversionInicial() + ", '" + new Timestamp(getFechaVencimiento().getTime().getTime()) + "', " + movSrc.getId();
    }
    
//    public static double InteresSimplePorPeriodos (double capitalInicial, double interes, int periodos){
//        /* Capitalización simple:
//         * Los intereses que se producen en cada período no se acumulan para calcular los intereses 
//         * de períodos posteriores. Por lo tanto el interés se mantiene constante.
//         */
//        double capitalFinal;
//        
//        capitalFinal = capitalInicial*(1+interes*periodos);
//        
//        return capitalFinal;
//    }
    
    public static double InteresSimplePorDuracion (double capitalInicial, double interesAnual, int duracionDias){
        /* Capitalización simple:
         * Los intereses que se producen en cada período no se acumulan para calcular los intereses 
         * de períodos posteriores. Por lo tanto el interés se mantiene constante.
         */
        double capitalFinal;
        
        capitalFinal = capitalInicial*interesAnual*(duracionDias/365);
        
        return capitalFinal;
    }
 
}
