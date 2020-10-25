package com.wallmart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallmart.domain.Products;

@Service
public interface FindProductsService {

    List<Products> getProductsByDesc(String item, Boolean discount);

    Products getProductsById(Integer id);

}
