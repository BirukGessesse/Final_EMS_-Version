package businessLogic.election;

import businessLogic.model.BaseEntity;

/**
 * This class represents an Election entity.
 */
public class Elections extends BaseEntity {

    // Name of the election
    private String electionName;
    // Date of the election
    private String electionDate;

    /**
     * Default constructor.
     */
    public Elections() {
        super();
    }

    /**
     * Constructor with parameters.
     *
     * @param electionName the name of the election
     * @param electionDate the date of the election
     */
    public Elections(String electionName, String electionDate) {
        this.electionName = electionName;
        this.electionDate = electionDate;
    }

    /**
     * Retrieves the name of the election.
     *
     * @return the name of the election
     */
    public String getElectionName() {
        return electionName;
    }

    /**
     * Sets the name of the election.
     *
     * @param electionName the new name of the election
     */
    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    /**
     * Retrieves the date of the election.
     *
     * @return the date of the election
     */
    public String getElectionDate() {
        return electionDate;
    }

    /**
     * Sets the date of the election.
     *
     * @param electionDate the new date of the election
     */
    public void setElectionDate(String electionDate) {
        this.electionDate = electionDate;
    }
}