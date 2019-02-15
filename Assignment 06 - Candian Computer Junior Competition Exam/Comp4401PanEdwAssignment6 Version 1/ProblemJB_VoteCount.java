
/**
 * Read input data of votes and produce results.
 * 
 * @author AGENT_BENNETTE
 * @version 1 - Created 20150205
 */
public class ProblemJB_VoteCount
{

    /**
     *      MAIN METHOD
     */
    public static void main ( String [] args )
    {
        
        //Clear previous text
        System.out.println("\u000c") ;
        
        //Generate inputs
        String inputA = "ABBABB" ;
        int inputALength = inputA.length() ;
        String inputB = "ABBABA" ;
        int inputBLength = inputB.length() ;
        
        //Print resuilts
        System.out.println( getVoteResult(inputA) ) ;
        System.out.println( getVoteResult(inputB) ) ;
        
    }

    /**
     *      DATA PRINT METHOD - INPUT INFO
     *          This method is made purely to shorten required amount of code in main method.
     *      
     *      input:  STRING of votes
     *      output: STRING Winning Vote
     */
    public static String getVoteResult ( String input )
    {
        
        //Trim and set up the string properties for the operations.
        input.trim() ;
        input = input.toUpperCase() ;
        
        //Initialize all variables.
        int inputLength = input.length() ;
        int inputANo = 0 ;
        char [] inputArray = input.toCharArray() ;
        String result = "" ;
        
        //Find out whether or not there are more A votes than B votes.
        for ( int checkCycle = 0 ; checkCycle < inputArray.length ; checkCycle ++ )
        {
            
            if ( inputArray [ checkCycle ] == 'A' )
            {
                
                inputANo ++ ;
                
            }
            
        }
        if ( inputANo > inputLength )
        {
            
            result = "A" ;
            
        }
        else if ( inputANo < inputLength )
        {
            
            result = "B" ;
            
        }
        else
        {
            
            result = "Tie" ;
            
        }
        
        //Output result.
        return result ;
        
    }
}
