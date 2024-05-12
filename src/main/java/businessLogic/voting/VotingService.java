package businessLogic.voting;

import businessLogic.service.BaseService;

import java.util.List;

public class VotingService extends BaseService<Voting> {
    private VotingRepository votingRepository;

    public VotingService() {
        this.votingRepository = new VotingRepository();
    }

    public boolean create(Voting voting) {
        if (votingRepository.voteExists(voting.getVoterId(), voting.getElectionId())) {
            return false;
        } else {
            return votingRepository.insert(voting);
        }
    }

    public static final String SELECT_VOTING_BY_VOTER_ID_AND_ELECTION_ID_SQL = "SELECT * FROM voting WHERE voting_voter_id = ? AND voting_election_id = ?";

    @Override
    public boolean insert(Voting entity) {
        return false;
    }

    @Override
    public boolean update(Voting entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Voting get(int id) {
        return null;
    }

    @Override
    public List<Voting> getAll() {
        return null;
    }
}
