package training.java8.pack1;
import java.time.Duration;
import java.time.Instant;
 
public class InstantExample {
 
    public static void main(String[] args) {
    	/*java.time.Instant: Instant class is used to work with machine readable time format, it stores date time
    	in unix timestamp. Let�s see it�s usage with a simple program.
    	*/
        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);
         
        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);
         
        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay.toHours());
    }
 
}