import java.util.Scanner ;

/**
 * Program fo Problem J3 : Double Dice
 * 
 * @author AGENT BENNETTE
 * @version 1 - Created 20150209
 */
public class ProblemJC_DoubleDice
{
    
    /**
     *      SET UP UNIVERSAL VARIABLES.
     */
    private static int [] playerPoints = new int [2] ;
    
    
    
    /**
     *      MAIN METHOD
     */
    public static void main ( String [] args )
    {
        
        /**
         *  INITIALIZE VARIABLES
         */
        setResetPoints() ;
        int roundsToPlay = -16237838 ;
        
        
        /**
         *  INITIALIZE SCANNER
         */
        Scanner input = new Scanner(System.in) ;
        
        
        /**
         *  PROMPT THE USER FOR THE NUMBER OF ROUNDS TO COMPLETE
         */
        while ( roundsToPlay < 1 || roundsToPlay > 15 )
        {
            
            if ( roundsToPlay != -16237838 )
            {
                
                System.out.print("\u000c\n\tPlease enter a VALID quantity of rounds to complete.\n\t\t(Enterred integer must be [ 1 , 15 ] ) : " ) ;
                
            }
            else
            {
                
                System.out.print("\n\tDavid and Antonia need to know how many rounds they need to complete to complete their game of roll-the-die.\n\t\tPlease enter an integer BETWEEN 0 and 16 : " ) ;
                
            }
            roundsToPlay = input.nextInt() ;
            
        }
        
        
        /**
         *  COMPLETE THE GAME
         *      Complete all the calculations needed to complete the game.
         */
        for ( int roundsCompleted = 0 ; roundsCompleted < roundsToPlay ; roundsCompleted ++ )
        {
            
            setPointsPlayers( getDiceRoll() , getDiceRoll() ) ;
            
        }
        
        
        /**
         *  OUTPUT THE GAME RESULTS
         */
        System.out.printf("%20s","Antonio : " ) ;
        System.out.println( playerPoints [ 0 ] ) ;
        System.out.printf("%20s","David : " ) ;
        System.out.println( playerPoints [ 1 ] ) ;
        if ( playerPoints [ 0 ] > playerPoints [ 1 ] )
        {
            
            System.out.println("\tAntonia wins the game!" );
            
        }
        else if ( playerPoints [ 0 ] == playerPoints [ 1 ] )
        {
            
            System.out.println("\tAntonia and David are tied!" ) ;
            
        }
        else
        {
            
            System.out.println("\tDavid wins the game!" ) ;
            
        }
        
    }
    
    
    
    /**
     *      GETTER METHOD
     *          DICE ROLL VALUE
     */
    public static int getDiceRoll()
    {
        
        return (int)( Math.random() * 10 ) % 6 + 1 ;
        
    }
    
    
    
    /**
     *      RESET METHOD
     *          SET ALL POINTS TO 100
     */
    public static void setResetPoints()
    {
        
        playerPoints [ 0 ] = 100 ;
        playerPoints [ 1 ] = 100 ;
        
    }
    
    
    
    /**
     *      SETTER METHOD
     *          CHANGE VALUE OF POINTS OF PLAYERS BASED ON ROLLED DIE.
     */
    public static void setPointsPlayers( int diceRollA , int diceRollB )
    {
        
        //Decide what kind of action will be taken.
        int caseNo = 0 ;
        if ( diceRollA < diceRollB ) //A is smaller
        {
            
            caseNo = 1 ;
            
        }
        else if ( diceRollA == diceRollB ) //A and B are the same
        {
            
            caseNo = 2 ;
            
        }
        else //B is smaller
        {
            
            caseNo = 3 ;
            
        }
        
        //Based on the resulting value, take action.
        switch ( caseNo )
        {
            
            //IMPOSSIBLE ERROR
            case 0 :
                System.out.println("ERROR LOG : IMPOSSIBLE ERROR HAS OCCURED.") ;
                System.exit(0) ;
                break ;
            
            //A's value is inferior to B. Thus, remove points from A based on B's value.
            case 1 :
                playerPoints [ 0 ] = playerPoints [ 0 ] - diceRollB ;
                break ;
                
            //A's value is the same as B. It's a tie - nothing happens.    
            case 2 :
                //Nothing happens.
                break ;
                
            //A's value is superior to B, thus remove points from B based on A's value.    
            case 3 :
                playerPoints [ 1 ] = playerPoints [ 1 ] - diceRollA ;
                break ;
            
        }
                
    }
    
}
