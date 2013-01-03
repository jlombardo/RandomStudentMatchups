package randomstudentmatchups;

import java.util.List;

/**
 * A simple console output implementation of the OutputStrategy.
 * @author  Jim Lombardo
 * @version 1.00
 */
public class ConsoleOutputStrategy implements OutputStrategy {
    
    /**
     * Construct and output resulting student groups.
     * @param pairings - the collection of groups created
     * @param balanceMsg - a note about how balanced the groups are.
     */
    @Override
    public void output(List<List> pairings, String balanceMsg) {
        System.out.println("Here are the pairings...");
        System.out.println("(" + balanceMsg + ")");
        for(int i=0; i < pairings.size(); i++) {
            System.out.println("\nGroup #" + (i+1));
            System.out.println("--------");
            List<String> group = pairings.get(i);
            for(String student : group) {
                System.out.println(student);
            }
            
        }
    }
}
