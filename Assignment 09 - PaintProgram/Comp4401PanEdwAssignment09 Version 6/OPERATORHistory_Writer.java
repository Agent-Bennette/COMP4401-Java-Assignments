import java.util.Scanner ;
import javax.swing.* ;
import javax.tools.* ;

/**
 *  OPERATION CLASS
 *      Save the history.
 *      
 *      Allow for the shape to be re-drawn for future purposes.
 *      
 *      This will allow for drawn data to be used in the future in other programs using a similar system.
 */
class OPERATORHistory_Writer
{
    private static String directory = "" ;
    
    /**
     *  Constructor method.
     *      Alert the user / developper that the file saving operations have begun.
     */
    public OPERATORHistory_Writer()
    {
        
        System.out.println("\u000cFile Saving Operator - Save History has been initialized. Pending...") ;
        
    }
    
    /**
     *  OPERATION Method
     *      SAVE HISTORY into .txt file
     */
    public void Save( DRAWData input ) throws Exception
    {
        
        System.out.println("File Saving Operator - Now Writing DRAWData...") ;
        
        /*
         *  STEPS
         *  
         *  A) Check validity of the directory.
         *  B) Set up output method
         *  C) Load in DRAWData information (Already included)
         *  D) Output Save the information into txt
         *      1.  Identify the amount of variables to be saved per row
         *      2.  Print appropriateloy
         */
        
        if ( SRMNameCheck() == 1 )
        {
        
            //Set up Scanner output
            java.io.PrintWriter output = new java.io.PrintWriter(directory) ;
            System.out.println("File Saving Operator - Suceeded in initializing PrintWriter") ;
            
            for ( int loadingSlot = 0 ; loadingSlot < input.dataFeedLimit() ; loadingSlot ++ )
            {
                
                System.out.println("File Saving Operator - Writing Slot " + loadingSlot + " of DRAWData input" ) ;
                
                output.print( input.dataFeedSpecific(loadingSlot,0) + " " + input.dataFeedSpecific(loadingSlot,1) + " " + input.dataFeedSpecific(loadingSlot,2) + " " + input.dataFeedSpecific(loadingSlot,3) + " " + input.dataFeedSpecific(loadingSlot,4) + " " + input.dataFeedSpecific(loadingSlot,5) ) ;
                //The only times exceptions begin is at slots 6 and 7. Check 6 for both.
                if ( input.dataFeedSpecific(loadingSlot,6) != null )
                {
                    
                    output.print( " " + input.dataFeedSpecific(loadingSlot,6) + " " + input.dataFeedSpecific(loadingSlot,7) ) ;
                    
                }
                output.println() ;
                
            }
            
            output.close() ;
            
            System.out.println("File Saving Operator - Succeeded in printing DRAWData input") ;
            
        }
        else
        {
            
            System.out.println("File Saving Operator - An Error Occured : An Invalid file directory is set. Please set a valid file directory (via .setDirectory() method).") ;
            
        }
        
    }
    
    /**
     *  SETTER Method
     *      Set the directory of the file name
     */
    public void setDirectory()
    {
        
        boolean retryDirectory = true ;
        int inputID = 0 ;
        
        do
        {
        
            directory = "" ;
        
            //System.out.println( SRMNameCheck() ) ;
            while ( SRMNameCheck() != 0 )
            {
            
                System.out.println("Prompting the user to enter file directory...") ;
                
                if ( SRMNameCheck() == 2 )
                {
                
                    directory = JOptionPane.showInputDialog("Please enter the name for the .txt file the drawing will be saved to.") ;
                
                }
                else if ( SRMNameCheck() == 1 )
                {
                
                    directory = JOptionPane.showInputDialog("An illegal character was detected within the previous directory's name.\nPlease re-enter the name of the .txt file the drawing the will be saved to.") ;
                
                }
                else
                {
                
                    System.out.println("File Saving Operator - Unknown Error. Contact developper for assistance.") ;
                
                }
            
            }
            
            System.out.println("Prompting user to confirm file directory...") ;
            inputID = JOptionPane.showConfirmDialog( null , ("Save file as : \"" + directory + "\" \nPlease confirm.") , "Confirm File Directory" , JOptionPane.YES_NO_OPTION ) ;
            if ( inputID == JOptionPane.YES_OPTION )
            {
                
                directory = /*"/resourcesDRAWData/" + */ directory + ".txt" ;
                System.out.println("DIRECTORY:" + directory) ;
                
                java.io.File file = new java.io.File( directory ) ;
                if ( file.exists() )
                {
                    
                    inputID = JOptionPane.showConfirmDialog( null , ("File directory \"" + directory + "\" already exists. Enable override file save?") , "Enable File Override?" , JOptionPane.YES_NO_OPTION ) ;
                    
                }
                
                if( inputID == JOptionPane.YES_OPTION )
                {
                    
                    retryDirectory = false ;
                    System.out.println("Set File Directory as : \"" + directory) ;
                    
                }
                else
                {
                    
                    System.out.println("Failed to set File Directory as : \"" + directory + "\"") ;
                    
                }
                
            }
            else
            {
                
                System.out.println("Failed to set File Directory as : \"" + directory + "\"") ;
                
            }
        
        }
        while ( retryDirectory ) ;
        
    }
    
    /**
     *  SRM NAME CHECKER
     *      Subroutine Method for checking if a string would be safe for file directory usage.
     */
    private int SRMNameCheck()
    {
        
        int validity = 0 ;
        
        if ( directory.length() == 0 )
        {
            
            validity = 2 ;
            
        }
        else
        {
        
            char [] stringSplit = directory.toCharArray() ;
        
            for ( int i = 0 ; i < stringSplit.length ; i ++ )
            {
            
                if ( ( stringSplit[i] >= 'A' && stringSplit[i] <= 'Z' || stringSplit[i] >= 'a' && stringSplit[i] <= 'z' || stringSplit[i] >= '0' && stringSplit[i] <= '9' || stringSplit[i] == ' ' || stringSplit[i] == '_' || stringSplit[i] == '-' ) == false )
                {
                
                    validity = 1 ;
                    break ;
                
                }
            
            }
            
        }
        
        return validity ;
        //  0:  Nominal TRUE
        //  1:  Nominal FALSE
        //  2:  Exception FALSE ( No text )
        
    }
    
}