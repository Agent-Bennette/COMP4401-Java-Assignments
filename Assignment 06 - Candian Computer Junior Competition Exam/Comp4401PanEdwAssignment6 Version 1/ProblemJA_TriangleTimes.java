import java.util.Scanner ;

/**
 * This program must take in three angles (in degrees) of a triangle and identify what kind of triangle it is.
 * 
 * @author Edwin Pan
 * @version 1.0 - Created 20150203
 */
public class ProblemJA_TriangleTimes
{

    public static void main ( String [] args )
    {
        
        /**
         *      INITIALIZE VARIABLES
         */
        
        int triangleSideA = 0 , triangleSideB = 0 , triangleSideC = 0 , triangleSidesPairsCongruent = 0 ;
        String inputString = "" ;
        boolean programContinue = true ;
        
        
        
        /**
         *      CREATE SCANNER METHOD
         */
        
        Scanner input = new Scanner (System.in) ;
        
        
        
        /**
         *      MAIN PROGRAM CHUNK
         */
        while ( programContinue )
        {
            
            //Explain the purpose of the program
            if ( triangleSideA == 0 && triangleSideB == 0 && triangleSideC == 0 )
            {
                
                System.out.print("\u000c\n\tThis program solves Problem J1 - Triangle Times. \n\tTo identify a specified triangle, the user is required to enter the angles (in degrees) of any described triangle. \n\t\tAfterwards, the program will identify the kind of triangle it is.");
                
            }
            else
            {
                
                System.out.print("\u000c\n\tOnce again, you will be asked to enter the angles (in degrees) of the three side of any said triangle.") ;
                
            }
            
            
            
            //Reset all variables
            triangleSideA = 0 ;
            triangleSideB = 0 ;
            triangleSideC = 0 ;
            triangleSidesPairsCongruent = 0 ;
            
            
            
            //Prompt for the angle until valid.
            while ( triangleSideA < 1 || triangleSideA > 178 ) //Since all entered angles must be integers, all sides must have a minimum measurement of 1, thus the maximum for a single side would be 178 while the others have 1.
            {
                
                System.out.print("\n\n\t\tEnter the angle ( in degrees ) of angle A : " ) ;
                triangleSideA = input.nextInt() ;
                
            }
            
            //Prompt for the angle until valid.
            while ( triangleSideB < 1 || triangleSideB > 178 ) //Since all entered angles must be integers, all sides must have a minimum measurement of 1, thus the maximum for a single side would be 178 while the others have 1.
            {
                
                System.out.print("\n\n\t\tEnter the angle ( in degrees ) of angle B : " ) ;
                triangleSideB = input.nextInt() ;
                
            }
            
            //Prompt for the angle until valid.
            while ( triangleSideC < 1 || triangleSideC > 178 ) //Since all entered angles must be integers, all sides must have a minimum measurement of 1, thus the maximum for a single side would be 178 while the others have 1.
            {
                
                System.out.print("\n\n\t\tEnter the angle ( in degrees ) of angle C : " ) ;
                triangleSideC = input.nextInt() ;
                
            }
            
            
            
            //Check the amount of congruent pairs of angles. Note the triangleSidesPairCongruent is simply a number that decides what will be done.
            if ( triangleSideA == triangleSideB ) { triangleSidesPairsCongruent ++ ; } //Check first pair
            if ( triangleSideC == triangleSideB ) { triangleSidesPairsCongruent ++ ; } //Check second pair. If there are two pairs, all are the same already.
            if ( triangleSideA + triangleSideB + triangleSideC != 180 ) { triangleSidesPairsCongruent = 3 ; } //If three, there is an error.
            
            //Print out result.
            switch ( triangleSidesPairsCongruent )
            {
                
                case 0 :
                    System.out.println("\n\tIsosceles") ;
                    break ;
                
                
                case 1 :
                    System.out.println("\n\tScalene") ;
                    break ;
                
                
                case 2 :
                    System.out.println("\n\tEquilateral") ;
                    break ;
                
                
                case 3 :
                    System.out.println("\n\tError") ;
                    break ;
                
            }
            
            //Ask if the user would like to loop.
            System.out.println("\n\n\tWould you like to proceed with another triangle? ") ;
            for ( int cycle = 1 ; cycle > 0 ; cycle ++ )
            {
                
                System.out.print("\t\t\t(\"Yes\",\"No\") : " ) ;
                inputString = input.next() ;
                
                if ( inputString.equalsIgnoreCase("Yes") )
                {
                    
                    cycle = -1 ;
                    
                }
                else if ( inputString.equalsIgnoreCase("No") )
                {
                    
                    programContinue = false ;
                    cycle = -1 ;
                    
                }
                
            }
            
        }
        
        System.exit(0) ;
        
    }

}
