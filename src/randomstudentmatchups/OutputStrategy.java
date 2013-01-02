package randomstudentmatchups;

import java.util.List;

/**
 * The general contract for all output implementations.
 * @author  Jim Lombardo
 */
public interface OutputStrategy {

    void output(List<List> pairings, String balanceMsg);

}
