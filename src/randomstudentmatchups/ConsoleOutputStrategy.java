package randomstudentmatchups;

import java.util.List;

/**
 *
 * @author jlombardo
 */
public class ConsoleOutputStrategy implements OutputStrategy {
    
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
