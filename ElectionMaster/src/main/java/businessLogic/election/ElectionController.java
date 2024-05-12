package businessLogic.election;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class ElectionController {
    /*	  =============== THE NEW IMPLEMENTATIONS ====================*/
    private  ElectionService electionService;
    public ElectionController(){
        this.electionService = new ElectionService();
    }
    public boolean addElection(String name, String date) throws SQLException {
            Elections election = new Elections(name, date);
            return electionService.create(election);
    }
    public List<Elections> getAllElections() throws SQLException {
        return electionService.getAll();
    }
    public boolean deleteElection(int id) throws SQLException {
        return electionService.delete(id);
    }
    public boolean updateElection(int id, String name,String date) throws SQLException {
        Elections election = new Elections( name, date);
        election.setId(id);
        return electionService.update(election);

    }
//    public List<Integer> getAllElectionId() throws SQLException {
//        return electionService.getAll();
//    }

}
