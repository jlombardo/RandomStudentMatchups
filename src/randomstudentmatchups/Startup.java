package randomstudentmatchups;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This is the driver class for the RandomStudentMatchups application,
 * which is designed to read a list of students, one per line, and output
 * balanced groupings based on the number of students desired per group. If
 * the totalNumberOfStudents % groupSize != 0, a balancing algorithm will be
 * used to make sure that no group has fewer than groupSize - 1 students.
 * If necessary, groupSize will be adjusted to make this possible.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class Startup {

    /**
     * This application may be launched from Netbeans of Command Line.
     * 
     * @param args the command line arguments - automatically provided in the 
     * Netbeans runtime options, or must be provided at the command line. The
     * first argument is the relative filePath; the 2nd is the group size, and
     * the 3rd (optional) is "gui" if you want a GUI for output. If this 
     * parameter is missing, command line output will be used by default.
     */
    public static void main(String[] args) {
        
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException 
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // check java version (must be Java 8+)
        String version = System.getProperty("java.version");
        if(!version.startsWith("1.8")) {
            JOptionPane.showMessageDialog(null, 
                    "Sorry, this program requires Java 8 runtime", 
                    "Version Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ServiceChoiceWindow w1 = new ServiceChoiceWindow();
            w1.setLocationRelativeTo(null);
            w1.setVisible(true);
        });
    
    }

}
