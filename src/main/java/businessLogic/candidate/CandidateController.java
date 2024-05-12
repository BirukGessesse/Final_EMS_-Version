package businessLogic.candidate;

import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible for managing the operations related to Candidates.
 */
public class CandidateController {
    // Service class for Candidate related operations
    private final CandidateService candidateService;

    /**
     * Default constructor initializing the CandidateService.
     */
    public CandidateController() {
        this.candidateService = new CandidateService();
    }

    /**
     * Creates a new Candidate.
     *
     * @param candidate the candidate to be created
     * @return true if the candidate was created successfully, false otherwise
     */
    public boolean createCandidate(Candidate candidate) {
        return candidateService.create(candidate);
    }

    /**
     * Updates an existing Candidate.
     *
     * @param candidate the candidate with updated information
     * @return true if the candidate was updated successfully, false otherwise
     */
    public boolean updateCandidate(Candidate candidate) {
        return candidateService.update(candidate);
    }

    /**
     * Deletes a Candidate.
     *
     * @param id the id of the candidate to be deleted
     * @return true if the candidate was deleted successfully, false otherwise
     */
    public boolean deleteCandidate(int id) {
        return candidateService.delete(id);
    }

    /**
     * Retrieves a Candidate by id.
     *
     * @param id the id of the candidate to be retrieved
     * @return the candidate with the given id
     */
    public Candidate getCandidate(int id) {
        return candidateService.get(id);
    }

    /**
     * Retrieves all Candidates.
     *
     * @return a list of all candidates
     */
    public List<Candidate> getAllCandidates() {
        return candidateService.getAll();
    }

    /**
     * Adds a new Candidate.
     *
     * @param name           the name of the candidate
     * @param age            the age of the candidate
     * @param candidateElect the elect status of the candidate
     * @param photo          the photo of the candidate
     * @param gender         the gender of the candidate
     * @return true if the candidate was added successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean addCandidate(String name, int age, int candidateElect, byte[] photo, String gender) throws SQLException {
        Candidate candidate = new Candidate(name, age, gender, candidateElect, photo);
        return candidateService.create(candidate);
    }

    /**
     * Retrieves a Candidate by id.
     *
     * @param id the id of the candidate to be retrieved
     * @return the candidate with the given id
     */
    public Candidate getCandidateById(int id) {
        return candidateService.get(id);
    }

    /**
     * Updates a Candidate.
     *
     * @param id             the id of the candidate to be updated
     * @param name           the new name of the candidate
     * @param age            the new age of the candidate
     * @param candidateElect the new elect status of the candidate
     * @param photo          the new photo of the candidate
     * @param gender         the new gender of the candidate
     * @return true if the candidate was updated successfully, false otherwise
     * @throws SQLException if a database access error occurs
     */
    public boolean updateCandidate(int id, String name, int age, int candidateElect, byte[] photo, String gender) throws SQLException {
        Candidate candidate = new Candidate(name, age, gender, candidateElect, photo);
        candidate.setId(id);
        return candidateService.update(candidate);
    }
}