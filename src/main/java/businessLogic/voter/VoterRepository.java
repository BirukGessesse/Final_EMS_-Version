package businessLogic.voter;

import businessLogic.dao.Database;
import businessLogic.repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static businessLogic.sql.SqlCommands.*;

/**
 * This class is responsible for handling the database operations for the Voter entity.
 */
public class VoterRepository implements Repository<Voter> {

    /**
     * Default constructor that creates the voter table if it does not exist.
     */
    public VoterRepository() {
        createTableIfNotExists(CREATE_VOTER_TABLE_SQL);
    }

    /**
     * Inserts a new voter into the database.
     *
     * @param voter the voter to be inserted
     * @return true if the insertion was successful, false otherwise
     */
    @Override
    public boolean insert(Voter voter) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VOTER_SQL);
            preparedStatement.setString(1, voter.getVoterName());
            preparedStatement.setInt(2, voter.getVoterAge());
            preparedStatement.setString(3, voter.getVoterPassword());
            preparedStatement.setString(4, voter.getVoterGender());
            preparedStatement.setInt(5, voter.getVoterElection());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates a voter in the database.
     *
     * @param entity the voter to be updated
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean update(Voter entity) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VOTER_SQL);
            preparedStatement.setString(1, entity.getVoterName());
            preparedStatement.setInt(2, entity.getVoterAge());
            preparedStatement.setString(3, entity.getVoterGender());
            preparedStatement.setString(4, entity.getVoterPassword());
            preparedStatement.setInt(5, entity.getVoterElection());
            preparedStatement.setInt(6, entity.getId());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a voter from the database.
     *
     * @param id the id of the voter to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean delete(int id) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VOTER_SQL);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves all voters from the database.
     *
     * @return a list of all voters
     */
    @Override
    public List<Voter> getAll() {
        List<Voter> voters = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VOTER_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Voter voter = new Voter();
                voter.setId(resultSet.getInt("voter_id"));
                voter.setVoterName(resultSet.getString("voter_Name"));
                voter.setVoterAge(resultSet.getInt("voter_Age"));
                voter.setVoterGender(resultSet.getString("voter_Gender"));
                voter.setVoterPassword(resultSet.getString("voter_Password"));
                voter.setVoterElection(resultSet.getInt("voter_Elect"));
                voters.add(voter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voters;
    }
}