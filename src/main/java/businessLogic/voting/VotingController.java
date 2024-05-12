package businessLogic.voting;

/**
 * This class is responsible for handling the controller operations for Voting.
 */
public class VotingController {
    private VotingService votingService;

    /**
     * Default constructor that initializes the VotingService.
     */
    public VotingController() {
        this.votingService = new VotingService();
    }

    /**
     * Creates a new voting record.
     *
     * @param voting the voting record to be created
     * @return true if the creation was successful, false otherwise
     */
    public boolean create(Voting voting) {
        return votingService.create(voting);
    }
}