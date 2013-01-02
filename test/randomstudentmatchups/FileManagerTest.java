package randomstudentmatchups;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author jlombardo
 */
public class FileManagerTest {
    private static final String filePath = "src/studentList1.txt";
    
    /**
     * Test of getStudentList method, of class FileManager.
     */
    @Test
    public void testGetStudentList() throws Exception {
        FileManager instance = new FileManager(filePath);
        List result = instance.getStudentList();
        assertTrue(result.size() > 0);
    }
}
