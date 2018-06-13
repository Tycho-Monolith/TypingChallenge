
package typingchallengenew;

import java.awt.Color;
import javax.swing.text.*;

public class StyleContextCreator {
    Style redStyle;
    Style greenStyle;
    Style blackStyle;
    
    private final StyleContext styleCont = new StyleContext();
  
    //adds the colours to the StyleContext
    StyleContextCreator () {
        redStyle = styleCont.addStyle("Red Style", null);
        redStyle.addAttribute(StyleConstants.Foreground, Color.red);

        greenStyle = styleCont.addStyle("Green Style", null);
        greenStyle.addAttribute(StyleConstants.Foreground, Color.green);

        blackStyle = styleCont.addStyle("Black Style", null);
        blackStyle.addAttribute(StyleConstants.Foreground, Color.black);
        
    }
     
    void textColourGreen (DefaultStyledDocument d, int len) {
        d.setCharacterAttributes(0, len, greenStyle, false);
    }
     
    void textColourRed (DefaultStyledDocument d, int len) {
        d.setCharacterAttributes(0, len, redStyle, false);
    }
     
    void textColourBlack (DefaultStyledDocument d, int len) {
        d.setCharacterAttributes(0, len, blackStyle, false);
    }
     
     
    StyleContext callSC() {
        return styleCont;
    }
}
