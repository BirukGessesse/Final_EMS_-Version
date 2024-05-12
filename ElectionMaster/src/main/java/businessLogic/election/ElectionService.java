package businessLogic.election;
import businessLogic.service.BaseService;

import java.util.List;

public class ElectionService extends BaseService<Elections> {

        private ElectionRepository electionRepository;
        public ElectionService(){
                this.electionRepository = new ElectionRepository();
        }

        @Override
        public boolean create(Elections election){
                return electionRepository.insert(election);
        }
        @Override
        public boolean insert(Elections election){
                return electionRepository.insert(election);
        }
        @Override
        public boolean update(Elections election){
                return electionRepository.update(election);
        }
        @Override
        public boolean delete(int id){
                return electionRepository.delete(id);
        }

    @Override
    public Elections get(int id) {
	return null;
    }

    public boolean create(String name,String date){
            Elections election = new Elections();
            election.setElectionName(name);
            election.setElectionDate(date);
            return create(election);
     }

        public List<Elections> getAll() {
                return electionRepository.getAll();
        }
}
