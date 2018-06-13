
package typingchallengenew;

import java.awt.Color;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet.*;
import javax.swing.text.SimpleAttributeSet.*;
import javax.swing.text.StyleConstants.*;
import javax.swing.text.StyleContext.*;
import javax.swing.text.*;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextColourChanger {
    
    StyleContextCreator scc = new StyleContextCreator();
    StyleContext sc = scc.callSC();
    final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    
//    DefaultStyledDocument returnDoc() {
//        return doc;
//    }
    
    void addToDoc(String text) throws BadLocationException {    
        doc.insertString(0, text, null);  
    }
    
    void changeTextColour(Style colour, String text) throws BadLocationException {
        int length = text.length();
        //if (colour == sc.getStyle(red))
        doc.setCharacterAttributes(0, length, colour, false);
    }
}