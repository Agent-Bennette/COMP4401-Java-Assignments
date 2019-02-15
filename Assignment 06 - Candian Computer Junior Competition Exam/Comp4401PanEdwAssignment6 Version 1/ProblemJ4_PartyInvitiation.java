
/**
 * Chose who gets to go to the party and who doesn't through some really weird altogrythm!
 * 
 * @author AGENT BENNETTE
 * @version 1 - Created 20150209
 */
public class ProblemJ4_PartyInvitiation
{
    
    /**
     *      MAIN METHOD
     */
    public static void main ( String [] args )
    {
        
        
        
    }
    
    
    
    /**
     *      GETTER METHOD
     *          RANDOM NUMBER
     */
    public static int getRandomNumber ( int min, int max )
    {
        
        int difference = max - min ;
        return (int)( Math.random() * 100 ) % difference + min ;
        
    }
    
}
