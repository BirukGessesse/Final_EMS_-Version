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


public class VoterRepository implements Repository<Voter> {
    public VoterRepository() {
        createTableIfNotExists(CREATE_VOTER_TABLE_SQL);
    }

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