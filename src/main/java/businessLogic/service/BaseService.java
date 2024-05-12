package businessLogic.service;

import businessLogic.model.BaseEntity;

import java.util.List;

/**
 * This abstract class defines the basic service operations.
 *
 * @param <T> the type of the entity
 */
public abstract class BaseService<T extends BaseEntity> {

    /**
     * Creates a new entity.
     *
     * @param entity the entity to be created
     * @return true if the entity was created successfully, false otherwise
     */
    public abstract boolean create(T entity);

    /**
     * Inserts a new entity.
     *
     * @param entity the entity to be inserted
     * @return true if the entity was inserted successfully, false otherwise
     */
    public abstract boolean insert(T entity);

    /**
     * Updates an existing entity.
     *
     * @param entity the entity with updated information
     * @return true if the entity was updated successfully, false otherwise
     */
    public abstract boolean update(T entity);

    /**
     * Deletes an entity.
     *
     * @param id the id of the entity to be deleted
     * @return true if the entity was deleted successfully, false otherwise
     */
    public abstract boolean delete(int id);

    /**
     * Retrieves an entity by id.
     *
     * @param id the id of the entity to be retrieved
     * @return the entity with the given id
     */
    public abstract T get(int id);

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    public abstract List<T> getAll();
}