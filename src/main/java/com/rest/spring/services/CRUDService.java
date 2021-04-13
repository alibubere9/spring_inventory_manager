package com.rest.spring.services;

import com.rest.spring.models.Company;

import java.util.List;

public interface CRUDService<T> {
    // Create
    public int addNew(T entity);

    // Retrieve
    public List<T> getAll();
    public T getById(int id);

    // Update
    public T update(T entity);

    // Delete
    public int delete(int id);

}
