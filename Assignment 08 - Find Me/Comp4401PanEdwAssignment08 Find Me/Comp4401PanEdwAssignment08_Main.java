import java.awt.* ;
import java.awt.event.*  ;
import javax.swing.* ;
import java.lang.Math.* ;

/**
 * Main portion of the find me program
 * This is the main interface sector
 * 
 * @author Agent BENNETTE (Edwin Pan)
 * @version 1.0.1 - Last Edited 20150401
 */
public class Comp4401PanEdwAssignment08_Main
{
    
    /**
     *  INSTANCE OBJECTS AND VARIABLES
     */
    private static JFrame mainFrame = new JFrame("JFrame") ;
    private static gameMAP map = new gameMAP () ;
    private static JTextArea text = new JTextArea () ;
    private static int mouseXCoord = 0 ;
    private static int mouseYCoord = 0 ;
    private static int attemptsRemaining = 4 ;
    private static boolean clickValid = false ;
    
    
    
    /**
     *  MAIN METHOD
     */
    public static void main ( String [] args )
    {
        
        //Ensure that the game can proceed through user input.
        int enterGameInput = JOptionPane.showConfirmDialog( null , "Would you like to proceed with the Find Me program [COMP4401PanEdwAssignment08] ?" , "Prompt Pop Up - COMP4401PanEdwAssignment" , JOptionPane.YES_NO_OPTION ) ;
        if ( enterGameInput != 0 )
        {
            
            System.exit(0) ;
            
        }
        
        
        //Instruct the user on the game.
        JOptionPane.showMessageDialog ( null , 
                                        "\tWelcome to COMP4401 Assignment 8 by Edwin Pan's FIND ME Program. \n\tIn this game, you are required to find the tile that is differen from the other 255 (It's in a grid of 16 by 16 " + 
                                        "To confirm that you find it, you will be required to click on that tile. \nFailure to do so will result in in a loss of \"health points\" in the form of attempts. \nAfter failing 3 times," +
                                        " you will have lost all of those said health points, and lose the game. \nHowever, should you locate it before this happens, you will win the game." +
                                        "\n\n\t\tGood luck! \n\n\t\t\t(Tip, if you're lost, distance yourself from the screen. Literally.)" ) ;
        
        
        //Set up the main Frame
        mainFrame.setLayout ( new GridLayout ( 2 , 1 ) ) ;
        mainFrame.setSize ( 256 , 512 ) ;
        mainFrame.setResizable ( false ) ;
        
        //Edit the game interface's properties
        map.setSize ( 256 , 256 ) ;
        map.setBackground ( Color.lightGray ) ;
        MouseHandler mouseAction = new MouseHandler() ;
        map.addMouseListener( mouseAction ) ;
        
        //Edit the game textfield's properties
        text.setText ("To proceed, click on the map. \nAttemptsRemaining: 34") ;
        text.setSize ( 256 , 32 ) ;
        text.setEditable ( false ) ;
        text.setCaretPosition(0) ;
        
        //Begin the program.
        mainFrame.add( map ) ;
        mainFrame.add( text ) ;
        mainFrame.setVisible( true ) ;
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
        
    }
    
    
    
    /**
     *  OPERATOR METHOD
     *      Used to allow for the usage of a mouse.
     */
    private static class MouseHandler implements MouseListener {
        
        //Any clicking CHANGED? TO TRUE
        public void mousePressed(MouseEvent e) {
            
                //Developper's usage only!
                //System.out.println("mousePressed") ;
            
        }

        //Any clicking CHANGED? TO FALSE
        public void mouseReleased(MouseEvent e) {
            
                //Developper's usage only!
                //System.out.println("mouseReleased") ;
            
            if ( clickValid && attemptsRemaining != 0 )
            {
                
                if ( attemptsRemaining == 4 )
                {
                    
                    attemptsRemaining -- ;
                    text.setText ( "Attempts remaining : " + attemptsRemaining ) ;
                    map.setBackground ( Color.gray ) ;
                    
                }
                else
                {
                    
                    mouseXCoord = e.getX() ;
                    mouseYCoord = e.getY() ;
                
                        //Developper's usage only!
                        //System.out.println( "Mouse X : " + mouseXCoord ) ;
                        //System.out.println( "Mouse Y : " + mouseYCoord ) ;
                        //System.out.println( "Target X : " + map.getTargetXCoordinateSlot() ) ;
                        //System.out.println( "Target Y : " + map.getTargetYCoordinateSlot() ) ;
                        //System.out.println( "Distance: " + MMTargetDistance ( mouseXCoord , mouseYCoord ) ) ;
            
                    SRMUpdate ( ( MMTargetDistance ( mouseXCoord , mouseYCoord ) ) < 1.5 ) ;
                    
                }
                
            }
            
        }
        
        //Final Clicking location note. Useless to me. Might be useful later.
        public void mouseClicked(MouseEvent e) {
            
                //Developper's usage only!
                //System.out.println("mouseClicked") ;
            
        }

        //Mouse is inside the frame. Thus, any clicking is valid.
        public void mouseEntered(MouseEvent e) {
            
                //Developper's usage only!
                //System.out.println("mouseEntered") ;
            
            clickValid = true ;
            
        }

        //Mouse if outside the frame. Thus, any clicking is invalid.
        public void mouseExited(MouseEvent e) {
            
                //Developper's usage only!
                //System.out.println("mouseExited") ;
                
            clickValid = false ;
            
        }

    }    
    
    
    
    /**
     *  SUBROUTINE METHOD - Update Game Data
     *      input   :   void
     *      output  :   void
     */
    private static void SRMUpdate ( boolean won )
    {
        
        if ( won == false )
        {
        
            //Update the amount of attempts that remain (last symbol of JTextField text) 
            attemptsRemaining -- ;
            text.setText("Attempts remaining : " + attemptsRemaining ) ;
        
            //Check to see if the game has been lost. If lost, display LOSS
            if ( attemptsRemaining == 0 )
            {
                
                    //Display DEFEAT
                    JFrame victoryPane = new JFrame ("DEFEAT.") ;
                    victoryPane.setLayout ( new GridLayout( 1 , 1 ) ) ;
                    victoryPane.setSize ( 128, 128 ) ;
                    JTextField victoryText = new JTextField() ;
                    victoryText.setText("DEFEAT.") ;
                    victoryText.setHorizontalAlignment( JTextField.CENTER ) ;
                    victoryPane.add( victoryText ) ;
                    map.setBackground ( Color.white ) ;
                    victoryPane.setVisible ( true ) ;
                    victoryPane.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
                    //System.exit(0) ;
                
            }
            
        }
        else
        {
            
            //Display VICTORY
            JFrame victoryPane = new JFrame ("VICTORY!") ;
            victoryPane.setLayout ( new GridLayout( 1 , 1 ) ) ;
            victoryPane.setSize ( 128, 128 ) ;
            JTextField victoryText = new JTextField() ;
            victoryText.setText("VICTORY!") ;
            victoryText.setHorizontalAlignment( JTextField.CENTER ) ;
            victoryPane.add( victoryText ) ;
            map.setBackground ( Color.black ) ;
            victoryPane.setVisible ( true ) ;
            victoryPane.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
            //System.exit(0) ;
            
        }
        
    }
    
    
    
    /**
     *  MATH METHOD - PythInteger
     *      input   :   XCoordinate and YCoordinate
     */
    private static double MMTargetDistance ( int xCoord, int yCoord )
    {
        
        return MMRoundToInt( Math.pow( Math.pow( (double)xCoord / 16 - (double)( map.getTargetXCoordinateSlot() + 1 ) , 2 ) + Math.pow( (double)yCoord / 16 - (double)( map.getTargetYCoordinateSlot() + 1 ), 2 ) , 0.5  ) ) ;
        
    }
    
    
    
    /**
     *  MATH METHOD - Round Double to Int
     *      input   :   Double Value
     *      output  :   Int Value (Whole-Rounded value of double)
     */
    private static int MMRoundToInt ( double input )
    {
        
        int newInput = (int)( input ) ;
        if ( (int)( input * 10 ) - (int)( input ) * 10 > 4 )
        {
            
            newInput ++ ;
            
        }
        return newInput ;
        
    }
    
}




/**
 *  Auxilary Class - MAP Variable
 *      JPanel Variation
 */
class gameMAP extends JPanel
{
    
    /*
     *  The program needs:
     *  1.  Complete map grid
     *  2.  Coordinates system
     */
    private int targetSlotX ;
    private int targetSlotY ;
    private ImageIcon statusNull = new ImageIcon ("Tile Type 1 Default.png") ;
    private ImageIcon statusTarget = new ImageIcon ("Tile Type 3 Displaced.png") ;
    private ImageIcon statusGrey = new ImageIcon ("Tile Type 2 Greyed.png") ;
    
    /**
     * Constructor for object gameMAP
     */
    public gameMAP ()
    {
        
        //Set up the components needed to create the JPanel
        setBorder ( null ) ;
        setLayout ( new GridLayout ( 16 , 16 ) ) ;
        
        //Create the target tile
        targetSlotX = (int)( Math.random() * 1000 ) % 16 ;
        targetSlotY = (int)( Math.random() * 1000 ) % 16 ;
        int targetSlotNumber = targetSlotY * 16 + targetSlotX ; //X and Y coordinates have to be flipped due to the nature of how columns and rows are organized.
        
        //Add the images onto the main panel
        for ( int settingSlot = 0 ; settingSlot < 256 ; settingSlot ++ )
        {
            
            if ( settingSlot == targetSlotNumber )
            {
                
                add ( new JLabel ( statusTarget ) ) ;
                
            }
            else
            {
                
                add ( new JLabel ( statusNull ) ) ;
                
            }
            
        }
        
    }
    
    /**
     * Collector Method : X COORDINATES in SLOT MEASUREMENTS
     */
    public int getTargetXCoordinateSlot()
    {
        
        return targetSlotX ;
        
    }
    
    /**
     * Collector Method : Y COORDINATES in SLOT MEASUREMENTS
     */
    public int getTargetYCoordinateSlot()
    {
        
        return targetSlotY ;
        
    }
    
}
