package randomstudentmatchups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles to import of a student file list into the application,
 * and this is a mandatory operaiton. It assumes the file contains one student 
 * per line and no other information, meta data or blank lines.
 * <P>
 * A good future enhancement would be to base this class on an abstraction 
 * representing various data import strategies. That way one could easily
 * switch between, say a file-based storage and a database.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class FileManager {
    private static final String PATH_ERR = "File path not valid";
    private String filePath;

    /**
     * Custom constructor validates legal filePath.
     * @param filePath - path to student list
     * @throws IOException if path not valid
     */
    public FileManager(String filePath) throws IOException {
        this.verifyFilePath(filePath);
        this.filePath = filePath;
    }
    
    /**
     * Loads and parses file for student names, one per line. Ignores blank
     * lines and trims bordering white space from each line.
     * 
     * @return list of students
     * @throws IOException if file not accessible
     */
    public List getStudentList() throws IOException {
        filePath = getPortableFilePath(filePath);
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
        List lines = new ArrayList(20);
        
        String line = in.readLine();
        while(line != null && !line.isEmpty()){
            lines.add(line.trim());
            line = in.readLine();
        }

        return lines;
    }
    
    // validate the path
    private void verifyFilePath(String filePath) throws IOException {
        if(filePath == null || filePath.length() == 0) {
            throw new IOException(PATH_ERR);
        }
    }
    
    /*
     * This is just a convenience so that we don't have to worry about
     * any system-specific file path syntax.
     */
    private String getPortableFilePath(String filePath) {
        if(filePath.indexOf(":") == 1) { // could have windows drive letter
            if(filePath.indexOf("\\") == 2 || filePath.indexOf("/") == 2) {
                // pretty sure it's a windows file path so remove stuff
                filePath = filePath.substring(3); // remove 'c:/' or 'c:\'
            }
            
        }

        // replace any other windows slashes with system independent
        String strRepaired = filePath.replace("\\", "/");

        return strRepaired;
    }
    
}
