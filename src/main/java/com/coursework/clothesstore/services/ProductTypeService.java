package com.coursework.clothesstore.services;

import com.coursework.clothesstore.models.ProductType;
import com.coursework.clothesstore.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

    private ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public Iterable<ProductType> getAll() {
        return productTypeRepository.findAll();
    }
}

