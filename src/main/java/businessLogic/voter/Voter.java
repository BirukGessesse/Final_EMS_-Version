package businessLogic.voter;

import businessLogic.model.BaseEntity;

/**
 * This class represents a Voter entity.
 */
public class Voter extends BaseEntity {

    private String voterName;
    private int voterAge;
    private String voterPassword;
    private String voterGender;
    private int voterElection;

    /**
     * Default constructor.
     */
    public Voter() {
        super();
    }

    /**
     * Constructor with parameters.
     *
     * @param voterName     the name of the voter
     * @param voterAge      the age of the voter
     * @param voterPassword the password of the voter
     * @param voterGender   the gender of the voter
     * @param voterElection the election id the voter is associated with
     */
    public Voter(String voterName, int voterAge, String voterPassword, String voterGender, int voterElection) {
        super();
        this.voterName = voterName;
        this.voterAge = voterAge;
        this.voterPassword = voterPassword;
        this.voterGender = voterGender;
        this.voterElection = voterElection;
    }

    /**
     * @return the name of the voter
     */
    public String getVoterName() {
        return voterName;
    }

    /**
     * Sets the name of the voter.
     *
     * @param voterName the name to set
     */
    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    /**
     * @return the age of the voter
     */
    public int getVoterAge() {
        return voterAge;
    }

    /**
     * Sets the age of the voter.
     *
     * @param voterAge the age to set
     */
    public void setVoterAge(int voterAge) {
        this.voterAge = voterAge;
    }

    /**
     * @return the password of the voter
     */
    public String getVoterPassword() {
        return voterPassword;
    }

    /**
     * Sets the password of the voter.
     *
     * @param voterPassword the password to set
     */
    public void setVoterPassword(String voterPassword) {
        this.voterPassword = voterPassword;
    }

    /**
     * @return the gender of the voter
     */
    public String getVoterGender() {
        return voterGender;
    }

    /**
     * Sets the gender of the voter.
     *
     * @param voterGender the gender to set
     */
    public void setVoterGender(String voterGender) {
        this.voterGender = voterGender;
    }

    /**
     * @return the election id the voter is associated with
     */
    public int getVoterElection() {
        return voterElection;
    }

    /**
     * Sets the election id the voter is associated with.
     *
     * @param voterElection the election id to set
     */
    public void setVoterElection(int voterElection) {
        this.voterElection = voterElection;
    }
}