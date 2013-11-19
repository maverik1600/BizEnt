package bizent;

import javax.swing.JLabel;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author GustavoG
 */
public class DecimalRenderer extends DefaultTableCellRenderer {
    DecimalFormat formatter;

    DecimalRenderer(String pattern)          { this(new DecimalFormat(pattern)); }
    DecimalRenderer(DecimalFormat formatter) {
        this.formatter = formatter;
        setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public void setValue(Object value) {
        setText((value == null) ? "" : formatter.format(((Double) value).doubleValue()));
    }
}