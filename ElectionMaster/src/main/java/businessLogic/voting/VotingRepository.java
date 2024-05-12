package businessLogic.voting;

import businessLogic.Winner;
import businessLogic.dao.Database;
import businessLogic.repository.Repository;

import java.sql.*;
import java.util.List;

import static businessLogic.sql.SqlCommands.*;

public class VotingRepository implements Repository<Voting> {
    public VotingRepository() {
        createTableIfNotExists(CREATE_VOTING_TABLE_SQL);
    }

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

    @Override
    public boolean update(Voting entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Voting> getAll() {
        return null;
    }

}
