package com.coursework.clothesstore.repository;

import com.coursework.clothesstore.models.Product;
import com.coursework.clothesstore.models.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByProductType(ProductType productType);

}
