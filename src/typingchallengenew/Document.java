
package typingchallengenew;

import java.util.ArrayList;
import javax.swing.text.*;

public class Document {
    
    ArrayList aryList;
    DefaultStyledDocument doc;
    
    Document(ArrayList al) {      
        aryList = al;       
    }
    
    void writeAryListToDoc() throws BadLocationException {
        int size = aryList.size();
        for (int i = size - 1; i >= 0; i--)
            doc.insertString(0, String.valueOf(aryList.get(i)) + " ", null);
    }
    
}
