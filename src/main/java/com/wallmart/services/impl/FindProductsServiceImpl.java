package com.wallmart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallmart.domain.Products;
import com.wallmart.repository.ProductsRepository;
import com.wallmart.services.FindProductsService;

@Service
public class FindProductsServiceImpl implements FindProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Products> getProductsByDesc(String item, Boolean discount) {
        List<Products> productList = productsRepository.findByBrandContainingOrDescriptionContaining(item);
        if (discount) {
            productList.forEach(product -> {
                product.setPrice((float) Math.round(product.getPrice() * 0.5));
            });
        }
        return productList;
    }

    @Override
    public Products getProductsById(Integer id) {
        return productsRepository.findById(id);
    }

}
