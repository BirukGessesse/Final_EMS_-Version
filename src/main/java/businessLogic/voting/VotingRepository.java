package businessLogic.voting;

import businessLogic.Winner;
import businessLogic.dao.Database;
import businessLogic.repository.Repository;

import java.sql.*;
import java.util.List;

import static businessLogic.sql.SqlCommands.*;

/**
 * This class is responsible for handling the database operations for the Voting entity.
 */
public class VotingRepository implements Repository<Voting> {

    /**
     * Default constructor that creates the voting table if it does not exist.
     */
    public VotingRepository() {
        createTableIfNotExists(CREATE_VOTING_TABLE_SQL);
    }

    /**
     * Inserts a new voting record into the database.
     *
     * @param voting the voting record to be inserted
     * @return true if the insertion was successful, false otherwise
     */
    @Override
    public boolean insert(Voting voting) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VOTING_SQL)) {
            preparedStatement.setInt(1, voting.getCandidateId());
            preparedStatement.setInt(2, voting.getVoterId());
            preparedStatement.setInt(3, voting.getElectionId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if a vote exists for a given voter and election.
     *
     * @param voterId    the id of the voter
     * @param electionId the id of the election
     * @return true if the vote exists, false otherwise
     */
    public boolean voteExists(int voterId, int electionId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOTING_BY_VOTER_ID_AND_ELECTION_ID_SQL)) {
            preparedStatement.setInt(1, voterId);
            preparedStatement.setInt(2, electionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the winner of a given election.
     *
     * @param electionId the id of the election
     * @return the winner of the election
     */
    public Winner getWinner(int electionId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(winner_sql)) {
            preparedStatement.setInt(1, electionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int candidateId = resultSet.getInt("voting_candidate_id");
                int voteCount = resultSet.getInt("vote_count");

                // Calculate the total votes for the election
                PreparedStatement totalVotesStatement = connection.prepareStatement(totalVotesSql);
                totalVotesStatement.setInt(1, electionId);
                ResultSet totalVotesResultSet = totalVotesStatement.executeQuery();
                totalVotesResultSet.next();
                int totalVotes = totalVotesResultSet.getInt("total_votes");

                // Calculate the vote percentage
                double percentage = (double) voteCount / totalVotes * 100;

                // Fetch the candidate's name and photo from the candidates table
                PreparedStatement candidateStatement = connection.prepareStatement(candidateSql);
                candidateStatement.setInt(1, candidateId);
                ResultSet candidateResultSet = candidateStatement.executeQuery();
                candidateResultSet.next();
                String name = candidateResultSet.getString("candidate_name");
                Blob photoBlob = candidateResultSet.getBlob("candidate_photo");
                // Convert Blob to byte array
                byte[] photo = photoBlob.getBytes(1, (int) photoBlob.length());

                return new Winner(name, photo, percentage, voteCount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Updates a voting record in the database.
     *
     * @param entity the voting record to be updated
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean update(Voting entity) {
        return false;
    }

    /**
     * Deletes a voting record from the database.
     *
     * @param id the id of the voting record to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean delete(int id) {
        return false;
    }

    /**
     * Retrieves all voting records from the database.
     *
     * @return a list of all voting records
     */
    @Override
    public List<Voting> getAll() {
        return null;
    }
}