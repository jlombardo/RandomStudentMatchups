package randomstudentmatchups;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * A simple GUI implementation of the OutputStrategy. You cannot copy or 
 * print the results from the online display.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class JOptionPaneOutputStrategy implements OutputStrategy {
    
    /**
     * Construct and output resulting student groups.
     * @param pairings - the collection of groups created
     * @param balanceMsg - a note about how balanced the groups are.
     */
    @Override
    public void output(List<List> pairings, String balanceMsg) {
        String s1 = "Here are the pairings...\n";
        String s2 = "(" + balanceMsg + ")\n";
        String s3 = "";
        for(int i=0; i < pairings.size(); i++) {
            s3 += "\nGroup #" + (i+1) + "\n";
            s3 += "--------\n";
            List<String> group = pairings.get(i);
            for(String student : group) {
                s3 += (student + "\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, s1 + s2 + s3);
    }
}
