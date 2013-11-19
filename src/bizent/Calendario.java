package bizent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import java.util.*;

/**
 *
 * @author Surai
 */

public class Calendario extends JPanel {

    private JLabel sun;
    private JLabel mon;
    private JLabel tue;
    private JLabel wed;
    private JLabel thu;
    private JLabel fri;
    private JLabel sat;
    
    private Color c;
    private static Color n;


    private JPanel mainpanel;                   
    private JPanel p[]= new JPanel[42];            
    private static JButton b[]= new JButton[31];       
    
        
        private static Calendar fecha;
        private JPanel mainp;        
        private JTextField date; 
        private JComboBox month;
        private JTextField year; 
        private JButton sb[]= new JButton[2]; 
        private JTable tabla;
   
        
      
  public  Calendario(JTable t){
        super();
        
         try {
  
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                 
                    break;
                }
                else if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                else{
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                }
            }
        } catch (Exception e) {
        
        }
        
        tabla =t;
        setLayout(null); 
        setSize(355,228);
        setVisible(true);
        
        
       
        
        mainp = new JPanel();
        mainp.setLayout(null);
        mainp.setSize(330,31);
        mainp.setLocation(1,0);
        
        fecha=Calendar.getInstance();
        
        date = new JTextField(); 
        date.setSize(100,30);
        date.setLocation(5,0);
        date.setBackground(Color.WHITE);
        date.setFont(new Font("Arial",Font.PLAIN,14));
        date.setEditable(false);
        
        month = new JComboBox(getMonths());   
        month.setSize(90,30);
        month.setLocation(110,0);
        
        
        year = new JTextField("2008");   
        year.setSize(70,30);
        year.setLocation(205,0);
        year.setBackground(Color.WHITE);
        year.setEditable(false);
        
        sb[0] = new JButton("+");     
        sb[0].setSize(45,15);
        sb[0].setLocation(275,0);
        
        sb[1] = new JButton("-");                
        sb[1].setSize(45,15);
        sb[1].setLocation(275,16);


        mainp.add(date);
        mainp.add(month);
        mainp.add(year);
        mainp.add(sb[0]);
        mainp.add(sb[1]);
        add(mainp);

        
        
        mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(7,7,1,1));
        mainpanel.setSize(330,160);
        mainpanel.setLocation(1,31);
        

        
        sun = new JLabel("Domingo");
        sun.setForeground(Color.RED);
        mon = new JLabel("Lunes");
        tue = new JLabel("Martes");
        wed = new JLabel("Miércoles");
        thu = new JLabel("Jueves");
        fri = new JLabel("Viernes");
        sat = new JLabel("Sábado");
        

        mainpanel.add(sun);
        mainpanel.add(mon);
        mainpanel.add(tue);
        mainpanel.add(wed);
        mainpanel.add(thu);
        mainpanel.add(fri);
        mainpanel.add(sat);
        
        c=new Color(255,35,55);
        c=c.brighter();
        n=Color.LIGHT_GRAY;
        n=new Color(238,238,238);
        n=sb[0].getBackground();
        
        for (int x=0;x<42;x++){
            p[x]= new JPanel();
            p[x].setLayout(new GridLayout(1,1));
            p[x].setBackground(Color.WHITE);
            mainpanel.add(p[x]);
            validate();
        }
        
        final HandlerClass handler= new HandlerClass();      
        
        for (int i=0;i<31;i++){     
            b[i]= new JButton();
            b[i].addActionListener(handler);
            b[i].setFont(new Font("Times New Roman",Font.PLAIN,11));
            b[i].setText(Integer.toString(i+1));
        
        }
        
        
        final Calendar now = GregorianCalendar.getInstance();       
        year.setText(Integer.toString(now.get(Calendar.YEAR)));    
        month.setSelectedIndex(now.get(Calendar.MONTH));  
                                                                            
        validate();
        
        int ye=0;
        try
        {
        ye=Integer.parseInt(year.getText());
        }
        catch(Exception e)
        {
            
        }
        
        Calendar cal = new GregorianCalendar(ye, month.getSelectedIndex(), 1);    

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        

        
        for (int i=0;i<31;i++)     {         
            p[dayOfWeek-1].add(b[i]);             
            dayOfWeek++;
        }
        
        int bd=now.get(Calendar.DATE);              

        
        add(mainpanel); 
        
        validate();
    
        month.addItemListener( new ItemListener(){
        public void itemStateChanged(ItemEvent event)
        {
        	if (event.getStateChange()==ItemEvent.SELECTED){
                rearmar();
            }
            mainp.validate();
            validate();
            
            date.setText(Integer.toString(handler.db +1).concat(" / ").concat(Integer.toString(month.getSelectedIndex() + 1)).concat(" / ").concat(year.getText()));
            fecha.set((Integer.valueOf(year.getText())), month.getSelectedIndex(), handler.db+1);
        }    
                
        });

        
        sb[0].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
                    int  y=0;
                    try
                    {
                    y = Integer.parseInt(year.getText());
                    }
                    catch(Exception ex)
                    {
                        
                    }
                    y++;
                    year.setText(Integer.toString(y));
                    rearmar();
                    date.setText(Integer.toString(handler.db +1).concat(" / ").concat(Integer.toString(month.getSelectedIndex() + 1)).concat(" / ").concat(year.getText()));
                    fecha.set((Integer.valueOf(year.getText())), month.getSelectedIndex(), handler.db+1);
                }
                                
                }
        );
        


        sb[1].addActionListener(
                new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int  y=0;
                    try
                    {
                    y = Integer.parseInt(year.getText());
                    }
                    catch(Exception ex)
                    {
                        
                    }
                    y--;
                   year.setText(Integer.toString(y));
                   rearmar();
                    date.setText(Integer.toString(handler.db +1).concat(" / ").concat(Integer.toString(month.getSelectedIndex() + 1)).concat(" / ").concat(year.getText()));
                    fecha.set((Integer.valueOf(year.getText())), month.getSelectedIndex(), handler.db+1);
                }
                                
                }
        );

           tabla.getColumn("Fecha").setCellRenderer(new DateRenderer("dd-MM-yyyy"));


        date.setText(Integer.toString(handler.db +1).concat(" / ").concat(Integer.toString(month.getSelectedIndex() + 1)).concat(" / ").concat(year.getText()));
        fecha.set((Integer.valueOf(year.getText())), month.getSelectedIndex(), handler.db+1);
  }
    
 
  public static Calendar getDate() {
        return fecha;
    }   

public int getDaysNo()
{

        int no = 31;
        if (month.getSelectedIndex()==1){
            no=28;
            if (Integer.parseInt(year.getText())%4==0){
                no=29;
                
            }
            month.validate();
        }
        
        if (month.getSelectedIndex()==3 || month.getSelectedIndex()==5 || month.getSelectedIndex()==8 || month.getSelectedIndex()==10)
        {
            no=30;
        }
        return no;
        
    }
    


public String[] getMonths()
{
    String[] months= new String [12];
    		months[0]="Enero";
    		months[1]="Febrero";
    		months[2]="Marzo";
    		months[3]="Abril";
    		months[4]="Mayo";
    		months[5]="Junio";
    		months[6]="Julio";
    		months[7]="Agosto";
    		months[8]="Septiembre";
    		months[9]="Octubre";
    		months[10]="Noviembre";
    		months[11]="Diciembre";
    return months;
}

    class HandlerClass implements ActionListener{
            
        Calendar now = Calendar.getInstance();
        public int db=(now.get(Calendar.DATE))-1;
        
        public void actionPerformed(ActionEvent e){
            for (int k=0;k<31;k++){    
                     
                     if (e.getSource()==b[k])
                     {
                         validate();
                         db=k;
                         now.set(Integer.parseInt(year.getText()),month.getSelectedIndex(), (db+1));
                         BizEnt.db.updateVencimientosTableModel(now);
                     }
                     else{
                         validate();
                     }    
                     month.validate();
                     
                 }

                 date.setText(Integer.toString(db +1).concat(" / ").concat(Integer.toString(month.getSelectedIndex()+1)).concat(" / ").concat(year.getText()));
                 fecha.set((Integer.valueOf(year.getText())), month.getSelectedIndex(),db+1);
                 PantallaVencimientos.setLabel("Vencimientos del "+date.getText());
                 PantallaVencimientos.updateVencimientosJTable();
        }
        
        
    }


public void rearmar()
{
                mainpanel.removeAll();
                validate();
                
                mainpanel.add(sun);
                mainpanel.add(mon);
                mainpanel.add(tue);
                mainpanel.add(wed);
                mainpanel.add(thu);
                mainpanel.add(fri);
                mainpanel.add(sat);
                for (int x=0;x<42;x++){
                    
                    p[x].removeAll();
                    mainpanel.add(p[x]);
                    validate();
                }
                int ye=0;
                try
                {
                 ye=Integer.parseInt(year.getText());
                }
                catch (Exception e)
                {
                            
                }
                Calendar cal=Calendar.getInstance();
                cal.set(ye, month.getSelectedIndex(), 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Calendar cal2=Calendar.getInstance() ;
                cal2.set(Calendar.HOUR_OF_DAY, 0);
                cal2.set(Calendar.MINUTE, 0);
                cal2.set(Calendar.SECOND, 0);
                cal2.set(Calendar.MILLISECOND, 0);
                if(month.getSelectedIndex()==11)
                {
                    cal2.set(ye+1,0, 1);
                }
                else
                {
                    cal2.set(ye,month.getSelectedIndex()+1, 1);
                }
                
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                
                n=getParent().getBackground();
                BizEnt.db.updateVencimientosTableModel(cal.getTime(),cal2.getTime()); 
                ArrayList <Calendar> venc=BizEnt.db.getVencimientosMes(cal);
                for (int i=0;i<31;i++){
                     p[dayOfWeek-1].add(b[i]);
                     b[i].setBackground(n);
                     if (venc.isEmpty()==false)
                    {
                        
                        Calendar min=Collections.min(venc);
                        if ((min.get(Calendar.DATE)-1)==(i))
                        {
                            b[i].setBackground(c);
                            venc.remove(min);
                            while(venc.contains(min))
                            {
                                venc.remove(min);
                            }
                        }
                    }
                    dayOfWeek++;
                    
                    validate();

                }
                validate();
               PantallaVencimientos.setLabel("Vencimientos del mes de "+(String)month.getSelectedItem()+" del "+year.getText());
               PantallaVencimientos.updateVencimientosJTable();

}

public static void resetearColores()
{
    for (int i=0;i<31;i++){
        b[i].setBackground(n);
    }
}
}
