package bizent;

import javax.swing.JLabel;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Date;

/**
 *
 * @author GustavoG
 */
public class DateRenderer extends DefaultTableCellRenderer {
    SimpleDateFormat formatter;

    DateRenderer(String pattern)          { this(new SimpleDateFormat(pattern)); }
    DateRenderer(SimpleDateFormat formatter) {
        this.formatter = formatter;
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public void setValue(Object value) {
        setText((value == null) ? "" : formatter.format((Date) value));
    }
}