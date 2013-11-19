/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import jxl.CellView;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author Surai
 */
public class reportesExcel {
    
    
    public static boolean exportarDatosCuentas(String nombre, JTable cuentas, JTable vencimientos)
    {
        boolean b=false;
        try {        
            WritableWorkbook workbook= Workbook.createWorkbook(new File(nombre+".xls"));
            
            WritableFont times14font = new WritableFont(WritableFont.TIMES, 14, WritableFont.BOLD, true); 
            WritableCellFormat times14format = new WritableCellFormat (times14font);    
            WritableFont times12font = new WritableFont(WritableFont.TAHOMA, 10); 
            WritableCellFormat times12format = new WritableCellFormat (times12font);    
            
            CellView cell;
            
            //Hoja Cuentas
            WritableSheet sheet = workbook.createSheet("Cuentas", 0);
            for (int i=1; i<cuentas.getColumnCount(); i++)
            {
                Label label = new Label((i-1), 0, cuentas.getColumnName(i), times12format);
                sheet.addCell(label);
                cell=sheet.getColumnView((i-1));
                cell.setAutosize(true);
                sheet.setColumnView((i-1), cell); 
            }
            Date date; 
            DateFormat customDateFormat = new DateFormat ("dd MMM yyyy hh:mm:ss"); 
            WritableCellFormat dateFormat = new WritableCellFormat (customDateFormat);
            for (int i=0; i<cuentas.getRowCount(); i++)
            {
                date=(Date)cuentas.getValueAt(i, 1);
                DateTime dateCell = new DateTime(0, (i+1), date, dateFormat); 
                sheet.addCell(dateCell);
                /*
                Calendar c=Calendar.getInstance();
                c.setTime(date);
                Label lab = new Label(2, (i+1), ""+c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)); 
                sheet.addCell(lab);
                */
                Label label = new Label(1, (i+1), (String)cuentas.getValueAt(i, 2));
                sheet.addCell(label); 
                label = new Label(2, (i+1), (String)cuentas.getValueAt(i, 3));
                sheet.addCell(label);  
                label = new Label(3, (i+1), (String)cuentas.getValueAt(i, 4));
                sheet.addCell(label);
                label = new Label(4, (i+1), ""+(Double)cuentas.getValueAt(i, 5)+"");
                sheet.addCell(label);
                //WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.FLOAT); 
                //Number number3 = new Number(4, (i+1), (Double)tabla.getValueAt(i, 5), floatFormat);
            }


            
            //Hoja Movimientos
            
            sheet = workbook.createSheet("Movimientos", 1);
            int cont=0;
            for (int j=0; j<BizEnt.db.getCuentasComboBoxModel().getSize();j++)
            {
            Cuenta c=BizEnt.db.getCuentasComboBoxModel().getElementAt(j);
            BizEnt.db.updateMovimientosTableModel(c);
            JTable movimientos=new JTable(BizEnt.db.getMovimientosTableModel());
            if(movimientos.getRowCount()>0)
            {
                        Label label1 = new Label(0, cont, c.getNombre(), times14format);
                        sheet.addCell(label1); 
                        cont=cont+1;
                        for (int i=1; i<movimientos.getColumnCount(); i++)
                        {
                            Label label = new Label((i-1), cont, movimientos.getColumnName(i), times12format);
                            sheet.addCell(label); 
                            cell=sheet.getColumnView((i-1));
                            cell.setAutosize(true);
                            sheet.setColumnView((i-1), cell); 
                        }

                        for (int i=0; i<movimientos.getRowCount(); i++)
                        {
                            date=(Date)movimientos.getValueAt(i, 1);
                            DateTime dateCell = new DateTime(0, (cont+1), date, dateFormat); 
                            sheet.addCell(dateCell);
                            Label label = new Label(1, (cont+1), (String)movimientos.getValueAt(i, 2));
                            sheet.addCell(label); 
                            label = new Label(2, (cont+1), (String)movimientos.getValueAt(i, 3));
                            sheet.addCell(label);  
                            label = new Label(3, (cont+1), ""+(Double)movimientos.getValueAt(i, 4)+"");
                            sheet.addCell(label);
                            label = new Label(4, (cont+1), ""+(Double)movimientos.getValueAt(i, 5)+"");
                            sheet.addCell(label);
                            label = new Label(5, (cont+1), ""+(Double)movimientos.getValueAt(i, 6)+"");
                            sheet.addCell(label);
                            cont=cont+1;
                        }
                        cont=cont+2;
                    }
                }
 
            
            
            
            //Hoja Vencimientos
            sheet = workbook.createSheet("Vencimientos", 2);
            for (int i=1; i<vencimientos.getColumnCount(); i++)
            {
                Label label = new Label((i-1), 0, vencimientos.getColumnName(i), times12format);
                sheet.addCell(label); 
                cell=sheet.getColumnView((i-1));
                cell.setAutosize(true);
                sheet.setColumnView((i-1), cell); 
            }
             
            for (int i=0; i<vencimientos.getRowCount(); i++)
            {
                
                Label label = new Label(0, (i+1),((Categoria)vencimientos.getValueAt(i, 1)).getName());
                sheet.addCell(label); 
                label = new Label(1, (i+1), (String)vencimientos.getValueAt(i, 2));
                sheet.addCell(label);
                label = new Label(2, (i+1), ""+(Double)vencimientos.getValueAt(i, 3)+"");
                sheet.addCell(label);
                customDateFormat = new DateFormat ("dd MMM yyyy"); 
                dateFormat = new WritableCellFormat (customDateFormat);
                date=(Date)vencimientos.getValueAt(i, 4);
                DateTime dateCell = new DateTime(3, (i+1), date, dateFormat); 
                sheet.addCell(dateCell);
                  
            }
            
            //Hoja Plazos Fijos
            sheet = workbook.createSheet("Inversiones", 3);
            JTable inv=new JTable (BizEnt.db.getInversionesTableModel());
            for (int i=1; i<inv.getColumnCount(); i++)
            {
                Label label = new Label((i-1), 0, inv.getColumnName(i), times12format);
                sheet.addCell(label); 
                cell=sheet.getColumnView((i-1));
                cell.setAutosize(true);
                sheet.setColumnView((i-1), cell); 
            }
             
            for (int i=0; i<inv.getRowCount(); i++)
            {
                
                Label label = new Label(0, (i+1),((String)inv.getValueAt(i, 1)));
                sheet.addCell(label); 
                label = new Label(1, (i+1), (String)inv.getValueAt(i, 2));
                sheet.addCell(label);
                customDateFormat = new DateFormat ("dd MMM yyyy"); 
                dateFormat = new WritableCellFormat (customDateFormat);
                date=(Date)inv.getValueAt(i, 3);
                DateTime dateCell = new DateTime(2, (i+1), date, dateFormat); 
                sheet.addCell(dateCell);
                label = new Label(3, (i+1), ""+(Double)inv.getValueAt(i, 4)+"");
                sheet.addCell(label);
                date=(Date)inv.getValueAt(i, 5);
                dateCell = new DateTime(4, (i+1), date, dateFormat); 
                sheet.addCell(dateCell);  
            }
            
            workbook.write(); 
            workbook.close();
            b=true;

        } catch (IOException ex) {
            Logger.getLogger(reportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RowsExceededException ex) {
                Logger.getLogger(reportesExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex)
        {
            
        }
        return b;
      
    }
    

}


