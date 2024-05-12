package businessLogic.candidate;

import businessLogic.model.BaseEntity;

/**
 * This class represents a candidate in an election.
 */
public class Candidate extends BaseEntity {

    // The name of the candidate
    private String candidateName;

    // The age of the candidate
    private int candidateAge;

    // The gender of the candidate
    private String candidateGender;

    // The elect status of the candidate
    private int candidateElect;

    // The photo of the candidate
    private byte[] candidatePhoto;

    /**
     * Default constructor
     */
    public Candidate() {
        super();
    }

    /**
     * Constructs a new Candidate with the specified details.
     *
     * @param candidateName   the name of the candidate
     * @param candidateAge    the age of the candidate
     * @param candidateGender the gender of the candidate
     * @param candidateElect  the elect status of the candidate
     * @param candidatePhoto  the photo of the candidate
     */
    public Candidate(String candidateName, int candidateAge, String candidateGender, int candidateElect, byte[] candidatePhoto) {
        this.candidateName = candidateName;
        this.candidateAge = candidateAge;
        this.candidateGender = candidateGender;
        this.candidateElect = candidateElect;
        this.candidatePhoto = candidatePhoto;
    }

    /**
     * Returns the name of the candidate.
     *
     * @return the name of the candidate
     */
    public String getCandidateName() {
        return candidateName;
    }

    /**
     * Sets the name of the candidate.
     *
     * @param candidateName the new name of the candidate
     */
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    /**
     * Returns the age of the candidate.
     *
     * @return the age of the candidate
     */
    public int getCandidateAge() {
        return candidateAge;
    }

    /**
     * Sets the age of the candidate.
     *
     * @param candidateAge the new age of the candidate
     */
    public void setCandidateAge(int candidateAge) {
        this.candidateAge = candidateAge;
    }

    /**
     * Returns the gender of the candidate.
     *
     * @return the gender of the candidate
     */
    public String getCandidateGender() {
        return candidateGender;
    }

    /**
     * Sets the gender of the candidate.
     *
     * @param candidateGender the new gender of the candidate
     */
    public void setCandidateGender(String candidateGender) {
        this.candidateGender = candidateGender;
    }

    /**
     * Returns the elect status of the candidate.
     *
     * @return the elect status of the candidate
     */
    public int getCandidaateElect() {
        return candidateElect;
    }

    /**
     * Sets the elect status of the candidate.
     *
     * @param candidateElect the new elect status of the candidate
     */
    public void setCandidateElect(int candidateElect) {
        this.candidateElect = candidateElect;
    }

    /**
     * Returns the photo of the candidate.
     *
     * @return the photo of the candidate
     */
    public byte[] getCandidatePhoto() {
        return candidatePhoto;
    }

    /**
     * Sets the photo of the candidate.
     *
     * @param candidatePhoto the new photo of the candidate
     */
    public void setCandidatePhoto(byte[] candidatePhoto) {
        this.candidatePhoto = candidatePhoto;
    }
}