
package typingchallengenew;

import java.util.ArrayList;
import java.util.Arrays;


public class ArrayListSplitter {
    
    //splits a string into an AryList
    ArrayList returnAryListFromString(String text) {
        ArrayList<String> aryList = new ArrayList(Arrays.asList(text.split(" ")));
        return aryList;
    }
    
}