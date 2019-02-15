
/**
 * BufferF (Short for Buffer for Formula) is a class designed to quickly change the language the user sees into something java can process and use as a calculation formula.
 *          All this is really doing is turning a few symbols into the math symbols and methods that java can understand.
 * 
 * @author BENNETTE
 * @version (a version number or a date)
 */
public class BufferF
{
    
    public static void main ( String [] args )
    {
        
        //There's no usage for this.
        
    }
    
    /**
     *      Input   :   Human Formula
     *      Output  :   Java Formula
     *      
     *      Things to be translated:
     *      Symbol  |   Meaning     |   Java Symbol
     *      
     *      \u00d7  |   Multiply    |   *
     *      \u00f7  |   Divide      |   /
     *      ^2      |   Square      |   Math.pow( y , 2 )
     *      \u221a  |   SquareRoot  |   Math.pow( y , 0.5 )
     *      ^x      |   Exponent    |   Math.pow( y , x )
     *      %       |   Percent     |   / 100
     *      1/x   |   Flippy?     |   Math.pow( y , -1 )
     */
    public static String translate ( String input )
    {
        
        //Ensure there are no extra spaces that would screw up the splitting.
        input = SRMDoubleSpaceRemover ( input ) ;
        
        //Decompress the string and identify each variable symbol operator, etc. in its own variable.
        String [] formulaSlot = input.split(" ") ;
        
        //Placeholdfer for calculation formulas
        String [] temp = new String [ 3 ] ;
        
        //Checking Algorhythm
        for ( int checker = 0 ; checker < formulaSlot.length ; checker ++ )
        {
            
            if (  ( formulaSlot [ checker ] ).equals("\u00d7")  ) //Multiplication
            {
                
                formulaSlot [ checker ] = "*" ;
                
            }
            else if (  ( formulaSlot [ checker ] ).equals("\u00f7")  ) //Division
            {
                
                formulaSlot [ checker ] = "/" ;
                
            }
            else if (  ( formulaSlot [ checker ] ).equals("^2")  ) //Square
            {
                
                temp = SRMSquare (  formulaSlot[ checker - 1 ] ) ;
                formulaSlot [ checker - 1 ] = temp [ 0 ] ;
                formulaSlot [ checker ] = temp [ 1 ] ;
                
            }
            else if (  ( formulaSlot [ checker ] ).equals("\u221a")  ) //SquareRoot
            {
                
                temp = SRMSquareRoot (  formulaSlot[ checker + 1 ] ) ;
                formulaSlot [ checker ] = temp [ 0 ] ;
                formulaSlot [ checker + 1 ] = temp [ 1 ] ;
                
            }
            else if (  ( formulaSlot [ checker ] ).equals("^")  ) //Exponent
            {
                
                temp = SRMExponent (  formulaSlot[ checker - 1 ] , formulaSlot[ checker + 1 ] ) ;
                formulaSlot [ checker - 1 ] = temp [ 0 ] ;
                formulaSlot [ checker ] = temp [ 1 ] ;
                formulaSlot [ checker + 1 ] = temp [ 2 ] ;
                
            }
            else if (  ( formulaSlot [ checker ] ).equals("%")  ) //Percentage
            {
                
                formulaSlot [ checker ] = "/100" ;
                
            } 
            else if (  ( formulaSlot [ checker ] ).equals("1/x")  ) //Flippy
            {
                
                temp = SRMFlipper (  formulaSlot[ checker - 1 ] ) ;
                formulaSlot [ checker - 1 ] = temp [ 0 ] ;
                formulaSlot [ checker ] = temp [ 1 ] ;
                
            }
            
        }
        
        //Recompress the array of created Strings into a single strand of string for the calculator to calculate.
        String converted = "" ;
        for ( int i = 0 ; i < formulaSlot.length ; i ++ )
        {
            
            converted = converted + formulaSlot [ i ] + " " ;
            
        }
        
        //Return the string.
        return converted ;
        
    }
    
    /**
     *      Special Rewriter Method : Square
     */
    private static String [] SRMSquare ( String string1 )
    {
        
        String [] converted = new String [ 2 ] ;
        converted [ 0 ] = " Math.pow " ;
        converted [ 1 ] = "( " + string1 + " , 2 ) " ;
        return converted ;
        
    }
    
    /**
     *      Special Rewriter Method : SquareRoot
     */
    private static String [] SRMSquareRoot ( String string1 )
    {
        
        String [] converted = new String [ 2 ] ;
        converted [ 0 ] = " Math.pow " ;
        converted [ 1 ] = "( " + string1 + " , 0.5 ) " ;
        return converted ;
        
    }
    
    /**
     *      Special Rewriter Method : Exponent
     */
    private static String [] SRMExponent ( String string1, String string2  )
    {
        
        String [] converted = new String [ 3 ] ;
        converted [ 0 ] = " Math.pow " ;
        converted [ 1 ] = "( " + string1 + " , " ;
        converted [ 2 ] = string2 + " ) " ;
        return converted ;
        
    }
    
    /**
     *      Special Rewriter Method : FlippyThingamabob. I don't know. Negative 1 power.
     */
    private static String [] SRMFlipper ( String string1 )
    {
        
        String [] converted = new String [ 3 ] ;
        converted [ 0 ] = " Math.pow " ;
        converted [ 1 ] = "( " + string1 + " , -1 ) " ;
        return converted ;
        
    }
    
    /**
     *      Special Rewriter Method : SpaceRemoval
     */
    public static String SRMDoubleSpaceRemover ( String input )
    {
        
        boolean noFaults = false ;
        
        while ( noFaults == false )
        {
            
            for ( int checkingSlot = 0 ; checkingSlot < input.length() - 1 ; checkingSlot ++ )
            {
                
                noFaults = true ;
                
                if ( input.substring( checkingSlot, checkingSlot + 2 ).equals("  ") )
                {
                    
                    noFaults = false ;
                    input = input.substring ( 0 , checkingSlot + 1 ) + input.substring ( checkingSlot + 2 , input.length() ) ;
                    break ;
                    
                }
                
            }
            
        }
        
        return input ;
        
    }
    
    
}
