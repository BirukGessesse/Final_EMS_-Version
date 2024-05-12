package businessLogic.election;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible for managing the operations related to Elections.
 */
public class ElectionController {
    // Service class for Election related operations
    private ElectionService electionService;

    /**
     * Default constructor initializing the ElectionService.
     */
    public ElectionController() {
        this.electionService = new ElectionService();
    }

    /**
     * Adds a new Election.
     *
     * @param name the name of the election
     * @param date the date of the election
     * @return true if the election was added successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean addElection(String name, String date) throws SQLException {
        Elections election = new Elections(name, date);
        return electionService.create(election);
    }

    /**
     * Retrieves all Elections.
     *
     * @return a list of all elections
     * @throws SQLException if a database access error occurs
     */
    public List<Elections> getAllElections() throws SQLException {
        return electionService.getAll();
    }

    /**
     * Deletes an Election.
     *
     * @param id the id of the election to be deleted
     * @return true if the election was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean deleteElection(int id) throws SQLException {
        return electionService.delete(id);
    }

    /**
     * Updates an Election.
     *
     * @param id   the id of the election to be updated
     * @param name the new name of the election
     * @param date the new date of the election
     * @return true if the election was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean updateElection(int id, String name, String date) throws SQLException {
        Elections election = new Elections(name, date);
        election.setId(id);
        return electionService.update(election);
    }

    // Method to get all election ids. Currently commented out.
    // public List<Integer> getAllElectionId() throws SQLException {
    //     return electionService.getAll();
    // }
}