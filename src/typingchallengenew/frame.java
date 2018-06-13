
package typingchallengenew;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class frame extends JFrame {
    
    StyleContextCreator sCon = new StyleContextCreator();
    StyleContext sc = sCon.callSC();
    Stopwatch timer;
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    ArrayListSplitter als = new ArrayListSplitter();
    TestPassage tp = new TestPassage();

    JFrame f;
    JTextPane pane;
    String testPassage;
    String chosenPassage;
    ArrayList chosenPassageAryList;
    JLabel intro;
    JTextArea userInput;
    String currentUserInput;
    ArrayList userAryList;
    boolean hasUserStarted;
    JTextArea results;
    
    
    public frame() throws BadLocationException {
        //creates the random passage to be copied by user (as string and as array list)
        chosenPassage = tp.returnRandomPassageAsString();
        chosenPassageAryList = als.returnAryListFromString(chosenPassage);

        initDoc();
        initTextPane();
        initFrame();
        initTextArea();
        initLabel();
    }
    
    
    final void initLabel() {
        //specs for intro
        intro = new JLabel("Type the passage below. The timer will start when you begin typing.");  
        intro.setBounds(50, 10, 400, 30);
        pane.add(intro);
    }
    
    
    
    final void initTextPane() {
        //specs for textPane
        pane = new JTextPane (doc);
        pane.setFocusable(false); 
        pane.setBackground(Color.lightGray);
        pane.setSize(20, 20);
    }
    
    
    final void initFrame() {
        //specs for frame
        f = new JFrame("Tom's Typing Challenge");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(pane, BorderLayout.CENTER);
        f.setSize(500, 300);
        f.setVisible(true);
    }
    
    final void initDoc() throws BadLocationException {
        //specs for doc
        SimpleAttributeSet position = new SimpleAttributeSet();
        StyleConstants.setLeftIndent(position, 50);
        StyleConstants.setRightIndent(position, 30);
        StyleConstants.setSpaceAbove(position, 50);
        doc.setParagraphAttributes(0, doc.getLength(), position, false);
        
        //adds the chosen passage to the Document
        int size = chosenPassageAryList.size();
        for (int i = size - 1; i >= 0; i--)
            doc.insertString(0, String.valueOf(chosenPassageAryList.get(i)) + " ", null);
    }
    
    
    final void initTextArea() {
        userInput = new JTextArea();
        userInput.requestFocus();
        
        results = new JTextArea();
        
        //boolean that changes to true if the user has started typing
        hasUserStarted = false;
        
        userInput.addKeyListener(new KeyListener() {  
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //if the user starts typing, then start the timer
                if (hasUserStarted == false) {
                    hasUserStarted = true;
                    timer = new Stopwatch();
                }  
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currentUserInput = userInput.getText();
                
                //if the user has typed the passage correctly...
                if (currentUserInput.equals(chosenPassage)) {
                    //stop the timer
                    double time = timer.elapsedTime();
                    
                    //calculate the WPM
                    WPMCalculator wpmc = new WPMCalculator();
                    double wpm = wpmc.wpmCalc(time, chosenPassage);
                    DecimalFormat df = new DecimalFormat();
                    df.setRoundingMode(RoundingMode.HALF_UP);
                    String wpmStr = df.format(wpm);
                    
                    //display the time and WPM to the uesr
                    results.setText("TIME = " + time + "\nWPM: " + wpmStr);
                }
                
                //makes an arrayList from the current user input
                userAryList = als.returnAryListFromString(currentUserInput);
                
                //the final index of the userAryList (i.e. the final word in the userInput box)
                int finalIndex = userAryList.size() - 1;
               
                //make the pane blank first before re-adding the words with colour
                pane.setText("");
                
                int size = chosenPassageAryList.size();
                for (int i = size - 1; i >= 0; i--) {
                    try {
                        //adds the word at index i to the doc
                        doc.insertString(0, String.valueOf(chosenPassageAryList.get(i)) + " ", null);
                        
                        //the number of chars in the word at index i
                        int length = (String.valueOf(chosenPassageAryList.get(i)) ).length();
                        if (i < userAryList.size() ) {
                            
                            //if the user input for this word is correct, make it green
                            if (userAryList.get(i).equals(chosenPassageAryList.get(i)) )
                                sCon.textColourGreen(doc, length); 
                            
                            //if the user hasn't finished typing the word, keep it black
                            else if ( (i == finalIndex) &&  (e.getKeyChar() != ' ') && (e.getKeyChar() != '.') )
                                sCon.textColourBlack(doc, length);
                            
                            //if the user types the word wrong, make it red
                            else
                                sCon.textColourRed(doc, length);    
                        }
                        //if the user hasn't typed the word yet, keep it black
                        else
                            sCon.textColourBlack(doc, length);
                    }
                    catch (BadLocationException ex) {
                        Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   
            }
        });
        
        //specs for userInput
        userInput.setBounds(50, 120, 380, 50);
        userInput.setEditable(true);
        userInput.setLineWrap(true);
        userInput.setFocusable(true);
        userInput.setBackground(Color.white);
        userInput.setWrapStyleWord(true);
        pane.add(userInput);
        
        //specs for results
        results.setBounds(50, 190, 100, 40);
        results.setBackground(Color.LIGHT_GRAY);
        pane.add(results);
        
    }  
}

