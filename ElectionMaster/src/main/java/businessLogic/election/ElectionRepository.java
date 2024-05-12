package businessLogic.election;

import businessLogic.dao.Database;
import businessLogic.repository.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static businessLogic.sql.SqlCommands.*;

public class ElectionRepository implements Repository<Elections> {

    public ElectionRepository(){
        createTableIfNotExists(CREATE_ELECTION_TABLE_SQL);
    }

    @Override
    public boolean insert(Elections election) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ELECTION_SQL)) {
            preparedStatement.setString(1, election.getElectionName());
            preparedStatement.setString(2, election.getElectionDate());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Elections election) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ELECTION_SQL)) {
            preparedStatement.setString(1, election.getElectionName());
            preparedStatement.setString(2, election.getElectionDate());
            preparedStatement.setInt(3, election.getId());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ELECTION_SQL)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Elections> getAll() {
        List<Elections> elections = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ELECTION_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Elections election = new Elections();
                election.setId(resultSet.getInt("election_id"));
                election.setElectionName(resultSet.getString("election_name"));
                election.setElectionDate(resultSet.getString("election_date"));
                elections.add(election);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elections;
    }
    public List<Integer> getAllElectionIds() {
        List<Integer> electionIds = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ELECTION_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                electionIds.add(resultSet.getInt("election_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("these are all the election ids: "+electionIds);
        return electionIds;
    }

}


