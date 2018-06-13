
package typingchallengenew;

import java.util.ArrayList;
import java.util.Random;


public class TestPassage {
    
    private final ArrayList<String> aryListOfPassages = createAryListOfPassages();
    
    ArrayList createAryListOfPassages () {
        ArrayList<String> aryList = new ArrayList();
        
        //creates arrayList of potential passages
        aryList.add("The 1910 Cuba hurricane was said to be one of the worst tropical cyclones that has ever hit Cuba. The storm formed in the southern caribbean sea on October 9, 1910.");
        aryList.add("The formula one series originated with the European grand prix motor racing of the 1920s and 1930s. The formula is a set of rules that all participants' cars must meet.");
        aryList.add("Saturn is the sixth planet from the sun in the solar system. It is the second largest planet in the solar system. Like Jupiter, Uranus and Neptune, it is a gas giant.");     
        aryList.add("Choosing the right martial arts training for you can be extremely confusing and a little overwhelming. This is because of the huge number of options available to you.");
        
        return aryList;  
    }
    
   //returns random passage
   String returnRandomPassageAsString() {     
       createAryListOfPassages();
       int randomIndex = randomListIndex(aryListOfPassages);
       return aryListOfPassages.get(randomIndex);   
   } 
    
   
    //returns random index of AryList (returns -1 if aryList is empty
    int randomListIndex(ArrayList aryListOfPassages) {
        
        Random randomIndex = new Random();
        
        int sizeOfList = aryListOfPassages.size();
        if(sizeOfList > 0) {
            int index = randomIndex.nextInt(sizeOfList);
            return index;
        }
        else {
            return -1;
        }       
    }   
    
}
