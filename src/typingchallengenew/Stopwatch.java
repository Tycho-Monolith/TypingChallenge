
package typingchallengenew;

public class Stopwatch {
    
    private final long startTime;
    
    //starts timer
    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }
    
    //ends timer and returns results
    public double elapsedTime() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - startTime) / 1000.0;
    }
    
}