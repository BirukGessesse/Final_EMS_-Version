package businessLogic.candidate;

import java.sql.SQLException;
import java.util.List;

public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController() {
	this.candidateService = new CandidateService();
    }

    public boolean createCandidate(Candidate candidate) {
	return candidateService.create(candidate);
    }

    public boolean updateCandidate(Candidate candidate) {
	return candidateService.update(candidate);
    }

    public boolean deleteCandidate(int id) {
	return candidateService.delete(id);
    }

    public Candidate getCandidate(int id) {
	return candidateService.get(id);
    }

    public List<Candidate> getAllCandidates() {
	return candidateService.getAll();
    }

    public boolean addCandidate(String name, int age, int candidateElect, byte[] photo, String gender) throws SQLException {
	Candidate candidate = new Candidate(name, age, gender, candidateElect, photo);
	return candidateService.create(candidate);
    }
    public Candidate getCandidateById(int id){
	return candidateService.get(id);
    }
    public boolean updateCandidate(int id, String name, int age, int candidateElect, byte[] photo, String gender) throws SQLException {
	Candidate candidate = new Candidate(name,age,gender,candidateElect,photo);
	candidate.setId(id);
	return candidateService.update(candidate);
    }
}
