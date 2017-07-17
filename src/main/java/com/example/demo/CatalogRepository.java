package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CatalogRepository extends CrudRepository<Catalog, String> {

}
