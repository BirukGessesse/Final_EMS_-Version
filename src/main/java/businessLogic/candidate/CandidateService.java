package businessLogic.candidate;

import businessLogic.service.BaseService;

import java.util.List;

/**
 * This class is responsible for managing the service operations related to Candidates.
 */
public class CandidateService extends BaseService<Candidate> {

    // Repository class for Candidate related operations
    private final CandidateRepository candidateRepository;

    /**
     * Default constructor initializing the CandidateRepository.
     */
    public CandidateService() {
        this.candidateRepository = new CandidateRepository();
    }

    /**
     * Creates a new Candidate.
     *
     * @param candidate the candidate to be created
     * @return true if the candidate was created successfully, false otherwise
     */
    @Override
    public boolean create(Candidate candidate) {
        return candidateRepository.insert(candidate);
    }

    /**
     * Inserts a new Candidate.
     *
     * @param candidate the candidate to be inserted
     * @return true if the candidate was inserted successfully, false otherwise
     */
    @Override
    public boolean insert(Candidate candidate) {
        return candidateRepository.insert(candidate);
    }

    /**
     * Updates an existing Candidate.
     *
     * @param candidate the candidate with updated information
     * @return true if the candidate was updated successfully, false otherwise
     */
    @Override
    public boolean update(Candidate candidate) {
        return candidateRepository.update(candidate);
    }

    /**
     * Deletes a Candidate.
     *
     * @param id the id of the candidate to be deleted
     * @return true if the candidate was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(int id) {
        return candidateRepository.delete(id);
    }

    /**
     * Retrieves a Candidate by id.
     *
     * @param id the id of the candidate to be retrieved
     * @return the candidate with the given id
     */
    @Override
    public Candidate get(int id) {
        return null;
    }

    /**
     * Retrieves all Candidates.
     *
     * @return a list of all candidates
     */
    @Override
    public List<Candidate> getAll() {
        return candidateRepository.getAll();
    }

}