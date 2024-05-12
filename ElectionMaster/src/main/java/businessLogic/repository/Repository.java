package businessLogic.repository;

import businessLogic.dao.Database;
import businessLogic.model.BaseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface Repository <T extends BaseEntity>{
    boolean insert(T entity);
    boolean update(T entity);
    boolean delete(int id);
    List<T> getAll();
//    void uploadData(List<T> data);

    default void createTableIfNotExists(String createTableSql) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createTableSql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
