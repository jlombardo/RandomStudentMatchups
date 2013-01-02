package randomstudentmatchups;

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
    public static void main(String[] args) throws Exception {
        if(args == null || args.length < 2) {
            System.err.println(
                    "Missing runtime arguments (filePath and group size)"
                    + "\nProcess terminated.");
            System.exit(0);
        }
        
        String filePath = args[0];
        int groupSize = Integer.valueOf(args[1]);
        
        String output = null;        
        if(args.length == 3) {
            output = args[2];
        }
        
        StudentMatchService srv = new StudentMatchService();
        if(output == null) {
            srv.setOutputStrategy(new ConsoleOutputStrategy());
        } else {
            srv.setOutputStrategy(new JDialogOutputStrategy());            
        }
        srv.createStudentMatchups(filePath, groupSize);
    }

}
