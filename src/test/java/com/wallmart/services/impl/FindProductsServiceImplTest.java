package com.wallmart.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.wallmart.domain.Products;
import com.wallmart.repository.ProductsRepository;

@RunWith(MockitoJUnitRunner.class)
public class FindProductsServiceImplTest {

    @InjectMocks
    private FindProductsServiceImpl process;

    @Mock
    ProductsRepository productsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Products product = new Products(1, "some brand", "some desc", "some url", 15454645F);
        List<Products> productList = new ArrayList<>();
        productList.add(product);
        when(productsRepository.findById(Mockito.anyInt())).thenReturn(product);
        when(productsRepository.findByBrandContainingOrDescriptionContaining(Mockito.any())).thenReturn(productList);
    }

    @Test
    public void testGetProductsById() {
        Products product = process.getProductsById(1);
        assertNotNull("Product is not null", product);
    }

    @Test
    public void testGetProductsByDescDiscountTrue() {
        List<Products> productList = process.getProductsByDesc("something", true);
        Float price = (float) Math.round(15454645F * 0.5);
        assertEquals("The discount has been applied", price, productList.get(0).getPrice());
    }

    @Test
    public void testGetProductsByDescDiscountFalse() {
        List<Products> productList = process.getProductsByDesc("something", false);
        Float price = 15454645F;
        assertEquals("The discount has not been applied", price, productList.get(0).getPrice());
    }

}
