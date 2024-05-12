package businessLogic.candidate;

import businessLogic.service.BaseService;

import java.util.List;

public class CandidateService extends BaseService<Candidate> {

    private final CandidateRepository candidateRepository;

    public CandidateService() {
	this.candidateRepository = new CandidateRepository();
    }

    @Override
    public boolean create(Candidate candidate) {
	return candidateRepository.insert(candidate);
    }

    @Override
    public boolean insert(Candidate candidate) {
	return candidateRepository.insert(candidate);
    }

    @Override
    public boolean update(Candidate candidate) {
	return candidateRepository.update(candidate);
    }

    @Override
    public boolean delete(int id) {
	return candidateRepository.delete(id);
    }

    @Override
    public Candidate get(int id) {
	return null;
    }

    @Override
    public List<Candidate> getAll(){
	return candidateRepository.getAll();
    }

}
