package businessLogic.voter;

import businessLogic.service.BaseService;

import java.util.List;

/**
 * This class is responsible for handling the business logic related to voters.
 */
public class VoterService extends BaseService<Voter> {
    private VoterRepository voterRepository;

    /**
     * Default constructor that initializes the VoterRepository.
     */
    public VoterService() {
        this.voterRepository = new VoterRepository();
    }

    /**
     * Creates a new voter.
     *
     * @param voter the voter to be created
     * @return true if the creation was successful, false otherwise
     */
    public boolean create(Voter voter) {
        return voterRepository.insert(voter);
    }

    /**
     * Inserts a new voter.
     *
     * @param voter the voter to be inserted
     * @return true if the insertion was successful, false otherwise
     */
    @Override
    public boolean insert(Voter voter) {
        return voterRepository.insert(voter);
    }

    /**
     * Updates a voter.
     *
     * @param entity the voter to be updated
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean update(Voter entity) {
        return voterRepository.update(entity);
    }

    /**
     * Deletes a voter.
     *
     * @param id the id of the voter to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean delete(int id) {
        return voterRepository.delete(id);
    }

    /**
     * Retrieves a voter.
     *
     * @param id the id of the voter to be retrieved
     * @return the voter if found, null otherwise
     */
    @Override
    public Voter get(int id) {
        return null;
    }

    /**
     * Retrieves all voters.
     *
     * @return a list of all voters
     */
    @Override
    public List<Voter> getAll() {
        return voterRepository.getAll();
    }
}