package businessLogic.candidate;

import businessLogic.dao.Database;
import businessLogic.repository.Repository;

import static businessLogic.sql.SqlCommands.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for managing the database operations related to Candidates.
 */
public class CandidateRepository implements Repository<Candidate> {

    /**
     * Default constructor that ensures the candidate table exists in the database.
     */
    public CandidateRepository() {
        createTableIfNotExists(CREATE_CANDIDATE_TABLE_SQL);
    }

    /**
     * Inserts a new Candidate into the database.
     *
     * @param candidate the candidate to be inserted
     * @return true if the candidate was inserted successfully, false otherwise
     */
    @Override
    public boolean insert(Candidate candidate) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CANDIDATE_SQL)) {
            preparedStatement.setString(1, candidate.getCandidateName());
            preparedStatement.setInt(2, candidate.getCandidateAge());
            preparedStatement.setString(3, candidate.getCandidateGender());
            preparedStatement.setInt(4, candidate.getCandidaateElect());
            preparedStatement.setBytes(5, candidate.getCandidatePhoto());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an existing Candidate in the database.
     *
     * @param candidate the candidate with updated information
     * @return true if the candidate was updated successfully, false otherwise
     */
    @Override
    public boolean update(Candidate candidate) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CANDIDATE_SQL)) {
            preparedStatement.setString(1, candidate.getCandidateName());
            preparedStatement.setInt(2, candidate.getCandidateAge());
            preparedStatement.setString(3, candidate.getCandidateGender());
            preparedStatement.setInt(4, candidate.getCandidaateElect());
            preparedStatement.setBytes(5, candidate.getCandidatePhoto());
            preparedStatement.setInt(6, candidate.getId());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a Candidate from the database.
     *
     * @param id the id of the candidate to be deleted
     * @return true if the candidate was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CANDIDATE_SQL)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all Candidates from the database.
     *
     * @return a list of all candidates
     */
    @Override
    public List<Candidate> getAll() {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CANDIDATE_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Candidate candidate = new Candidate();
                candidate.setId(resultSet.getInt("candidate_id"));
                candidate.setCandidateName(resultSet.getString("candidate_name"));
                candidate.setCandidateAge(resultSet.getInt("candidate_age"));
                candidate.setCandidateElect(resultSet.getInt("candidate_elect"));
                candidate.setCandidateGender(resultSet.getString("candidate_gender"));
                candidate.setCandidatePhoto(resultSet.getBytes("candidate_photo"));
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return candidates;
    }
}