/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import java.sql.Timestamp;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author suri
 */
public class Vencimiento {
    
    private int id;
    private Categoria categ;
    private String nombre;
    private double monto;
   //private Calendar fecha;
    private Date fecha;
    private boolean registrado;
    private Date diasAnticip;
    
    
    public Vencimiento(int id) {
        this.id = id;
        this.categ = null;
        this.nombre = " ";
        this.monto = 0;
        //this.fecha = Calendar.getInstance();
        Date fecha=Calendar.getInstance().getTime();
        this.registrado = false;
        this.diasAnticip = null;
    }
/*
    public Vencimiento(int id, Categoria categ, String nombre, double monto, Calendar fecha, boolean registrado, Calendar diasAnticip) {
        this.id = id;
        this.categ = categ;
        this.nombre = nombre;
        this.monto = monto;
        this.fecha = fecha;
        this.registrado = registrado;
        this.diasAnticip = diasAnticip;
    }
  */  
        public Vencimiento(int id, int categId, String nombre, double monto, Date fecha, boolean registrado, Date diasAnticip) {
        this.id = id;
        //this.categ = categ;
        this.nombre = nombre;
        this.monto = monto;
        this.fecha = fecha;
        this.registrado = registrado;
        if(diasAnticip==null)
        {
            this.diasAnticip=null;
        }
        else
        {/*
            this.diasAnticip=Calendar.getInstance();
             this.diasAnticip.setTime(diasAnticip);*/
            this.diasAnticip=diasAnticip;
            
        }
        categ=BizEnt.db.getCategoria(categId);
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCateg() {
        return categ;
    }

    public void setCateg(Categoria idCateg) {
        this.categ = idCateg;
    }
    public void setCateg(int id) {
        categ=BizEnt.db.getCategoria(id);
    }
     public int getIdCateg() {
        return categ.getId();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
/*
    public Calendar getFecha() {
        Calendar a=Calendar.getInstance();
        a.setTime(fecha);
        return a;
    }
*/
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Calendar fecha) {
        this.fecha = fecha.getTime();
    }


    public void setFecha(Date fecha) {
        this.fecha= fecha;
    }
    
    public Date getDate(Calendar f) {
        Date d=f.getTime();
        return d;
    }
    
    public Timestamp getTime(Calendar f) {
        Timestamp a=new Timestamp(getDate(f).getTime());
        return a;
    }
        public Timestamp getTime(Date f) {
        Timestamp a=new Timestamp(f.getTime());
        return a;
    }
    public boolean isRegistrado() {
        return registrado;
    }
    public int getRegistrado() {
        int a=0;
        if (isRegistrado())
        {
            a=1;
        }
        return a;
    }
    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public Date getDiasAnticip() {
        return diasAnticip;
    }

    public void setDiasAnticip(Date diasAnticip) {
        this.diasAnticip = diasAnticip;
    }
        public String getSQLInsertValues() {
            Timestamp a=getTime(fecha);
            String b;
            int c=0;
            if (isRegistrado())
            {
                c=1;
            }
            
            b=("'"+getIdCateg()+"', '"+getNombre()+"', '"+getMonto()+"', '"+a+"', '"+c);
            if(diasAnticip!=null)
            {
                a=getTime(diasAnticip);
                b=b.concat("', '"+a+"'");
            }
            else
            {
                b=b.concat("','null'");
            }
            
           // b=("'"+getIdCateg()+"', '"+getNombre()+"', "+getMonto()+"', '2013-10-17 02:38:04.905', '"+isRegistrado()+"','null'");
            return b;
    }
        
        public Object[] getArray() {
        return new Object[] { this.getId(),
                              this.getCateg(),
                              this.getNombre(),
                              this.getMonto(),
                              this.getFecha(),
                              this.isRegistrado(),
                              this.getDiasAnticip()};
    }
}
