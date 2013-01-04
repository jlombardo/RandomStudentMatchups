package randomstudentmatchups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is a Facade that encapsulates reading in a file list of students,
 * formatted one student per line, and then creating the random groups, and 
 * finally outputting the groups using the chosen output strategy.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class StudentMatchService {
    private List<List> pairings;
    private List<String> students, studentsBu;
    private OutputStrategy outputStrategy;
    private static final String BALANCED_MSG = "Groups are balanced"
            + " as much as possible (group size or group size - 1)";
    private static final String UNBALANCED_MSG =
            "Had to RESIZE groups to balance as much as possible"
            + " (group size or group size - 1)";
    private String balanceMsg = BALANCED_MSG;  // default
    
    public StudentMatchService() { 
    }
    
    public StudentMatchService(OutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    }
    
    public void createStudentMatchups(String filePath, int groupSize) throws IOException {
        FileManager fileMgr = new FileManager(filePath);
        students = fileMgr.getStudentList();
        studentsBu = new ArrayList<String>(students);
        pairings = getPairings(groupSize); 
    }
    
    public void outputPairings() {
        outputStrategy.output(pairings,balanceMsg);
    }
    
    public void clear() {
        //  cleanup in case we do another list
        students.clear();
        studentsBu.clear();
        balanceMsg = BALANCED_MSG;        
    }
    
    /*
     * As students are matched up the student list will adjust downward in
     * size. Effectively the student list becomes a list of unassigned students.
     * Note: this method may behave recursively if the groups are unbalanced
     * (see getBalancedPairings method)
     */
    private List<List> getPairings(int groupSize) {
        List<List> pairings = new ArrayList<List>();
        while(students.size() > 0) {
            pairings.add(getGroup(groupSize));
        }
         
        return getBalancedPairings(pairings,groupSize);
    }
    
    /*
     * Ideally we want each group to have the same number of members. However, 
     * this isn't always possible if the total number of students is not evenly 
     * divisible by the group size. Therefore, if the total number of students 
     * modulus the groupSize != 0, a balancing algorithm will be used to make 
     * sure that no group has fewer than groupSize - 1 students. For example,
     * if groups of 4 are desired, but we end up with one group of 3, that's
     * acceptable. However, if we end up with one group of 2, that's not.
     * In this case groupSize will be adjusted down to make this possible.
     */
    private List<List> getBalancedPairings(List<List> pairings, int groupSize) {
        // Get the last group from the total number of pairings created
        List lastGroup = pairings.get(pairings.size()-1);
        
        // check to see if we neeed to resize groups
        while(lastGroup.size() < (groupSize - 1)) {
            balanceMsg = UNBALANCED_MSG;
            students = new ArrayList<String>(studentsBu);
            // In this case getParings is recursive as we shrink groupSize
            // until the balance we need is achieved
            pairings = getPairings(--groupSize);
        }
        
        return pairings;
    }
    
    private List<String> getGroup(int groupSize) {
        Random rnd = new Random(System.nanoTime());
        List<String> group = new ArrayList<String>(groupSize);
        
        // get first student in group
        String student1 = students.get(0);
        group.add(student1);
        students.remove(student1); // remove assigned students from orig. list
        
        // now get the rest
        for(int i=1; i < groupSize; i++) {
            if(students.size() > 0) { // determines if we're done or not
                String nextStudent = students.get(rnd.nextInt(students.size()));
                group.add(nextStudent);
                 // remove assigned students from orig. list
                students.remove(nextStudent);
            } else {
                break; // all students assigned to groups, so stop looping!
            }
        }    
        
        return group;
    }

    public void setOutputStrategy(OutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    }
    
}
