package randomstudentmatchups;

import java.util.List;

/**
 * An advanced GUI implementation of the OutputStrategy. This implementation 
 * allows one to copy the resulting data or even print it.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class JDialogOutputStrategy implements OutputStrategy {
    

    /**
     * Construct and output resulting student groups.
     * @param pairings - the collection of groups created
     * @param balanceMsg - a note about how balanced the groups are.
     */
    @Override
    public void output(final List<List> pairings, final String balanceMsg) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogGroups dialog = new JDialogGroups();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });

                // construct output text and assign to JTextArea component
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
                
                dialog.getjTextArea1().append(s1+s2+s3);
                dialog.setVisible(true);
                dialog.setLocationRelativeTo(null); // center on screen
            }
        });
        
    }
}
