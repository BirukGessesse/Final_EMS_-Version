package businessLogic.model;

/**
 * This class represents a base entity with an id.
 */
public class BaseEntity {
    // The id of the entity
    protected int id;

    /**
     * Retrieves the id of the entity.
     *
     * @return the id of the entity
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id the new id of the entity
     */
    public void setId(int id) {
        this.id = id;
    }
}