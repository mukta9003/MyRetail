package com.target.myretail.model.dataRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.target.myretail.model.Product;

/**
 * DAO interface extending MongoRepository utilities
 * ProductRepository serves as data access layer for all CRUD operation for no-sql MongodB
 * @author mukta
 *
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
	@Query(value = "{'id': ?0}", fields = "{ 'name' : 1}")
	Product findNameById(long id);

}
