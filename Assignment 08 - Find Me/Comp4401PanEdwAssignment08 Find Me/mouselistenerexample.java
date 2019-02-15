//Topics covered
//Handling mouse events
//Adding images to labels

//Import packages needed
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class mouselistenerexample { 

    //All components that need to be viewable by both the main method and the MouseHandler
    //class, need to be declared at the top. ( Outside main method)
    
    static JFrame frame = new JFrame("Mouse Listener Example");
    static JPanel panel = new JPanel();

    static JButton buttonExit = new JButton("Hello");
    static ImageIcon image = new ImageIcon("royalwest.jpg");
    static JLabel label = new JLabel(image);

    
    public static void main(String[] args) { 
        //Create the frame
        frame.setSize(600,600); //Setting the size of the frame

        //Declaring the Mouse listener
        MouseHandler listener = new MouseHandler();

        ////////////////////////////////////////////////////
        //Adding an image to a JLabel - 3 Step process  ////
        ////////////////////////////////////////////////////

        //Step 1 - Create an object of type ImageIcon. Attach your image name
        //via the constructor. Make sure your image is in the same folder as your
        //Java file
        ImageIcon image = new ImageIcon("royalwest.jpg");

        //Step 2 - Attach your image to a JLabel
        label.setIcon(image); 
        //The setIcon method can be used to CHANGE an image 
        //during runtime 

        //Step 3 - Attach your  JLabel to your JPanel
        panel.add(label);



        //Attach the panel to the mouse listener
        panel.addMouseListener(listener );
        frame.getContentPane().add(panel); //panel to frame 
        frame.setVisible(true); // Shows frame on screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    
    //All methods within the MouseHandler class MUST be there
    //If not, your code will not compile.
    private static class MouseHandler implements MouseListener {

        
        public void mousePressed(MouseEvent e) {
            System.out.println("Mouse Pressed!");
            System.out.println("X coordinate: " + e.getX()) ;
            System.out.println("Y coordinate: " + e.getY());
        }

        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse Released!");
        }

        public void mouseEntered(MouseEvent e) {
            System.out.println("Mouse Entered!");
        }

        public void mouseExited(MouseEvent e) {
            System.out.println("Mouse Exited!");
        }

        public void mouseClicked(MouseEvent e) {
            System.out.println("Mouse Clicked!");
        }

    }    

}