
/**
 * Display Object used to create the output string for the calculator's display.
 * 
 * @author AGENT_BENNETTE
 * @version 1 - Created 20150220
 */
public class Result
{
    private String text ;
    private int status ;
    private int exponent = 0 ;
    
    
    /**
     *      METHOD - CONSTRUCTOR
     */
    public Result()
    {
        
        //String of the displayed resulting number
        text = "" ;
        
        //Integer that defines what the status of the program is.
        // 0 = Show Formula
        // 1 = Show Result
        status = 0 ;
        
    }
    
    
    /**
     *      METHOD ACTIVE - Update the displayed text
     */
    public void updateText ( String newText , int newStatus )
    {
        
        if ( newStatus == 0 )
        {
            
            text = newText ;
            
        }
        else if ( newStatus == 1 )
        {
            
            text = newText ;
            
            if ( MSRExponentFinder() < 10 && MSRExponentFinder() > -10 )
            {
                
                exponent = 0 ;
                MSRRemoveExtra( 10 - MSRLengthOfWholes() ) ;
                
            }
            else
            {
                
                exponent = MSRExponentFinder() ;
                MSRResultOneWhole() ;
                
            }
            
        }
        else
        {
            
            text = "Error" ;
            
        }
        
    }
    
    
    /**
     *      METHOD ACTIVE - Get String stored
     */
    public String get()
    {
        
        String output = "" ;
        
        if ( exponent != 0 )
        {
            
            output = text + " * 10^" + exponent ;
            
        }
        else
        {
            
            output = text ;
            
        }
        
        return output ;
        
    }
    
    
    /**
     *      METHOD SUBROUTINE - Exponent (aka X value) finder for formula of A*10^x
     */
    private int MSRExponentFinder()
    {
        
        //Initializing the placeholder for the result.
        int exponent = 0 ;
        
        /*
         *  Split the number into whole parts and decimals
         */
        String [] textParts = text.split(".") ;
        
        /*
         *  Main portion of method
         */
        if ( ( textParts.length == 1 && Integer.parseInt( textParts[0] ) == 0 ) != true ) //Proceed only if the value of the number is not 0.
        {

            if ( Integer.parseInt( textParts[0] ) > 0 ) //If true, then exponent must be above 0.
            {
                
                while ( ( Double.parseDouble( text ) / (double)( Math.pow( 10 , exponent ) ) ) != 0 )
                {
                    
                    exponent ++ ;
                    
                }
            
            }
            else
            {
                
                while ( ( Double.parseDouble( text ) / (double)( Math.pow( 10 , exponent ) ) ) != 0 )
                {
                    
                    exponent -- ;
                    
                }
                
            }
        
        }
        
        return exponent ;
        
    }
    
    
    /**
     *      METHOD SUBROUTINE - Remove Extra String
     */
    private void MSRRemoveExtra( int maxDecimals )
    {
        
        //Split the number into wholes and decimals.
        String [] textParts = text.split(".") ;
        double decimals = Double.parseDouble( textParts[1] ) ;
        
        //Find the number of decimals there are. If there are more than the max, cut off the extra at the end.
        textParts [1] = "" + MSRRoundDoubleNoCut( decimals , maxDecimals ) ;
        
        //Reform the String of text
        if ( maxDecimals > 0 )
        {
            
            text = textParts [0] + "." + textParts [1] ;
            
        }
        else
        {
            
            text = textParts [0] ;
            
        }
        
    }
    
    
    /**
     *      METHOD SUBROUTINE - Find length of whole number
     */
    private int MSRLengthOfWholes()
    {
        
        //Split
        String [] textParts = text.split(".") ;
        
        //Find and return length.
        return textParts[0].length() ;
        
    }
    
    
    /**
     *      METHOD SUBROUTINE - Round the given double
     */
    private double MSRRoundDoubleNoCut( double decimals , int limit)
    {
        
        int dividor = (int)( Math.pow( 10 , limit ) ) ;
        
        decimals = decimals / limit ;
        if ( (int)( decimals ) / 10 - (int)( decimals * 10 ) > 5 )
        {
            
            decimals += 1 ;
            
        }
        decimals = decimals * limit ;
        
        return decimals ;
        
    }
    
    
    /**
     *      METHOD SUBROUTINE - Scientific Display - Change to one-digit whole number with decimals
     */
    private void MSRResultOneWhole()
    {
        
        String [] textParts = text.split(".") ;
        String numbersString = textParts[0] + textParts[1] ;
        text = numbersString.substring(0,1) + "." + numbersString.substring(1,numbersString.length()) ;
        
    }
    
}
