import java.awt.* ;
import java.awt.event.* ;
import java.awt.GridLayout.* ;
import javax.swing.* ;
import java.text.NumberFormat ;
import java.text.ParsePosition ;
import java.util.Scanner ;
import javax.tools.* ;
import java.lang.Runtime ;

/**
 * Paint Program
 *  Mark 2
 *          (Main program overhaul)
 *          
 * Create a paint program!
 * 
 * @author Agent_BENNETTE (Edwin Pan)
 * @version Mark 2 Version 1
 */
public class PaintProgramMk6
{
    
    //Create all instance variables
    private static String drawSHAPE  = "fillRect" ;      //Shape datafield
    private static String drawCOLOR  = "black" ;         //Color datafield
    private static String drawString = "" ;              //Text input datafield
    private static String temp = "" ;                    //String datafield used as placeholder.
    private static int mouseCoordXA = 0 ;       //Start X Coordinate
    private static int mouseCoordYA = 0 ;       //Start Y Coordinate
    private static int mouseCoordXB = 0 ;       //End X Coordinate
    private static int mouseCoordYB = 0 ;       //End Y Coordinate
    private static int mouseCoordXC = 0 ;       //Triangle's Third X Coordinate
    private static int mouseCoordYC = 0 ;       //Triangle's Third Y Coordinate
    private static boolean mouseToggle = false ; // Decides whether or not preview system applies
    private static int mouseSetABC     = 1 ; //Decides what the mouse is currently inputting into: coords A, B, or C
    private static int stringFontSize = 12 ;
    //Paint Program Frame
    private static JFrame MAINFrame = new JFrame("Paint Program Mark VI") ;  //FRAME CREATION
    private static JPanel MAINLeftPanel = new JPanel() ;
    private static JPanel MAINRightPanel = new JPanel() ;
    
    //Program Mechanics-Necessary Components
    static DRAWPanel board          = new DRAWPanel() ;      //DRAWPanel CREATION
    static int canvasSizeX = 0 ;
    static int canvasSizeY = 0 ;
    static DRAWData database        = new DRAWData() ;       //DRAWData Variable CREATION
    
    //Colour Frame
    private static JPanel COLOURPanel           = new JPanel() ;
    private static JPanel COLOURPanelColour     = new JPanel() ;
    private static JPanel COLOURPanelButtons    = new JPanel() ;
    static JButton COLOURButtonBlack       = new JButton() ;
    static JButton COLOURButtonWhite       = new JButton() ;
    static JButton COLOURButtonRed         = new JButton() ;
    static JButton COLOURButtonGreen       = new JButton() ;
    static JButton COLOURButtonBlue        = new JButton() ;
    static JButton COLOURButtonYellow      = new JButton() ;
    
    //Shape Frame
    private static JPanel SHAPEPanel                = new JPanel() ;    //Frame Creation
    static JButton SHAPEButtonString           = new JButton("String") ;
    static JButton SHAPEButtonLine             = new JButton("Line") ;
    static JButton SHAPEButtonFillRect         = new JButton("Rectangle (Filled)") ;
    static JButton SHAPEButtonDrawRect         = new JButton("Rectangle (Hollow)") ;
    static JButton SHAPEButtonFillOval         = new JButton("Oval (Filled)") ;
    static JButton SHAPEButtonDrawOval         = new JButton("Oval (Hollow)") ;
    static JButton SHAPEButtonFillPoly         = new JButton("Triangle (Filled)") ;
    static JButton SHAPEButtonDrawPoly         = new JButton("Triangle (Hollow)") ;
    
    //Utility Frame
    private static JPanel UTILITYPanel              =   new JPanel() ;
    private static JTextArea UTILITYPanelHistory    =   new JTextArea() ;
    private static JScrollPane UTILITYPanelHistoryScroll = new JScrollPane( UTILITYPanelHistory ) ;
    private static JPanel UTILITYPanelButtons       =   new JPanel() ;
    static JButton UTILITYButtonClear   =   new JButton("Clear") ;
    static JButton UTILITYButtonUndo    =   new JButton("Undo") ;
    static JButton UTILITYButtonRedo    =   new JButton("Redo") ;
    static JButton UTILITYButtonSave    =   new JButton("Save") ;
    static JButton UTILITYButtonLoad    =   new JButton("Load") ;
    static OPERATORHistory_Writer HistoryWriter   =   new OPERATORHistory_Writer() ;
    static OPERATORHistory_Reader HistoryReader   =   new OPERATORHistory_Reader() ;
    
    /**
     *      MAIN METHOD
     */
    public static void main ( String [] args )
    {
        
        /*
         *  SET UP ALL LISTENING OBJECTS
         */
        
        MouseHandler inputMouseButtons = new MouseHandler() ;
        MouseMotionHandler inputMouseMotions = new MouseMotionHandler() ;
        board.addMouseListener( inputMouseButtons ) ;
        board.addMouseMotionListener( inputMouseMotions ) ;
        ButtonHandler inputButtons = new ButtonHandler() ;
        COLOURButtonBlack.addActionListener( inputButtons ) ;
        COLOURButtonWhite.addActionListener( inputButtons ) ;
        COLOURButtonRed.addActionListener( inputButtons ) ;
        COLOURButtonGreen.addActionListener( inputButtons ) ;
        COLOURButtonBlue.addActionListener( inputButtons ) ;
        COLOURButtonYellow.addActionListener( inputButtons ) ;
        SHAPEButtonString.addActionListener( inputButtons ) ;
        SHAPEButtonLine.addActionListener( inputButtons ) ;
        SHAPEButtonFillRect.addActionListener( inputButtons ) ;
        SHAPEButtonDrawRect.addActionListener( inputButtons ) ;
        SHAPEButtonFillOval.addActionListener( inputButtons ) ;
        SHAPEButtonDrawOval.addActionListener( inputButtons ) ;
        SHAPEButtonFillPoly.addActionListener( inputButtons ) ;
        SHAPEButtonDrawPoly.addActionListener( inputButtons ) ;
        UTILITYButtonClear.addActionListener( inputButtons ) ;
        UTILITYButtonRedo.addActionListener( inputButtons ) ;
        UTILITYButtonUndo.addActionListener( inputButtons ) ;
        UTILITYButtonSave.addActionListener( inputButtons ) ;
        UTILITYButtonLoad.addActionListener( inputButtons ) ;
        
        /*
         *  MAIN-FRAME PROPERTIES
         */
        
        //Now at the end
        //MAINFrame.setMinimumSize( new Dimension ( 1280 , 640 ) ) ;
        //MAINFrame.setMaximumSize( new Dimension ( 1280 , 640 ) ) ;
        
        
        
        /*
         *  COLOUR-FRAME PROPERTIES
         */
        
        COLOURPanelButtons.setLayout( new GridLayout( 3 , 2 ) ) ;
        
        COLOURButtonBlack.setBackground( Color.black ) ;
        COLOURButtonWhite.setBackground( Color.white ) ;
        COLOURButtonRed.setBackground( Color.red ) ;
        COLOURButtonGreen.setBackground( Color.green ) ;
        COLOURButtonBlue.setBackground( Color.blue ) ;
        COLOURButtonYellow.setBackground( Color.yellow ) ;
        
        COLOURPanelButtons.add( COLOURButtonBlack ) ;
        COLOURPanelButtons.add( COLOURButtonWhite ) ;
        COLOURPanelButtons.add( COLOURButtonRed ) ;
        COLOURPanelButtons.add( COLOURButtonGreen ) ;
        COLOURPanelButtons.add( COLOURButtonBlue ) ;
        COLOURPanelButtons.add( COLOURButtonYellow ) ;
        
        COLOURPanelButtons.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        
        COLOURPanelColour.setBackground( Color.black ) ;
        
        COLOURPanelColour.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        
        COLOURPanel.setMinimumSize( new Dimension( 256 , 196 ) ) ;
        COLOURPanelColour.setMinimumSize( new Dimension( 256 , 32 ) ) ;
        COLOURPanelColour.setPreferredSize( new Dimension( 256 , 32 ) ) ;
        COLOURPanelButtons.setMinimumSize( new Dimension( 256 , 160 ) ) ;
        COLOURPanelButtons.setPreferredSize( new Dimension( 256 , 160 ) ) ;
        
        COLOURPanel.setLayout( new BorderLayout() ) ;
        
        COLOURPanel.add( COLOURPanelColour , BorderLayout.PAGE_START ) ;
        COLOURPanel.add( COLOURPanelButtons , BorderLayout.PAGE_END ) ;
        
        COLOURPanel.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        
        
        
        /*
         *  SHAPE-FRAME PROPERTIES
         */
        
        SHAPEPanel.setLayout( new GridLayout ( 4 , 2 ) ) ;
        
        SHAPEButtonString.setBackground( Color.lightGray ) ;
        SHAPEButtonLine.setBackground( Color.lightGray ) ;
        SHAPEButtonFillRect.setBackground( Color.darkGray ) ;
        SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
        SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
        SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
        SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
        SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
        
        SHAPEPanel.add( SHAPEButtonString ) ;
        SHAPEPanel.add( SHAPEButtonLine ) ;
        SHAPEPanel.add( SHAPEButtonFillRect ) ;
        SHAPEPanel.add( SHAPEButtonDrawRect ) ;
        SHAPEPanel.add( SHAPEButtonFillOval ) ;
        SHAPEPanel.add( SHAPEButtonDrawOval ) ;
        SHAPEPanel.add( SHAPEButtonFillPoly ) ;
        SHAPEPanel.add( SHAPEButtonDrawPoly ) ;
        
        SHAPEPanel.setMinimumSize( new Dimension( 256 , 196 ) ) ;
        SHAPEPanel.setPreferredSize( new Dimension( 256 , 196 ) ) ;
        //SHAPEPanel.setMaximumSize( new Dimension( 256 , 196 ) ) ;
        
        SHAPEPanel.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        
        
        
        /*
         *  UTILITY-FRAME PROPERTIES
         */
        
        UTILITYPanelButtons.setLayout( new GridLayout( 5 , 1 ) ) ;
        
        UTILITYPanelButtons.add( UTILITYButtonClear ) ;
        UTILITYPanelButtons.add( UTILITYButtonRedo ) ;
        UTILITYPanelButtons.add( UTILITYButtonUndo ) ;
        UTILITYPanelButtons.add( UTILITYButtonSave ) ;
        UTILITYPanelButtons.add( UTILITYButtonLoad ) ;
        
        UTILITYPanel.setMinimumSize( new Dimension( 256 , 248 ) ) ;
        UTILITYPanelHistoryScroll.setMinimumSize( new Dimension( 256 , 152 ) ) ;
        UTILITYPanelHistoryScroll.setPreferredSize( new Dimension( 256 , 152 ) ) ;
        UTILITYPanelButtons.setMinimumSize( new Dimension( 256 , 96 ) ) ;
        
        UTILITYPanel.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        UTILITYPanelHistory.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        UTILITYPanelButtons.setBorder( BorderFactory.createMatteBorder( 4 , 4 , 4 , 4 , Color.black ) ) ;
        
        UTILITYPanel.setLayout( new BorderLayout() ) ;
        
        UTILITYPanel.add( UTILITYPanelHistoryScroll , BorderLayout.NORTH ) ;
        UTILITYPanel.add( UTILITYPanelButtons , BorderLayout.SOUTH ) ;
        
        
        
        
        /*
         *  LEFT MAIN PANEL FRAME PROPERTIES
         *  MAKE SURE IT'S VERTICAL
         */
        
        MAINLeftPanel.setLayout( new BorderLayout() ) ;
        
        MAINLeftPanel.setMinimumSize( new Dimension( 256 , 640 ) ) ;
        MAINLeftPanel.setMaximumSize( new Dimension( 256 , 1080 ) ) ;
        
        MAINLeftPanel.add( COLOURPanel , BorderLayout.PAGE_START ) ;
        MAINLeftPanel.add( SHAPEPanel , BorderLayout.CENTER ) ;
        MAINLeftPanel.add( UTILITYPanel , BorderLayout.PAGE_END ) ;
        
        
        /*
         *  SET UP BOARD PROPERTIES
         */
        
        while ( canvasSizeX < 600 || canvasSizeX > 1664 )
        {
            
            canvasSizeX = Integer.parseInt( JOptionPane.showInputDialog("Please enter the width of the canvas (pixels).\nThe value must be between 600 and 1664.") ) ;
            
        }
        
        while ( canvasSizeY < 600 || canvasSizeY > 1080 )
        {
            
            canvasSizeY = Integer.parseInt( JOptionPane.showInputDialog("Please enter the height of the canvas (pixels).\nThe value must be between 600 and 1080.") ) ;
            
        }
        
        board.setDimensionsPreference( canvasSizeX , canvasSizeY ) ;
        
        String inputColour = JOptionPane.showInputDialog("Please enter a colour for the canvas (Default is light gray)") ;
        board.setBackground( Color.lightGray ) ;
        if ( inputColour.equalsIgnoreCase("Black") )
        {
            
            board.setBackground( Color.black ) ;
            board.setBackgroundColourPreference( Color.black ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Gray") )
        {
            
            board.setBackground( Color.gray ) ;
            board.setBackgroundColourPreference( Color.gray ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("White") )
        {
            
            board.setBackground( Color.white ) ;
            board.setBackgroundColourPreference( Color.white ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Magenta") )
        {
            
            board.setBackground( Color.magenta ) ;
            board.setBackgroundColourPreference( Color.magenta ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Pink") )
        {
            
            board.setBackground( Color.pink ) ;
            board.setBackgroundColourPreference( Color.pink ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Red") )
        {
            
            board.setBackground( Color.red ) ;
            board.setBackgroundColourPreference( Color.red ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Green") )
        {
            
            board.setBackground( Color.green ) ;
            board.setBackgroundColourPreference( Color.green ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Blue") )
        {
            
            board.setBackground( Color.blue ) ;
            board.setBackgroundColourPreference( Color.blue ) ;
            
        }
        else if ( inputColour.equalsIgnoreCase("Yellow") )
        {
            
            board.setBackground( Color.yellow ) ;
            board.setBackgroundColourPreference( Color.yellow ) ;
            
        }
        
        board.setPreferredSize( new Dimension( canvasSizeX , canvasSizeY ) ) ;
        
        
        
        /*
         *  RIGHT MAIN PANEL FRAME PROPERTIES
         */
        
        MAINRightPanel.setMinimumSize( new Dimension ( 1024 , 640 ) ) ;
        //MAINRightPanel.setSize( new Dimension ( 1000 , 600 ) ) ;
        
        
        MAINRightPanel.add( board ) ;
        
        
        
        /*
         *  MAIN FRAME PROPERTIES
         */
        
        MAINFrame.setLayout( new BorderLayout() ) ;
        MAINFrame.setMinimumSize( new Dimension( 1280 , 640 ) ) ;
        MAINFrame.setMaximumSize( new Dimension( 1920 , 1080 ) ) ;
        MAINFrame.setPreferredSize( new Dimension( 1280 , 640 ) ) ;
        
        MAINFrame.add( MAINLeftPanel , BorderLayout.WEST ) ;
        MAINFrame.add( MAINRightPanel , BorderLayout.CENTER ) ;
        
        
        /*
         *  FRAME START
         */
        MAINFrame.setResizable( true ) ;
        MAINFrame.setVisible( true ) ;
        MAINFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
        
        
        
        /*
         *  SPECIAL CASE : CANVAS LARGER THAN 600 600
         */
        if ( canvasSizeX > 600 || canvasSizeY > 600 )
        {
            
            MAINFrame.setSize( 1920 , 1080 ) ;
            MAINFrame.setResizable( false ) ;
            
        }
        
        
        
        //Kickstart the history pane.
        updateHistory() ;
        
    }
    
    
    
    /**
     *      PRODUCER METHOD
     *          Processor Coordinates
     *          
     *              Create the appropriate coordinate / width values needed for the shape.
     *              
     */
    public static String coordProducer()
    {
        
        String output = "" ;
        
        if ( drawSHAPE.equals("drawLine") )
        {
            
            output = Integer.toString( mouseCoordXA ) + " " + Integer.toString( mouseCoordYA ) + " " + Integer.toString( mouseCoordXB ) + " " + Integer.toString( mouseCoordYB ) ;
            
        }
        else if ( drawSHAPE.equals("drawPoly") || drawSHAPE.equals("fillPoly") )
        {
            
            output = Integer.toString( mouseCoordXA ) + " " + Integer.toString( mouseCoordYA ) + " " + Integer.toString( mouseCoordXB ) + " " + Integer.toString( mouseCoordYB ) + " " + Integer.toString( mouseCoordXC ) + " " + Integer.toString( mouseCoordYC );
            
        }
        else
        {
            
            if ( mouseCoordXA <= mouseCoordXB && mouseCoordYA <= mouseCoordYB ) //Bottom-right Quadrant of A
            {
                
                output = Integer.toString( mouseCoordXA ) + " " + Integer.toString( mouseCoordYA ) + " " + Integer.toString( mouseCoordXB ) + " " + Integer.toString( mouseCoordYB ) ;
                
            }
            else if ( mouseCoordXA >= mouseCoordXB && mouseCoordYA <= mouseCoordYB ) //Bottom-left Quadrant of A
            {
                
                output = Integer.toString( mouseCoordXB ) + " " + Integer.toString( mouseCoordYA ) + " " + Integer.toString( mouseCoordXA ) + " " + Integer.toString( mouseCoordYB ) ;
                
            }
            else if ( mouseCoordXA >= mouseCoordXB && mouseCoordYA >= mouseCoordYB ) //Top-left Quadrant of A
            {
                
                output = Integer.toString( mouseCoordXB ) + " " + Integer.toString( mouseCoordYB ) + " " + Integer.toString( mouseCoordXA ) + " " + Integer.toString( mouseCoordYA ) ;
                
            }
            else if ( mouseCoordXA <= mouseCoordXB && mouseCoordYA >= mouseCoordYB ) //Top-right Quadrant of A
            {
                
                output = Integer.toString( mouseCoordXA ) + " " + Integer.toString( mouseCoordYB ) + " " + Integer.toString( mouseCoordXB ) + " " + Integer.toString( mouseCoordYA ) ;
                
            }
            
        }
        
        return output ;
        
    }
    
    
    
    /**
     *      UPDATER METHOD
     *          Updates the history text field's data.
     *          
     *              Basically, turn all of the data in the dastabase into legible, displayed text.
     */
    public static void updateHistory()
    {
        
        String output = "" ;
        int min = 0 ;
        int max = 0 ;
        if ( database.dataFeedLimit() < 20 )
        {
            
            max = database.dataFeedLimit() ;
            
        }
        else
        {
            
            max = database.dataFeedLimit() ;
            min = max - 20 ;
            
        }
        
        for ( ; min < max ; min ++ )
        {
            
            output = output + Integer.toString( min + 1 ) + ":" ;
            output = output + " " + database.dataFeedSpecific( min , 0 ) ;
            output = output + " " + database.dataFeedSpecific( min , 1 ) ;
            output = output + " " + database.dataFeedSpecific( min , 2 ) ;
            output = output + " " + database.dataFeedSpecific( min , 3 ) ;
            output = output + " " + database.dataFeedSpecific( min , 4 ) ;
            output = output + " " + database.dataFeedSpecific( min , 5 ) ;
            output = output + " " + database.dataFeedSpecific( min , 6 ) ;
            output = output + " " + database.dataFeedSpecific( min , 7 ) ;
            output = output + "\n" ;
            
        }
        
        UTILITYPanelHistory.setText(output) ;
        
    }
    
    
    
    
    
    
    /**
     *      LISTENER - MOUSE BUTTONS
     */
    private static class MouseHandler implements MouseListener
    {
        
        /**
         *  THIS IS FOR THE START
         */
        public void mousePressed(MouseEvent e)
        {
            
            switch ( mouseSetABC )
            {
                
                case 1 :
                    if ( drawSHAPE.equals("drawString") )
                    {
                        
                        drawString = JOptionPane.showInputDialog("Please input a string for your String line. \n(Avoid spaces as they are buggy)") ;
                        
                        temp = "nope" ;
                        for ( int tries = 1 ; isNumeric(temp) == false ; tries ++ )
                        {
                            
                            if ( tries == 1 )
                            {
                                
                                temp = JOptionPane.showInputDialog("Please input the font size you wish to use.") ;
                                
                            }
                            else
                            {
                                
                                temp = JOptionPane.showInputDialog("Please input NUMBERS to be used as font size. " /*+ (int)'0' + " " + (int)'9'*/ ) ;
                                
                            }
                            
                        }
                        
                        mouseCoordXA = e.getX() ;
                        mouseCoordYA = e.getY() ;
                        mouseCoordXB = e.getX() ;
                        mouseCoordYB = e.getY() ;
                        mouseCoordXC = e.getX() ;
                        mouseCoordYC = e.getY() ;
                        /*
                        String [] drawStringSplit = drawString.split(" ") ;
                        String drawString = drawStringSplit [ 0 ] ;
                        for ( int i = 1 ; i < drawStringSplit.length ; i ++ )
                        {
                            
                            drawString = drawString + "~" + drawStringSplit [ i ] ;
                            
                        }
                        */
                        database.newShapeStart( "drawString " + drawString + " " + coordProducer() + " " + temp + " null" ) ;
                        database.oldShapeFinalize( "drawString " + drawString + " " + coordProducer() + " " + temp + " null") ;
                        board.setData( database ) ;
                        board.repaint() ;
                        
                            //Developper's Purpose Only!
                            //System.out.println("mousePressed : CASE 1 : drawString") ;
                    
                    }
                    else
                    {
                        mouseSetABC = 2 ;
                        mouseToggle = true ;
                        board.setPreview( true ) ;
                        mouseCoordXA = e.getX() ;
                        mouseCoordYA = e.getY() ;
                        mouseCoordXB = e.getX() ;
                        mouseCoordYB = e.getY() ;
                        mouseCoordXC = e.getX() ;
                        mouseCoordYC = e.getY() ;
                        database.newShapeStart( drawSHAPE + " " + drawCOLOR + " " + coordProducer() ) ;
                        board.setData( database ) ;
                        board.repaint() ;
                        
                            //Developper's Purpose Only!
                            //System.out.println("mousePressed : CASE 1 : else") ;
                        
                    }
                        //Developper's Usage only!
                        //System.out.println("Click: Case 1") ;
                    break ;
                    
                case 2 :
                    if ( drawSHAPE.equals("drawPoly") || drawSHAPE.equals("fillPoly") )
                    {
                        
                        mouseSetABC = 3 ;
                        mouseCoordXB = e.getX() ;
                        mouseCoordYB = e.getY() ;
                        database.oldShapeUpdate( drawSHAPE + " " + drawCOLOR + " " + coordProducer() ) ;
                        board.setData( database ) ;
                        board.repaint() ;
                        
                            //Developper's Purpose Only!
                            //System.out.println("mousePressed : CASE 2 : triangle") ;
                        
                    }
                    else
                    {
                        
                        mouseSetABC = 1 ;
                        mouseToggle = false ;
                        board.setPreview( false ) ;
                        mouseCoordXB = e.getX() ;
                        mouseCoordYB = e.getY() ;
                        database.oldShapeFinalize( drawSHAPE + " " + drawCOLOR + " " + coordProducer() ) ;
                        board.setData( database ) ;
                        board.repaint() ;
                        
                            //Developper's Purpose Only!
                            //System.out.println("mousePressed : CASE 2 : else") ;
                        
                    }
                        //Developper's Usage only!
                        //System.out.println("Click: Case 2") ;
                    break ;
                
                case 3 :
                    mouseSetABC = 1 ;
                    mouseToggle = false ;
                    board.setPreview( false ) ;
                    mouseCoordXC = e.getX() ;
                    mouseCoordYC = e.getY() ;
                    //database.oldShapeUpdate( drawSHAPE + " " + drawCOLOR + " " + coordProducer() ) ;
                    database.oldShapeFinalize( drawSHAPE + " " + drawCOLOR + " " + coordProducer() ) ;
                    board.setData( database ) ;
                    board.repaint() ;
                        
                        //Developper's Purpose Only!
                        //System.out.println("mousePressed : CASE 1 : drawString") ;
                            
                    break ;
                
                }
                
            updateHistory() ;
            
        }
        
        /**
         *  THIS IS FOR THE END ( HELD )
         */
        public void mouseReleased(MouseEvent e)
        {
            
            
            
        }
        
        public void mouseClicked(MouseEvent e){}
        
        /**
         *  INPUT:  NEW DRAW DATA
         */
        private void mouseInput()
        {
            
            
            
        }
        
        public void mouseEntered(MouseEvent e){}
        
        public void mouseExited(MouseEvent e){}
        
        public boolean isNumeric(String str) //Check if all characters of the string are numeric.
        {  
            
            boolean output = true ;
            char [] temp = str.toCharArray() ;
            for ( int checking = 0 ; checking < temp.length ; checking ++ )
            {
                
                if ( (int)(temp[checking]) < 48 || (int)(temp[checking]) > 57 )
                {
                    
                    output = false ;
                    break ;
                    
                }
                
            }
            
            return output ;
            
        }
        
    }
    
    
    
    
    
    /**
     *      LISTENER - MOUSE BUTTONS
     */
    private static class MouseMotionHandler implements MouseMotionListener
    {
        
        public void mouseDragged( MouseEvent e ){}
        
        public void mouseMoved( MouseEvent e )
        {
            
            if ( mouseToggle )
            {
                
                switch ( mouseSetABC )
                {
                    
                    case 2 : 
                        mouseCoordXB = e.getX() ;
                        mouseCoordYB = e.getY() ;
                        database.oldShapeUpdate( drawSHAPE + " preview " + coordProducer() ) ;
                        board.setData( database ) ;
                        board.repaint() ;
                        
                        break ;
                    
                    case 3 :
                        mouseCoordXC = e.getX() ;
                        mouseCoordYC = e.getY() ;
                        database.oldShapeUpdate( drawSHAPE + " preview " + coordProducer() ) ;
                        board.setData( database ) ;
                        board.repaint() ;
                        break;
                    
                }
                
            }
            
            updateHistory() ;
            
        }
       
    }
        
    
    
    
    
    
    
    /**
     *      LISTENER - BUTTONS
     */
    private static class ButtonHandler implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            
            /*
             *      COLOUR BUTTONS
             */
            
            if ( e.getSource() == COLOURButtonBlack )
            {
                
                drawCOLOR = "black" ;
                COLOURPanelColour.setBackground( Color.black ) ;
                
            }
            
            if ( e.getSource() == COLOURButtonWhite )
            {
                
                drawCOLOR = "white" ;
                COLOURPanelColour.setBackground( Color.white ) ;
                
            }
            
            if ( e.getSource() == COLOURButtonRed )
            {
                
                drawCOLOR = "red" ;
                COLOURPanelColour.setBackground( Color.red ) ;
                
            }
            
            if ( e.getSource() == COLOURButtonGreen )
            {
                
                drawCOLOR = "green" ;
                COLOURPanelColour.setBackground( Color.green ) ;
                
            }
            
            if ( e.getSource() == COLOURButtonBlue )
            {
                
                drawCOLOR = "blue" ;
                COLOURPanelColour.setBackground( Color.blue ) ;
                
            }
            
            if ( e.getSource() == COLOURButtonYellow )
            {
                
                drawCOLOR = "yellow" ;
                COLOURPanelColour.setBackground( Color.yellow ) ;
                
            }
            
            
            
            /*
             *      SHAPE BUTTONS
             */
            
            if ( e.getSource() == SHAPEButtonString )
            {
                
                drawSHAPE = "drawString" ;
                SHAPEButtonString.setBackground( Color.darkGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonLine )
            {
                
                drawSHAPE = "drawLine" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.darkGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonFillRect )
            {
                
                drawSHAPE = "fillRect" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.darkGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonDrawRect )
            {
                
                drawSHAPE = "drawRect" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.darkGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonFillOval )
            {
                
                drawSHAPE = "fillOval" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.darkGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonDrawOval )
            {
                
                drawSHAPE = "drawOval" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.darkGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonDrawPoly )
            {
                
                drawSHAPE = "drawPoly" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.darkGray ) ;
                
            }
            
            if ( e.getSource() == SHAPEButtonFillPoly )
            {
                
                drawSHAPE = "fillPoly" ;
                
                SHAPEButtonString.setBackground( Color.lightGray ) ;
                SHAPEButtonLine.setBackground( Color.lightGray ) ;
                SHAPEButtonFillRect.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawRect.setBackground( Color.lightGray ) ;
                SHAPEButtonFillOval.setBackground( Color.lightGray ) ;
                SHAPEButtonDrawOval.setBackground( Color.lightGray ) ;
                SHAPEButtonFillPoly.setBackground( Color.darkGray ) ;
                SHAPEButtonDrawPoly.setBackground( Color.lightGray ) ;
                
            }
            
            if ( e.getSource() == UTILITYButtonClear )
            {
                
                if ( database.dataFeedLimit() > 0 )
                {
                
                    if( database.dataFeedSpecific( database.dataFeedLimit() - 1 , 0 ).equals("CLEAR") )
                    {
                    
                        database.dataSetClear(0) ;
                    
                    }
                    else
                    {
                    
                        database.newShapeStart("CLEAR again to clear all shapes.") ;
                        database.oldShapeFinalize("CLEAR again to clear all shapes.") ;
                        
                        board.setData( database ) ;
                        board.repaint() ;
                    
                    }
                    
                }
                
            }
            
            if ( e.getSource() == UTILITYButtonRedo )
            {
                
                if ( database.dataFeedLimit() < database.dataFeedMax() )
                {
                    
                    database.dataIncrementSlotView(1) ;
                    
                    board.setData( database ) ;
                    board.repaint() ;
                    
                }
                
            }
            
            if ( e.getSource() == UTILITYButtonUndo )
            {
                
                if ( database.dataFeedLimit() > 0 )
                {
                    
                    database.dataIncrementSlotView(-1) ;
                    
                    board.setData( database ) ;
                    board.repaint() ;
                    
                }
                
            }
            
            if ( e.getSource() == UTILITYButtonSave )
            {
                
                HistoryWriter.setDirectory() ;
                
                try 
                {
                    
                    HistoryWriter.Save( database ) ;
                    
                }
                catch ( Exception exception )
                {
                    
                    System.out.println("An error has occured while saving.") ;
                    
                }
                
            }
            
            if ( e.getSource() == UTILITYButtonLoad )
            {
                
                String dir = JOptionPane.showInputDialog("Please input the file name:") ;
                
                HistoryReader.setDirectory( dir ) ;
                try
                {
                    
                    HistoryReader.read() ;
                    database = HistoryReader.getData() ;
                    
                    board.setData( database ) ;
                    board.repaint() ;
                    
                }
                catch ( Exception exception )
                {
                    
                    System.out.println("An error has occured while reading the file.") ;
                    
                }
                
            }
            
            
            
            
            /*
             *  Update History System
             *  Always update history at any change.
             */
            updateHistory() ;
            
        }
        
    }
    
}