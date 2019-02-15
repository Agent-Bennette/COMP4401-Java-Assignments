    /**
     * This is the receiving end of WriterCal class. This class will be summoned to make the actual calculation necessary for the program.
     * 
     * @author BENNETTE's WriterCal
     * @version null; constantly editted by WriterCal
     */
    public class Calculation
    {
        
        //Variable to be collected by the main class of the program. 
        public static double result ;
        
        //Constructor method that has absolutely no usage here, other than summoning the object. 
        public Calculation () {} 
        
        //Very simple main method; The formula will be placed after the return queue, which will allow for users to quickly enter a formula through WriterCal and receive its result through this class.
        public String getResult() 
        {
            
            double result =  7 * 7  ;
            return String.valueOf(result) ;
            
        }
         
    }
