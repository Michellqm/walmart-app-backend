package com.wallmart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wallmart.domain.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {

    public Products findById(Integer id);

    @Query("{$or :[{brand:{$regex:/?0/}}, {description:{$regex:/?0/}}]}")
    List<Products> findByBrandContainingOrDescriptionContaining(@Param("item") String item);

}
