import javax.swing.* ;
import javax.tools.* ;
import java.awt.* ;

/**
 *      Custom Object Class - JPanel as DRAWPanel
 *      
 *      This object is a variant of JPanel, specialized to be able to do what the program necessitates.
 *      The DRAWPanel will be use the data feed from DRAWData to constantly refresh and re-draw itself.
 */
class DRAWPanel extends JPanel
{
    
    DRAWData input = new DRAWData() ;
    boolean previewToggle = false ;
    int panelWidth = 600 ;
    int panelHeight = 600 ;
    Color panelColour = Color.lightGray ;
    
    /**
     *  Constructor Method of DRAWPanel
     */
    public DRAWPanel()
    {
        
        setBorder( BorderFactory.createLineBorder(Color.black) ) ;
        setBackground( Color.white ) ;
        
    }
    
    /**
     *  Collector Method
     *      Collect the dimension field.
     *      
     *      input   :   void
     *      output  :   Dimension Preference of the JPanel's preference
     */
    //public Dimension getPreferredSize()
    //{
    //    
    //    return new Dimension( 600 , 600 ) ;
    //    
    //}
    
    /**
     *  Setter Method
     *      Get DRAWData information
     *      
     *          input   :   DRAWData data
     *          output  :   void
     */
    public void setData( DRAWData data )
    {
        
        input = data ;
        
    }
    
    /**
     *  Setter Method
     *      Set whether or not the board will draw an additional shape - the one that's being drawn live
     *      
     *          input   :   boolean view or not view?
     *          output  :   void
     */
    public void setPreview( boolean view )
    {
        
        previewToggle = view ;
        
    }
    
    /**
     *  Setter Method
     *      Input the dimensions of this panel.
     *      
     *          input   :   int width , int height
     *          outpu   :   void
     */
    public void setDimensionsPreference( int width , int height )
    {
        
        panelWidth = width ;
        panelHeight = height ;
        
    }
    
    /**
     *  Setter Method
     *      Set the background colour of the board.
     */
    public void setBackgroundColourPreference( Color colour )
    {
        
        panelColour = colour ;
        this.setBackground( colour ) ;
        this.repaint() ;
        
    }
    
    /**
     *  Operation Method
     *      Draw all shapes on the drawing board
     *      
     *          input   :   void
     *          output  :   void
     */
    public void paintComponent( Graphics g )
    {
        
        //Set up Paint Component. I think that's what it does anyway.
        super.paintComponent(g) ;
        
        //Set up the read string
        String [] data = new String [6] ;
        
        //Set up the number of shapes to be drawn
        int limit = input.dataFeedLimit() ;
        if ( previewToggle )
        {
            
            limit ++ ;
            
        }
        
        //Begin drawing each polygon
        for ( int i = 0 ; i < input.dataFeedLimit() ; i ++ )
        {
            
            //Set up the data into a read-able format
            data [0] = input.dataFeedSpecific(i,0) ; // Polygon Type
            data [1] = input.dataFeedSpecific(i,1) ; // Color
            data [2] = input.dataFeedSpecific(i,2) ; // first X
            data [3] = input.dataFeedSpecific(i,3) ; // first Y
            data [4] = input.dataFeedSpecific(i,4) ; // second X
            data [5] = input.dataFeedSpecific(i,5) ; // second Y
            //if ( input.dataFeedSpecific(i,6).equals("") == false )
            //{
            //    
            //    data [6] = input.dataFeedSpecific(i,6) ; // third X
            //    data [7] = input.dataFeedSpecific(i,7) ; // third Y
            //    
            //}
            
            
            //Set the color
            g.setColor(Color.magenta) ;
            switch ( data[1] )
            {
                
                case "black" :
                    g.setColor(Color.black) ;
                    break ;
                
                case "white" :
                    g.setColor(Color.white) ;
                    break ;
                    
                case "red" :
                    g.setColor(Color.red) ;
                    break ;
                    
                case "blue" :
                    g.setColor(Color.blue) ;
                    break ;
                    
                case "green" :
                    g.setColor(Color.green) ;
                    break ;
                    
                case "yellow" :
                    g.setColor(Color.yellow) ;
                    break ;
                
                case "preview" :
                    g.setColor(Color.gray) ;
                    break ;
                
            }
            
            //Draw the object
            switch  ( data [0] )
            {
                
                case "drawString" :
                    g.setColor( Color.black ) ;
                    g.setFont( new Font( "TimesRoman" , Font.PLAIN , Integer.parseInt( input.dataFeedSpecific( i , 6 ) ) ) ) ;
                    g.drawString( data[1] , Integer.parseInt( data[2] ) , Integer.parseInt( data[3] ) ) ;
                    break ;
                    
                case "drawLine" :
                    g.drawLine( Integer.parseInt( data[2] ) , Integer.parseInt( data[3] ) , Integer.parseInt( data[4] ) , Integer.parseInt( data[5] ) ) ;
                    break ;
                    
                case "fillRect" :
                    g.fillRect( Integer.parseInt( data[2] ) , Integer.parseInt( data[3] ) , Integer.parseInt( data[4] ) - Integer.parseInt( data [ 2 ] ) , Integer.parseInt( data[5] ) - Integer.parseInt( data [ 3 ] ) ) ;
                    break ;
                    
                case "drawRect" :
                    g.drawRect( Integer.parseInt( data[2] ) , Integer.parseInt( data[3] ) , Integer.parseInt( data[4] ) - Integer.parseInt( data [ 2 ] ) , Integer.parseInt( data[5] ) - Integer.parseInt( data [ 3 ] ) ) ;
                    break ;
                    
                case "fillOval" :
                    g.fillOval( Integer.parseInt( data[2] ) , Integer.parseInt( data[3] ) , Integer.parseInt( data[4] ) - Integer.parseInt( data [ 2 ] ) , Integer.parseInt( data[5] ) - Integer.parseInt( data [ 3 ] ) ) ;
                    break ;
                    
                case "drawOval" :
                    g.drawOval( Integer.parseInt( data[2] ) , Integer.parseInt( data[3] ) , Integer.parseInt( data[4] ) - Integer.parseInt( data [ 2 ] ) , Integer.parseInt( data[5] ) - Integer.parseInt( data [ 3 ] ) ) ;
                    break ;
                    
                case "fillPoly" :
                    int [] triangleAXs = { Integer.parseInt( data[2] ) , Integer.parseInt( data[4] ) , Integer.parseInt( input.dataFeedSpecific( i , 6 ) ) } ;
                    int [] triangleAYs = { Integer.parseInt( data[3] ) , Integer.parseInt( data[5] ) , Integer.parseInt( input.dataFeedSpecific( i , 7 ) ) } ;
                    Polygon triangleA = new Polygon ( triangleAXs , triangleAYs, 3 ) ;
                    g.fillPolygon( triangleA ) ;
                    break ;
                    
                case "drawPoly" :
                    int [] triangleBXs = { Integer.parseInt( data[2] ) , Integer.parseInt( data[4] ) , Integer.parseInt( input.dataFeedSpecific( i , 6 ) ) } ;
                    int [] triangleBYs = { Integer.parseInt( data[3] ) , Integer.parseInt( data[5] ) , Integer.parseInt( input.dataFeedSpecific( i , 7 ) ) } ;
                    Polygon triangleB = new Polygon ( triangleBXs , triangleBYs, 3 ) ;
                    g.drawPolygon( triangleB ) ;
                    break ;
                    
                case "CLEAR" :
                    g.clearRect( 0 , 0 , panelWidth , panelHeight ) ;
                    g.setColor( panelColour ) ;
                    g.fillRect( 0 , 0 , panelWidth , panelHeight ) ;
                    break ;
                
            }
            
        }
        
    }
    
}