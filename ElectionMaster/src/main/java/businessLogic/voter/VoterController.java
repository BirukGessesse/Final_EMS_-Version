package businessLogic.voter;

import java.sql.SQLException;
import java.util.List;

public class VoterController {
    private VoterService voterService;
    public VoterController(){
	this.voterService = new VoterService();
    }
    public boolean addVoter(String voterName, int voterAge, String voterPassword, String voterGender, int voterElection){
	Voter voter = new Voter(voterName, voterAge, voterPassword, voterGender, voterElection);
	return voterService.create(voter);
    }
    public List<Voter> getAllVoters(){
	return voterService.getAll();
    }
    public boolean deleteVoter(int id) throws SQLException {
	return voterService.delete(id);
    }
    public boolean updateVoter(int id, String voterName, int voterAge, String voterPassword, String voterGender, int voterElection) throws SQLException {
	Voter voter = new Voter(voterName, voterAge, voterPassword, voterGender, voterElection);
	voter.setId(id);
	return voterService.update(voter);
    }

}
