package businessLogic.voter;

import businessLogic.model.BaseEntity;

public class Voter extends BaseEntity {

    private String voterName;
    private int voterAge;
    private String voterPassword;
    private String voterGender;
    private int voterElection;
    public Voter(){
	super();
    }

    public Voter( String voterName, int voterAge, String voterPassword, String voterGender, int voterElection) {
	super();
	this.voterName = voterName;
	this.voterAge = voterAge;
	this.voterPassword = voterPassword;
	this.voterGender = voterGender;
	this.voterElection = voterElection;
    }
    public String getVoterName() {
	return voterName;
    }

    public void setVoterName(String voterName) {
	this.voterName = voterName;
    }

    public int getVoterAge() {
	return voterAge;
    }

    public void setVoterAge(int voterAge) {
	this.voterAge = voterAge;
    }

    public String getVoterPassword() {
	return voterPassword;
    }

    public void setVoterPassword(String voterPassword) {
	this.voterPassword = voterPassword;
    }

    public String getVoterGender() {
	return voterGender;
    }

    public void setVoterGender(String voterGender) {
	this.voterGender = voterGender;
    }

    public int getVoterElection() {
	return voterElection;
    }

    public void setVoterElection(int voterElection) {
	this.voterElection = voterElection;
    }
}
