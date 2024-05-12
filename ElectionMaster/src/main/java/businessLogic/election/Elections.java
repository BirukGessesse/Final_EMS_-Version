package businessLogic.election;

import businessLogic.model.BaseEntity;



public class Elections extends BaseEntity {

    private String electionName;
    private String electionDate;
    public Elections(){
        super();
    }
    public Elections(String electionName, String electionDate) {

        this.electionName = electionName;
        this.electionDate = electionDate;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(String electionDate) {
        this.electionDate = electionDate;
    }


}
