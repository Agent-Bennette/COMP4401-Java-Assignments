import java.util.Scanner ;
import javax.tools.* ;
import java.lang.Runtime ;

/**
 * This class wil be used to write another class which will be used to complete the calculation. The purpose of using another class to make a calculation is to enhance the versatility of the calculator, thus allowing for longer formulas.
 * Plus, it just looks cool. And I'd like to know how to use the stuff I've read from my Java manual.
 * 
 * @author BENNETTE
 * @version 1 - Created 20150315
 */
public class WriterCal
{
    // instance variables - replace the example below with your own
    private String formula;

    /**
     *      Constructor - Start the class.
     */
    public WriterCal()
    {
        
        formula = "" ;
        
    }
    
    /**
     *      SETTER Method - Set up the formula (A string) that needs to be printed.
     *      input   :   FORMULA as String
     *      output  :   void
     */
    public void set ( String input )
    {
        
        formula = input ;
        
    }
    
    /**
     *      WRITER Method
     *      input   :   void ( formula should already be included in the program )
     *      output  :   CLASS Calculation
     */
    public void write () throws Exception
    {
        
        //Identify the file.
        java.io.File file=  new java.io.File("Calculation.java") ;
        
        //Check if there's already a pre-existing file. If true, delete it.
        if ( file.exists() )
        {
            
            file.delete() ;
            
        }
        
        //Set up PrintWriter to write the program.
        java.io.PrintWriter output = new java.io.PrintWriter(file) ;
        
        /*
         *      CONTENTS OF THE PROGRAM
         */
        output.println("    /**") ;
        output.println("     * This is the receiving end of WriterCal class. This class will be summoned to make the actual calculation necessary for the program.") ;
        output.println("     * ") ;
        output.println("     * @author BENNETTE's WriterCal") ;
        output.println("     * @version null; constantly editted by WriterCal") ;
        output.println("     */") ;
        output.println("    public class Calculation") ;
        output.println("    {") ;
        output.println("        ") ;
        output.println("        //Variable to be collected by the main class of the program. " ) ;
        output.println("        public static double result ;" ) ;
        output.println("        ") ;
        output.println("        //Constructor method that has absolutely no usage here, other than summoning the object. " ) ;
        output.println("        public Calculation () {} " ) ;
        output.println("        ") ;
        output.println("        //Very simple main method; The formula will be placed after the return queue, which will allow for users to quickly enter a formula through WriterCal and receive its result through this class.") ;
        output.println("        public String getResult() " ) ;
        output.println("        {") ;
        output.println("            ") ;
        output.print  ("            double result = ") ; output.print( BufferF.translate(formula) ) ; output.println(" ;") ;
        output.print  ("            return String.valueOf(result)" ) ; output.println(" ;") ;
        output.println("            ") ;
        output.println("        }") ;
        output.println("         ") ;
        output.println("    }") ;
        output.close() ;
        
        
        /*
         *      COMPILE THE PROGARM TO ALLOW FOR ITS USAGE
         */
        /*
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler() ;
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null) ;
        
        Iterable<? extends JavaFileObject> compilationUnits =
           fileManager.getJavaFileObjects("Calculation");
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call() ;
        
        fileManager.close() ;
        */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = 
            fileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
        boolean success = task.call();
        fileManager.close();
        
    }
    
}
