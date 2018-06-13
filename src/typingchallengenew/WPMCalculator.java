
package typingchallengenew;

public class WPMCalculator {
    
    //calculates WPM
    double wpmCalc(double time, String passage) {
        double noOfChars = passage.length();
        return ( 60 * (noOfChars / 5) / time );  
    }
    
}
