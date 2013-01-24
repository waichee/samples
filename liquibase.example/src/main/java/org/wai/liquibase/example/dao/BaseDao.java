package org.wai.liquibase.example.dao;


import java.util.List;

public interface BaseDao<Model> {

	Model save(Model entity);

	List<Model> findAll();

	Model findById(Long id);

}
