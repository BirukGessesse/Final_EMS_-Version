package businessLogic.repository;

import businessLogic.dao.Database;
import businessLogic.model.BaseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * This interface defines the basic operations for a repository.
 *
 * @param <T> the type of the entity
 */
public interface Repository<T extends BaseEntity> {

    /**
     * Inserts a new entity.
     *
     * @param entity the entity to be inserted
     * @return true if the entity was inserted successfully, false otherwise
     */
    boolean insert(T entity);

    /**
     * Updates an existing entity.
     *
     * @param entity the entity with updated information
     * @return true if the entity was updated successfully, false otherwise
     */
    boolean update(T entity);

    /**
     * Deletes an entity.
     *
     * @param id the id of the entity to be deleted
     * @return true if the entity was deleted successfully, false otherwise
     */
    boolean delete(int id);

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    List<T> getAll();

    // Method to upload data. Currently commented out.
    // void uploadData(List<T> data);

    /**
     * Creates a table in the database if it does not exist.
     *
     * @param createTableSql the SQL command to create the table
     */
    default void createTableIfNotExists(String createTableSql) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createTableSql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}