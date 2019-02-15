import java.util.Scanner ;

/**
 * OPERATORHistory_Reader is an operating object designed to read a .txt file and convert into DRAWData information.
 * 
 * @author Agent_BENNETTE
 * @version 1 : Created 20150519
 */
public class OPERATORHistory_Reader
{
    
    private String directory = "" ;
    private DRAWData data = new DRAWData() ;
    
    /**
     *      CONSTRUCTOR METHOD
     */
    public OPERATORHistory_Reader ()
    {
        
        System.out.println("OPERATOR History Reader has been initialized. Pending...") ;
        
    }
    
    /**
     *      SETTER METHOD
     *          Set the directory of the file to be read.
     */
    public void setDirectory( String input )
    {
        
        directory = input + ".txt" ;
        
    }
    
    /**
     *      SETTER METHOD   
     *          Clear data
     */
    public void clear()
    {
        
        data.dataSetClear(0) ;
        
    }
    
    /**
     *      SCANNER METHOD
     *          Read the file, if possible.
     */
    public void read() throws Exception
    {
        
        //Set up compatible destination information
        java.io.File file = new java.io.File( directory ) ;
        
        //Check to see if the file exists.
        if ( file.exists() == false )
        {
            
            System.out.println("OPERATOR History Reader - [Debug] : File directory \"" + directory + "\" does not exist.") ;
            
        }
        else
        {
            
            System.out.println("OPERATOR History Reader - Now reading file @" + directory ) ;
            
            //Set up String variables
            String inputLine = "" ;
            
            //Set up the scanner object.
            Scanner input = new Scanner( file ) ;
            
            //Read the file
            while ( input.hasNext() )
            {
                
                //Read the file, split into its sections
                inputLine = input.nextLine() ;
                
                //Input the data into the DRAWData object
                data.setShape( inputLine ) ;
                
            }
            
            input.close() ;
            
        }
        
        
    }
    
    /**
     *      COLLECTOR METHOD
     *          Return DRAWData object data
     */
    public DRAWData getData()
    {
        
        System.out.println("Operator History Reader - Now granting read DRAWData data.") ;
        
        return data ;
        
    }
    
    /**
     *      COLLECTOR METHOD
     *          Recompile DRAWData data by adding this DRAWData after input DRAWData
     */
    public DRAWData addData( DRAWData input )
    {
        
        System.out.println("OPERATOR History Reader - Now adding read DRAWData data to input DRAWData.") ;
        
        //Set up the variables to be used for building the string.
        String builtString = "" ;
        int subSlotLimit = 6 ;
        
        //Input read DRAWData data into the input DRAWData data
        for ( int slot = 0 ; slot < data.dataFeedLimit() ; slot ++ )
        {
            
            //Check the maximum input of String
            if ( data.dataFeedSpecific( slot , 6 ).equals("") )
            {
                
                subSlotLimit = 6 ;
                
            }
            else
            {
                
                subSlotLimit = 8 ;
                
            }
            
            //Create the builtString
            for ( int subSlot = 0 ; subSlot < subSlotLimit ; subSlot ++ )
            {
            
                builtString = builtString + data.dataFeedSpecific( slot , subSlot ) ;
                
            }
            
            //Input the builtString
            input.setShape( builtString ) ;
            
        }
        
        return input ;
        
    }
    
}
