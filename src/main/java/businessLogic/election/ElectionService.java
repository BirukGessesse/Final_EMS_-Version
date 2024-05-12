package businessLogic.election;

import businessLogic.service.BaseService;

import java.util.List;

/**
 * This class is responsible for managing the service operations related to Elections.
 */
public class ElectionService extends BaseService<Elections> {

    // Repository class for Election related operations
    private ElectionRepository electionRepository;

    /**
     * Default constructor initializing the ElectionRepository.
     */
    public ElectionService() {
        this.electionRepository = new ElectionRepository();
    }

    /**
     * Creates a new Election.
     *
     * @param election the election to be created
     * @return true if the election was created successfully, false otherwise
     */
    @Override
    public boolean create(Elections election) {
        return electionRepository.insert(election);
    }

    /**
     * Inserts a new Election.
     *
     * @param election the election to be inserted
     * @return true if the election was inserted successfully, false otherwise
     */
    @Override
    public boolean insert(Elections election) {
        return electionRepository.insert(election);
    }

    /**
     * Updates an existing Election.
     *
     * @param election the election with updated information
     * @return true if the election was updated successfully, false otherwise
     */
    @Override
    public boolean update(Elections election) {
        return electionRepository.update(election);
    }

    /**
     * Deletes an Election.
     *
     * @param id the id of the election to be deleted
     * @return true if the election was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(int id) {
        return electionRepository.delete(id);
    }

    /**
     * Retrieves an Election by id.
     *
     * @param id the id of the election to be retrieved
     * @return the election with the given id
     */
    @Override
    public Elections get(int id) {
        return null;
    }

    /**
     * Creates a new Election with the given name and date.
     *
     * @param name the name of the election
     * @param date the date of the election
     * @return true if the election was created successfully, false otherwise
     */
    public boolean create(String name, String date) {
        Elections election = new Elections();
        election.setElectionName(name);
        election.setElectionDate(date);
        return create(election);
    }

    /**
     * Retrieves all Elections.
     *
     * @return a list of all elections
     */
    public List<Elections> getAll() {
        return electionRepository.getAll();
    }
}