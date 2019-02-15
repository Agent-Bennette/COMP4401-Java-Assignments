import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * USER INTERFACE OF CALCULATOR
 * 
 * @author AGENT_BENNETTE
 * @version 1 - Created 20150216
 */
public class Comp4401PanEdwAssignment7_Main extends JPanel
{
    
    /*
     *      BUTTON SET UP
     */
    
    //Setting up Display.
    static JTextArea displayFormula = new JTextArea() ;
    static JTextField displayInput = new JTextField() ;
    static JTextField textEmpty = new JTextField() ;
    
    //Setting up all buttons.
    static JButton bNum1 =                  new JButton("1") ;
    static JButton bNum2 =                  new JButton("2") ;
    static JButton bNum3 =                  new JButton("3") ;
    static JButton bNum4 =                  new JButton("4") ;
    static JButton bNum5 =                  new JButton("5") ;
    static JButton bNum6 =                  new JButton("6") ;
    static JButton bNum7 =                  new JButton("7") ;
    static JButton bNum8 =                  new JButton("8") ;
    static JButton bNum9 =                  new JButton("9") ;
    static JButton bNum0 =                  new JButton("0") ;
    static JButton bMathDecimal =           new JButton(".") ;
    
    static JButton bFunctionBackspace =     new JButton("\u2190") ;
    static JButton bFunctionAC =            new JButton("AC") ;
    static JButton bFunctionC =             new JButton("C") ;
    static JButton bFunctionEquals =        new JButton("\u003d") ;
    
    static JButton bMathSignSwitch =        new JButton("\u00b1") ;
    static JButton bMathAddition =          new JButton("+") ;
    static JButton bMathSubstraction =      new JButton("-") ;
    static JButton bMathMultiplication =    new JButton("\u00d7") ;
    static JButton bMathDivision =          new JButton("\u00f7") ;
    static JButton bMathSquare =            new JButton("^2") ;
    static JButton bMathSquareRoot =        new JButton("\u221a") ;
    static JButton bMathPower =             new JButton("^") ;
    static JButton bMathPercent =           new JButton("%") ;
    static JButton bMathFractionFlip =      new JButton("1/all") ;
    
    
    
    public static void main ( String [] args )
    {
        
        //Set up the input method; listener
        ButtonHandler listener = new ButtonHandler() ;
        
        /*
         *      FRAME SET UP
         */
        
        //Set up the Frame
        JFrame mainFrame = new JFrame("Calculator Mark 1") ;
        mainFrame.setSize( 200 , 400 ) ;
        mainFrame.setResizable( false ) ;
        mainFrame.getRootPane().setBorder ( BorderFactory.createMatteBorder ( 8 , 8 , 8 , 8 , Color.black  ) ) ;
        
        //Set up full panel - The entire complete frame proportions.
        JPanel fullPanel = new JPanel() ;
        GridLayout gridFull = new GridLayout ( 2 , 1 ) ;
        fullPanel.setLayout( gridFull ) ;
        
        //Set up top panel - The display of the calculator.
        //There are two displays. One main display showing the formula, the other showing the currently enterred number.
        JPanel displayPanelMain = new JPanel() ;
        JPanel displayPanelFormula = new JPanel() ;
        JPanel displayPanelInputs = new JPanel() ;
        GridLayout gridDisplayMain = new GridLayout ( 2 , 1 ) ;
        GridLayout gridDisplayFormula = new GridLayout ( 1 , 1 ) ;
        GridLayout girdDisplayInputs = new GridLayout ( 1 , 2 ) ;
        displayPanelMain.setLayout( gridDisplayMain ) ;
        displayPanelFormula.setLayout( gridDisplayFormula ) ;
        displayPanelInputs.setLayout( girdDisplayInputs ) ;
        displayFormula.setEditable ( false ) ;
        displayInput.setEditable ( false ) ;
        textEmpty.setEditable ( false ) ;
        displayPanelMain.setBorder ( BorderFactory.createMatteBorder ( 2 , 2 , 2 , 2 , Color.black  ) ) ;
        displayPanelFormula.setBorder ( BorderFactory.createMatteBorder ( 2 , 2 , 2 , 2 , Color.black  ) ) ;
        displayPanelInputs.setBorder ( BorderFactory.createMatteBorder ( 4 , 4 , 4 , 4 , Color.black  ) ) ;
        displayPanelFormula.add( displayFormula ) ;
        displayPanelInputs.add( textEmpty ) ;
        displayPanelInputs.add( displayInput ) ;
        displayPanelMain.add( displayPanelFormula ) ;
        displayPanelMain.add( displayPanelInputs ) ;
        displayFormula.setBackground( Color.darkGray ) ;
        displayFormula.setForeground( new Color ( 0, 255, 255 ) ) ;
        displayInput.setBackground( Color.black ) ;
        displayInput.setForeground( Color.red ) ;
        textEmpty.setBackground( Color.black ) ;
        textEmpty.setBorder ( BorderFactory.createLineBorder ( Color.black ) ) ;
        displayInput.setSize( 50 , 100 ) ;
        textEmpty.setSize( 50 , 100 ) ;
        displayFormula.setBorder ( BorderFactory.createLineBorder ( new Color ( 50 , 125 , 125 ) ) ) ;
        displayFormula.setMargin ( new Insets ( 16 , 16 , 16 , 16 ) ) ;
        displayFormula.setLineWrap ( true ) ;
        displayInput.setBorder ( BorderFactory.createLineBorder ( new Color ( 125 , 50 , 50 ) ) ) ;
        displayInput.setHorizontalAlignment ( JTextField.CENTER ) ;
        
        //Set up bottom panel - Button section of the calculator.
        JPanel buttonPanel = new JPanel () ;
        GridLayout gridButtons = new GridLayout ( 5 , 5 ) ;
        buttonPanel.setLayout( gridButtons ) ;
        
        //Add listerns to all buttons.
        bNum1.addActionListener( listener ) ;
        bNum2.addActionListener( listener ) ;
        bNum3.addActionListener( listener ) ;
        bNum4.addActionListener( listener ) ;
        bNum5.addActionListener( listener ) ;
        bNum6.addActionListener( listener ) ;
        bNum7.addActionListener( listener ) ;
        bNum8.addActionListener( listener ) ;
        bNum9.addActionListener( listener ) ;
        bNum0.addActionListener( listener ) ;
        bMathDecimal.addActionListener( listener ) ;
        bFunctionBackspace.addActionListener( listener ) ;
        bFunctionAC.addActionListener( listener ) ;
        bFunctionC.addActionListener( listener ) ;
        bFunctionEquals.addActionListener( listener ) ;
        bMathSignSwitch.addActionListener( listener ) ;
        bMathAddition.addActionListener( listener ) ;
        bMathSubstraction.addActionListener( listener ) ;
        bMathMultiplication.addActionListener( listener ) ;
        bMathDivision.addActionListener( listener ) ;
        bMathSquare.addActionListener( listener ) ;
        bMathSquareRoot.addActionListener( listener ) ;
        bMathPower.addActionListener( listener ) ;
        bMathPercent.addActionListener( listener ) ;
        bMathFractionFlip.addActionListener( listener ) ;
        
        //Edit Visual Settings of each button. 
        bNum1.setBackground(Color.lightGray) ;
        bNum1.setOpaque(true) ;
        bNum1.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum2.setBackground(Color.lightGray) ;
        bNum2.setOpaque(true) ;
        bNum2.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum3.setBackground(Color.lightGray) ;
        bNum3.setOpaque(true) ;
        bNum3.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum4.setBackground(Color.lightGray) ;
        bNum4.setOpaque(true) ;
        bNum4.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum5.setBackground(Color.lightGray) ;
        bNum5.setOpaque(true) ;
        bNum5.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum6.setBackground(Color.lightGray) ;
        bNum6.setOpaque(true) ;
        bNum6.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum7.setBackground(Color.lightGray) ;
        bNum7.setOpaque(true) ;
        bNum7.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum8.setBackground(Color.lightGray) ;
        bNum8.setOpaque(true) ;
        bNum8.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum9.setBackground(Color.lightGray) ;
        bNum9.setOpaque(true) ;
        bNum9.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bNum0.setBackground(Color.lightGray) ;
        bNum0.setOpaque(true) ;
        bNum0.setBorder ( BorderFactory.createLineBorder( Color.blue ) ) ;
        bMathDecimal.setBackground(Color.gray) ;
        bMathDecimal.setOpaque(true) ;
        bMathDecimal.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        bFunctionBackspace.setBackground(Color.darkGray) ;
        bFunctionBackspace.setForeground(Color.lightGray) ;
        bFunctionBackspace.setOpaque(true) ;
        bFunctionBackspace.setBorder ( BorderFactory.createLineBorder( Color.black ) ) ;
        bFunctionAC.setBackground(Color.red) ;
        bFunctionAC.setForeground(Color.white) ;
        bFunctionAC.setOpaque(true) ;
        bFunctionAC.setBorder ( BorderFactory.createLineBorder( Color.black ) ) ;
        bFunctionC.setBackground(Color.darkGray) ;
        bFunctionC.setForeground(Color.white) ;
        bFunctionC.setOpaque(true) ;
        bFunctionC.setBorder ( BorderFactory.createLineBorder( Color.black ) ) ;
        bFunctionEquals.setBackground(Color.black) ;
        bFunctionEquals.setForeground(Color.white) ;
        bFunctionEquals.setOpaque(true) ;
        bFunctionEquals.setBorder ( BorderFactory.createLineBorder( Color.black ) ) ;
        bMathSignSwitch.setBackground(Color.gray) ;
        bMathSignSwitch.setForeground(Color.white) ;
        bMathSignSwitch.setOpaque(true) ;
        bMathSignSwitch.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        bMathAddition.setBackground(Color.gray) ;
        bMathAddition.setForeground(Color.white) ;
        bMathAddition.setOpaque(true) ;
        bMathAddition.setBorder ( BorderFactory.createLineBorder( Color.green ) ) ;
        bMathSubstraction.setBackground(Color.gray) ;
        bMathSubstraction.setForeground(Color.white) ;
        bMathSubstraction.setOpaque(true) ;
        bMathSubstraction.setBorder ( BorderFactory.createLineBorder( Color.green ) ) ;
        bMathMultiplication.setBackground(Color.gray) ;
        bMathMultiplication.setForeground(Color.white) ;
        bMathMultiplication.setOpaque(true) ;
        bMathMultiplication.setBorder ( BorderFactory.createLineBorder( Color.green ) ) ;
        bMathDivision.setBackground(Color.gray) ;
        bMathDivision.setForeground(Color.white) ;
        bMathDivision.setOpaque(true) ;
        bMathDivision.setBorder ( BorderFactory.createLineBorder( Color.green ) ) ;
        bMathSquare.setBackground(Color.gray) ;
        bMathSquare.setForeground(Color.white) ;
        bMathSquare.setOpaque(true) ;
        bMathSquare.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        bMathSquareRoot.setBackground(Color.gray) ;
        bMathSquareRoot.setForeground(Color.white) ;
        bMathSquareRoot.setOpaque(true) ;
        bMathSquareRoot.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        bMathPower.setBackground(Color.gray) ;
        bMathPower.setForeground(Color.white) ;
        bMathPower.setOpaque(true) ;
        bMathPower.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        bMathPercent.setBackground(Color.gray) ;
        bMathPercent.setForeground(Color.white) ;
        bMathPercent.setOpaque(true) ;
        bMathPercent.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        bMathFractionFlip.setBackground(Color.gray) ;
        bMathFractionFlip.setForeground(Color.white) ;
        bMathFractionFlip.setOpaque(true) ;
        bMathFractionFlip.setBorder ( BorderFactory.createLineBorder( Color.red ) ) ;
        
        //Add all buttons to the buttonPanel
        buttonPanel.add( bFunctionBackspace ) ; // 1,1
        buttonPanel.add( bFunctionC ) ; // 1,2
        buttonPanel.add( bFunctionAC ) ; // 1,3
        buttonPanel.add( bMathSignSwitch ) ; // 1,4
        buttonPanel.add( bMathSquare ) ; // 1,5
        buttonPanel.add( bNum7 ) ; // 2,1
        buttonPanel.add( bNum8 ) ; // 2,2
        buttonPanel.add( bNum9 ) ; // 2,3
        buttonPanel.add( bMathDivision ) ; // 2,4
        buttonPanel.add( bMathSquareRoot ) ; // 2,5
        buttonPanel.add( bNum4 ) ; // 3,1
        buttonPanel.add( bNum5 ) ; // 3,2
        buttonPanel.add( bNum6 ) ; // 3,3
        buttonPanel.add( bMathMultiplication ) ; // 3,4
        buttonPanel.add( bMathPower ) ; // 3,5
        buttonPanel.add( bNum1 ) ; // 4,1
        buttonPanel.add( bNum2 ) ; // 4,2
        buttonPanel.add( bNum3 ) ; // 4,3
        buttonPanel.add( bMathSubstraction ) ; // 4,4
        buttonPanel.add( bMathPercent ) ; // 4,5
        buttonPanel.add( bMathDecimal ) ; // 5,1
        buttonPanel.add( bNum0 ) ; // 5,2
        buttonPanel.add( bFunctionEquals ) ; // 5,3
        buttonPanel.add( bMathAddition ) ; // 5,4
        buttonPanel.add( bMathFractionFlip ) ; // 5,5
        
        //Add the panels to the fullPanel
        fullPanel.add( displayPanelMain ) ;
        fullPanel.add( buttonPanel ) ;
        
        //Set the fullPanel to the frame
        mainFrame.getContentPane().add( fullPanel ) ;
        mainFrame.setVisible( true ) ;
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
        //setOpaque ( true ) ;
        //setBackground ( Color.BLACK ) ;
        
        displayInput.setText("0") ;
        
    }
    
    
    
    /**
     *      Active Method - Listening to Button Instructions
     */
    private static class ButtonHandler implements ActionListener 
    { 
        public void actionPerformed(ActionEvent e) 
        { 
            
            if (e.getSource() == bNum1) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("1") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "1" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum2) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("2") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "2" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum3) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("3") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "3" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum4) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("4") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "4" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum5) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("5") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "5" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum6) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("6") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "6" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum7) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("7") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "7" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum8) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("8") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "8" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum9) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("9") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "9" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bNum0) 
            {
                
                if ( ( displayInput.getText() ).equals("0") )
                {
                    
                    displayInput.setText("0") ;
                    
                }
                else
                {
                    
                    displayInput.setText ( displayInput.getText() + "0" ) ;
                    
                }
                
            }
            
            if (e.getSource() == bMathDecimal) 
            {
                
                boolean decimalExists = false ;
                for ( int i = 0 ; i < displayInput.getText().length() ; i ++ )
                {
                    
                    if ( displayInput.getText().charAt(i) == '.' )
                    {
                        
                        decimalExists = true;
                        break ;
                        
                    }
                    
                }
                
                if ( decimalExists == false )
                {
                    
                    displayInput.setText( displayInput + "." ) ;
                    
                }
                
            }
            
            if (e.getSource() == bFunctionBackspace) 
            {
                
                if ( (displayInput.getText() ).equals("0") )
                {
                    
                    if ( displayFormula.getText().length() > 0 )
                    {
                        
                        displayFormula.setText(   ( displayFormula.getText() ).substring( 0 , ( displayFormula.getText() ).length() - 1 )   ) ;
                        
                    }
                    
                    
                }
                else
                {
                    
                    if ( displayInput.getText().length() > 1 )
                    {
                        
                        displayInput.setText(   ( displayInput.getText() ).substring( 0 , ( displayInput.getText() ).length() - 1 )   ) ;
                        
                    }
                    else if ( displayInput.getText().length() == 1 )
                    {
                        
                        displayInput.setText("0") ;
                        
                    }
                    
                }
                
            }
            
            if (e.getSource() == bFunctionAC) 
            {
                
                displayFormula.setText("") ;
                displayInput.setText("0") ;
                
            }
            
            if (e.getSource() == bFunctionC) 
            {
                
                displayInput.setText("0") ;
                
            }
            
            if (e.getSource() == bFunctionEquals)
            {
                
                String temp [] = displayFormula.getText().trim().split(" ") ;
                
                if ( temp [ temp.length - 1 ].equals("u00b1") || temp [ temp.length - 1 ].equals("+") || temp [ temp.length - 1 ].equals("-") || temp [ temp.length - 1 ].equals("\u00d7") || temp [ temp.length - 1 ].equals("\u00f7") || temp [ temp.length - 1 ].equals("^2") || temp [ temp.length - 1 ].equals("\u221a") || temp [ temp.length - 1 ].equals("^") )
                {
                
                    displayFormula.setText( displayFormula.getText() + " " + displayInput.getText() ) ;
                    displayInput.setText("0") ;
                    
                }
                
                /*
                 *      INITIATE CALCULATIONS
                 */
                
                WriterCal calculationFormula = new WriterCal () ;
                calculationFormula.set( displayFormula.getText() ) ;
                
                try 
                {
                    
                    calculationFormula.write() ;
                    
                }
                catch (Exception unusablecomponentofexceptionswhatusecanidowiththisnothingcanipleasegetridofit)
                {
                    
                    return ;
                    
                }
                
                Calculation calculate = new Calculation () ;
                displayFormula.setText( calculate.getResult() ) ;
                
                
                
            }
            
            if (e.getSource() == bMathSignSwitch) 
            {
                
                displayFormula.setText ( " -1 * ( " + displayFormula.getText() + " ) " ) ;
                
            }
            
            if (e.getSource() == bMathAddition) 
            {
                
                if ( ( displayInput.getText() ).equals("") )
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " + " ) ;
                    displayInput.setText("0") ;
                    
                }
                else
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " + " ) ;
                    displayInput.setText("0") ;
                    
                }
                
            }
            
            if (e.getSource() == bMathSubstraction) 
            {
                
                if ( ( displayInput.getText() ).equals("") )
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " - " ) ;
                    displayInput.setText("0") ;
                    
                }
                else
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " - " ) ;
                    displayInput.setText("0") ;
                    
                }
                
            }
            
            if (e.getSource() == bMathMultiplication) 
            {
                
                if ( ( displayInput.getText() ).equals("") )
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " \u00d7 " ) ;
                    displayInput.setText("0") ;
                    
                }
                else
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " \u00d7 " ) ;
                    displayInput.setText("0") ;
                    
                }
                
            }
            
            if (e.getSource() == bMathDivision) 
            {
                
                if ( ( displayInput.getText() ).equals("") )
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " \u00f7 " ) ;
                    displayInput.setText("0") ;
                    
                }
                else
                {
                    
                    displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " \u00f7 " ) ;
                    displayInput.setText("0") ;
                    
                }
                
            }
            
            if (e.getSource() == bMathSquare) 
            {
                
                displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " ^2 " ) ;
                displayInput.setText("0") ;
                
            }
            
            if (e.getSource() == bMathSquareRoot) 
            {
                
                displayFormula.setText ( displayFormula.getText() + " \u221a " ) ;
                
            }
            
            if (e.getSource() == bMathPower) 
            {
                
                displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " ^ " ) ;
                displayInput.setText("0") ;
                
            }
            
            if (e.getSource() == bMathPercent) 
            {
                
                displayFormula.setText ( displayFormula.getText() + " " + displayInput.getText() + " % " ) ;
                displayInput.setText("0") ;
                
            }
            
            if (e.getSource() == bMathFractionFlip) 
            {
                
                displayFormula.setText ( displayFormula.getText() + " 1/x " ) ;
                
            }
            
        }



    } 
    
    
    public void paintComponent( Graphics g )
    {
        
        super.paintComponent(g) ;
        
        g.setColor(Color.red) ;
        
    }
    
}
