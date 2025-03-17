package org.systemdesign.explore.service;

public interface GenericServices<T, ID> {
    void create(T entity);
    void read(T entity);
    void update(T entity);


}
