/**
 *      Custom Variable Class - String Array as drawDATA
 *      
 *      This variable will be an object holding all of the data as a string array.
 *      The GUIPanel will constantly refer to this to refresh its draw data;
 *          Whenever something changes, the data will go into drawDATA and then afterwards outwards back to GUIPanel.
 *          This is designed to allow for enterring objects or perhaps "undo"ing to be possible.
 */
class DRAWData
{
    
    /*
     *  Create the needed data for the object to function 
     */
    //Create Data Slots (1000) in the format of:    POLYGON TYPE | COLOR | XCoordStart | YCoordStart | XCoordEnd | Y CoordEnd
    private String [][] data = new String [ 1000000 ] [ 8 ] ;
    private int trueDataMax      = 0 ;      //LIMIT FOR REDO
    private int trueDataShow     = 0 ;      //Express what data slot is currently being shown / previewed
    private int trueDataEdit     = 0 ;      //Express what data slot is currently being editted
        /*
         *      NOTES FOR HOW THE trueDataMax and trueDataEdit function
         *          trueDataMax is the variable used to ascertain what is the actual maximum amount of shapes created. It should not be regularly used.
         *          trueDataEdit is the variable that is used to decide what will be shown on the board.
         *          Whenever a new shape is created, both will increase.
         *          For previewing, the same applies. Both will increase.
         *              However, in previewing we need information to constantly update without changing the slot.
         *              Thus, what we can do is:
         *                  1. Have an initiator that create the new object.
         *                  2. Have an update that constantly updates said object.
         */
    
    /**
     *  Constructor Method
     *      Prepare all data fields.
     */
    public void DRAWData()
    {
        
        dataSetClear(0) ;
        
    }
    
    /**
     *  Setter Method
     *      Data Edit : Clear
     *      
     *      input   :   void
     *      output  :   void
     *                  All data fields are reset
     */
    public void dataSetClear( int operationType )
    {
        
        if ( operationType == 0 ) //Clear all
        {
        
            for ( int i = 0 ; i < data.length ; i ++ )
            {
            
                data [i] [0] = "" ;
                data [i] [1] = "" ;
                data [i] [2] = "" ;
                data [i] [3] = "" ;
                data [i] [4] = "" ;
                data [i] [5] = "" ;
                data [i] [6] = "" ;
                data [i] [7] = "" ;
            
            }
            trueDataMax = 0 ;
            trueDataEdit = 0 ;
            trueDataShow = 0 ;
            
        }
        else if ( operationType == 1 ) //Clear most recent
        {
            
            data [ operationType - 1 ] [ 0 ] = "" ;
            data [ operationType - 1 ] [ 1 ] = "" ;
            data [ operationType - 1 ] [ 2 ] = "" ;
            data [ operationType - 1 ] [ 3 ] = "" ;
            data [ operationType - 1 ] [ 4 ] = "" ;
            data [ operationType - 1 ] [ 5 ] = "" ;
            data [ operationType - 1 ] [ 6 ] = "" ;
            data [ operationType - 1 ] [ 7 ] = "" ;
            trueDataMax -- ;
            trueDataEdit -- ;
            
        }
        else if ( operationType == 2 )//Clear all after the target
        {
            
            for ( int i = trueDataEdit + 1 ; i <= trueDataEdit ; i ++ )
            {
                
                data [i] [0] = "" ;
                data [i] [1] = "" ;
                data [i] [2] = "" ;
                data [i] [3] = "" ;
                data [i] [4] = "" ;
                data [i] [5] = "" ;
                data [i] [6] = "" ;
                data [i] [7] = "" ;
                
            }
            trueDataMax = trueDataEdit ;
            trueDataShow = trueDataEdit ;
            
        }
        
    }
    
    /**
     *  Collector Method
     *      Data Feed : Limit
     *      
     *          input   :   void
     *          output  :   integer trueDataShow
     */
    public int dataFeedLimit()
    {
        
        //return trueDataEdit ;
        return trueDataShow ;
        
    }
    
    /**
     *  Collecotr Method
     *      Data Feed : Max
     *          
     *          input   :   void
     *          output  :   integer trueDataMax
     */
    public int dataFeedMax()
    {
        
        return trueDataMax ;
        
    }
    
    /**
     *  Collector Method
     *      Data Feed : All Data of the object to be drawn
     *      
     *      input   :   int dataSlot
     *      output  :   String accessed array slot
     */
    public String dataFeedSpecific( int slot , int subSlot )
    {
        
        return data[slot][subSlot] ;
        
    }
    
    /**
     *  Setter Method
     *      Increase trueDataShow and trueDataEdit
     */
    public void dataIncrementSlotView( int increment )
    {
        
        trueDataShow += increment ;
        trueDataEdit += increment ;
        
    }
    
    /**
     *  Setter Method
     *      Update shape
     *      
     *      input   :   String with all data (In pre-determined format)
     *      output  :   void
     */
    public void oldShapeUpdate( String input )
    {
        
        String [] inputSplit = input.split(" ") ;
        data [ trueDataEdit ] [ 0 ] = inputSplit [ 0 ] ;
        data [ trueDataEdit ] [ 1 ] = inputSplit [ 1 ] ;
        data [ trueDataEdit ] [ 2 ] = inputSplit [ 2 ] ;
        data [ trueDataEdit ] [ 3 ] = inputSplit [ 3 ] ;
        data [ trueDataEdit ] [ 4 ] = inputSplit [ 4 ] ;
        data [ trueDataEdit ] [ 5 ] = inputSplit [ 5 ] ;
        if ( inputSplit.length == 8 ) //If input is that of a triangle
        {
            
            data [ trueDataEdit ] [ 6 ] = inputSplit [ 6 ] ;
            data [ trueDataEdit ] [ 7 ] = inputSplit [ 7 ] ;
            
        }
        
    }
    
    /**
     *  SetterMethod
     *      Finalize Shape
     *      
     *      input   :   String with all data (In pre-determined format)
     *      output  :   void
     */
    public void oldShapeFinalize( String input )
    {
        
        String [] inputSplit = input.split(" ") ;
        data [ trueDataEdit ] [ 0 ] = inputSplit [ 0 ] ;
        data [ trueDataEdit ] [ 1 ] = inputSplit [ 1 ] ;
        data [ trueDataEdit ] [ 2 ] = inputSplit [ 2 ] ;
        data [ trueDataEdit ] [ 3 ] = inputSplit [ 3 ] ;
        data [ trueDataEdit ] [ 4 ] = inputSplit [ 4 ] ;
        data [ trueDataEdit ] [ 5 ] = inputSplit [ 5 ] ;
        if ( inputSplit.length == 8 ) //If input is that of a triangle
        {
            
            data [ trueDataEdit ] [ 6 ] = inputSplit [ 6 ] ;
            data [ trueDataEdit ] [ 7 ] = inputSplit [ 7 ] ;
            
        }
        
        trueDataEdit ++ ;
        trueDataMax = trueDataEdit ; //Prevent the maximum from getting surpaseed in the case of an undo.
        //resync(0) ; //Resynchronize all trueDataVALUE variables to trueDataEdit to cancel out any redos.
        
    }
    
    /**
     *  Setter Method
     *      New Shape
     *      
     *      input   :   String with all data (In pre-determined format)
     *      output  :   void
     */
    public void newShapeStart( String input )
    {
        
        String [] inputSplit = input.split(" ") ;
        data [ trueDataEdit ] [ 0 ] = inputSplit [ 0 ] ;
        data [ trueDataEdit ] [ 1 ] = inputSplit [ 1 ] ;
        data [ trueDataEdit ] [ 2 ] = inputSplit [ 2 ] ;
        data [ trueDataEdit ] [ 3 ] = inputSplit [ 3 ] ;
        data [ trueDataEdit ] [ 4 ] = inputSplit [ 4 ] ;
        data [ trueDataEdit ] [ 5 ] = inputSplit [ 5 ] ;
        if ( inputSplit.length == 8 ) //If input is that of a triangle
        {
            
            data [ trueDataEdit ] [ 6 ] = inputSplit [ 6 ] ;
            data [ trueDataEdit ] [ 7 ] = inputSplit [ 7 ] ;
            
        }
        
        trueDataMax ++ ;
        trueDataShow ++ ;
        
    }
    
    /**
     *  Setter Method
     *      SET NEW SHAPE
     *      FOR TRANSFERRING SPECIFIC DATA FROM ONE DRAWData TO ANOTHER
     *      
     *      input   :   String with all data (In pre-determined format)
     *      output  :   void
     */
    public void setShape( String input )
    {
        
        String [] inputSplit = input.split(" ") ;
        data [ trueDataEdit ] [ 0 ] = inputSplit [ 0 ] ;
        data [ trueDataEdit ] [ 1 ] = inputSplit [ 1 ] ;
        data [ trueDataEdit ] [ 2 ] = inputSplit [ 2 ] ;
        data [ trueDataEdit ] [ 3 ] = inputSplit [ 3 ] ;
        data [ trueDataEdit ] [ 4 ] = inputSplit [ 4 ] ;
        data [ trueDataEdit ] [ 5 ] = inputSplit [ 5 ] ;
        if ( inputSplit.length == 8 ) //If input is that of a triangle
        {
            
            data [ trueDataEdit ] [ 6 ] = inputSplit [ 6 ] ;
            data [ trueDataEdit ] [ 7 ] = inputSplit [ 7 ] ;
            
        }
        
        trueDataMax ++ ;
        trueDataShow ++ ;
        trueDataEdit ++ ;
        trueDataMax = trueDataEdit ;
        
    }
    
    /**
     *  Setter Method
     *      Resync data slot operation deciders
     *      
     *      input   :   integer OperationType
     *      output  :   void
     *                  Change trueDataMax, trueDataShow, and trueDataEdit values based on input.
     */
    public void resync( int operationType )
    {
        
        switch( operationType )
        {
            
            case 1 : // DEFAULT : Synchronize all based on trueDataEdit
                trueDataMax = trueDataEdit ;
                trueDataShow = trueDataEdit ;
                break ;
                
            case 2 : // SPECIAL : Synchrnoize all based on trueDataMax
                trueDataShow = trueDataMax ;
                trueDataEdit = trueDataMax ;
                break ;
                
            case 3 : // SPECIAL : Synchronize all based on trueDataShow
                trueDataMax = trueDataShow ;
                trueDataEdit = trueDataShow ;
                break ;
            
        }
        
    }
    
}