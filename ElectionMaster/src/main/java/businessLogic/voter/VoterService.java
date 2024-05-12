package businessLogic.voter;

import businessLogic.service.BaseService;

import java.util.List;

public class VoterService extends BaseService <Voter> {
    private VoterRepository voterRepository;
        public VoterService(){
                this.voterRepository = new VoterRepository();
        }
    public boolean create(Voter voter) {
            return voterRepository.insert(voter);

    }

    @Override
    public boolean insert(Voter voter) {
       return voterRepository.insert(voter);
    }

    @Override
    public boolean update(Voter entity) {
        return voterRepository.update(entity);
    }

    @Override
    public boolean delete(int id) {
        return voterRepository.delete(id);
    }

    @Override
    public Voter get(int id) {
        return null;
    }

    @Override
    public List<Voter> getAll() {
        return voterRepository.getAll();
    }
}
