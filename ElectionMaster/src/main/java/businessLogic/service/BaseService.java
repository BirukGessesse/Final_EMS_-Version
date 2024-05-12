package businessLogic.service;

import businessLogic.model.BaseEntity;

import java.util.List;

public abstract class BaseService<T extends BaseEntity> {
    public abstract boolean create(T entity);
    public abstract boolean insert(T entity);
    public abstract boolean update(T entity);
    public abstract boolean delete(int id);
    public abstract T get(int id);
    public abstract List<T> getAll();
//    public abstract


}
