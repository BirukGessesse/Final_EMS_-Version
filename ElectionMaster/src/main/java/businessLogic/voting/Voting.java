package businessLogic.voting;

import businessLogic.model.BaseEntity;

public class Voting extends BaseEntity {


    private int candidateId;
    private  int voterId;
    private int electionId;
    public Voting(){
	super();

    }
    public Voting( int candidateId, int voterId, int electionId) {
	super();

	this.candidateId = candidateId;
	this.voterId = voterId;
	this.electionId = electionId;

    }

    public void setCandidateId(int candidateId) {
	this.candidateId = candidateId;
    }

    public void setVoterId(int voterId) {
	this.voterId = voterId;
    }

    public void setElectionId(int electionId) {
	this.electionId = electionId;
    }

    public int getCandidateId() {
	return candidateId;
    }

    public int getVoterId() {
	return voterId;
    }

    public int getElectionId() {
	return electionId;
    }
}
