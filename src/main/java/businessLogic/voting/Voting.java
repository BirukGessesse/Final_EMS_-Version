package businessLogic.voting;

import businessLogic.model.BaseEntity;

/**
 * This class represents a Voting entity.
 */
public class Voting extends BaseEntity {

    private int candidateId;
    private int voterId;
    private int electionId;

    /**
     * Default constructor.
     */
    public Voting() {
        super();
    }

    /**
     * Constructor with parameters.
     *
     * @param candidateId the id of the candidate
     * @param voterId     the id of the voter
     * @param electionId  the id of the election
     */
    public Voting(int candidateId, int voterId, int electionId) {
        super();
        this.candidateId = candidateId;
        this.voterId = voterId;
        this.electionId = electionId;
    }

    /**
     * Sets the id of the candidate.
     *
     * @param candidateId the new id of the candidate
     */
    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * Sets the id of the voter.
     *
     * @param voterId the new id of the voter
     */
    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    /**
     * Sets the id of the election.
     *
     * @param electionId the new id of the election
     */
    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    /**
     * Retrieves the id of the candidate.
     *
     * @return the id of the candidate
     */
    public int getCandidateId() {
        return candidateId;
    }

    /**
     * Retrieves the id of the voter.
     *
     * @return the id of the voter
     */
    public int getVoterId() {
        return voterId;
    }

    /**
     * Retrieves the id of the election.
     *
     * @return the id of the election
     */
    public int getElectionId() {
        return electionId;
    }
}