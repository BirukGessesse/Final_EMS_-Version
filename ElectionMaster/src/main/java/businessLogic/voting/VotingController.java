package businessLogic.voting;

public class VotingController {
    private  VotingService votingService;
    public VotingController(){
	this.votingService = new VotingService();
    }
    public boolean create(Voting voting){
	return votingService.create(voting);
    }
}
