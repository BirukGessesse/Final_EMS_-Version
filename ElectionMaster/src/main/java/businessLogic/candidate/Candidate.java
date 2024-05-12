package businessLogic.candidate;

import businessLogic.model.BaseEntity;

public class Candidate extends BaseEntity {

    private String candidateName;
    private int candidateAge;
    private String candidateGender;
    private int candidateElect;
    private byte[] candidatePhoto;
    public Candidate(){
        super();
    }

    public Candidate(String candidateName, int candidateAge, String candidateGender, int candidateElect, byte[] candidatePhoto) {

        this.candidateName = candidateName;
        this.candidateAge = candidateAge;
        this.candidateGender = candidateGender;
        this.candidateElect = candidateElect;
        this.candidatePhoto = candidatePhoto;
    }



    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getCandidateAge() {
        return candidateAge;
    }

    public void setCandidateAge(int candidateAge) {
        this.candidateAge = candidateAge;
    }

    public String getCandidateGender() {
        return candidateGender;
    }

    public void setCandidateGender(String candidateGender) {
        this.candidateGender = candidateGender;
    }

    public int getCandidateElect() {
        return candidateElect;
    }

    public void setCandidateElect(int candidateElect) {
        this.candidateElect = candidateElect;
    }

    public byte[] getCandidatePhoto() {
        return candidatePhoto;
    }

    public void setCandidatePhoto(byte[] candidatePhoto) {
        this.candidatePhoto = candidatePhoto;
    }
}
