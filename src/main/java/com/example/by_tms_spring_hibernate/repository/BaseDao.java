package com.example.by_tms_spring_hibernate.repository;

import java.util.List;

public interface BaseDao<I, E> {
    void save(E e);
    void update(E e);
    void delete(I id);
    E getById(I id);
    List<E> getAll();
}
