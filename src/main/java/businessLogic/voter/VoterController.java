package businessLogic.voter;

import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible for handling the business logic related to voters.
 */
public class VoterController {
    private VoterService voterService;

    /**
     * Default constructor that initializes the VoterService.
     */
    public VoterController() {
        this.voterService = new VoterService();
    }

    /**
     * Adds a new voter.
     *
     * @param voterName     the name of the voter
     * @param voterAge      the age of the voter
     * @param voterPassword the password of the voter
     * @param voterGender   the gender of the voter
     * @param voterElection the election id the voter is associated with
     * @return true if the voter was added successfully, false otherwise
     */
    public boolean addVoter(String voterName, int voterAge, String voterPassword, String voterGender, int voterElection) {
        Voter voter = new Voter(voterName, voterAge, voterPassword, voterGender, voterElection);
        return voterService.create(voter);
    }

    /**
     * Retrieves all voters.
     *
     * @return a list of all voters
     */
    public List<Voter> getAllVoters() {
        return voterService.getAll();
    }

    /**
     * Deletes a voter.
     *
     * @param id the id of the voter to be deleted
     * @return true if the voter was deleted successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean deleteVoter(int id) throws SQLException {
        return voterService.delete(id);
    }

    /**
     * Updates a voter.
     *
     * @param id            the id of the voter to be updated
     * @param voterName     the new name of the voter
     * @param voterAge      the new age of the voter
     * @param voterPassword the new password of the voter
     * @param voterGender   the new gender of the voter
     * @param voterElection the new election id the voter is associated with
     * @return true if the voter was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean updateVoter(int id, String voterName, int voterAge, String voterPassword, String voterGender, int voterElection) throws SQLException {
        Voter voter = new Voter(voterName, voterAge, voterPassword, voterGender, voterElection);
        voter.setId(id);
        return voterService.update(voter);
    }
}