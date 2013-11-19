/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import javax.swing.text.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author ggmoy
 */
public class CustDocumentFilter extends DocumentFilter {
    private Pattern pattern; 
    private Matcher matcher;

    public CustDocumentFilter(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        Document      doc     = fb.getDocument();
        String        oldText = doc.getText(0, doc.getLength());
        StringBuilder sb      = new StringBuilder(oldText);

        sb.insert(offset, text);
        if (pattern.matcher(sb.toString()).find()) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document      doc     = fb.getDocument();
        String        oldText = doc.getText(0, doc.getLength());
        StringBuilder sb      = new StringBuilder(oldText);

        sb.replace(offset, offset + length, text);
        if (pattern.matcher(sb.toString()).find()) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
        Document      doc     = fb.getDocument();
        String        oldText = doc.getText(0, doc.getLength());
        StringBuilder sb      = new StringBuilder(oldText);

        sb.replace(offset, offset + length, "");
        if (pattern.matcher(sb.toString()).find()) {
            super.remove(fb, offset, length);
        }
    }
}