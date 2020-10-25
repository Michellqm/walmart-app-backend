package com.wallmart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.domain.Products;
import com.wallmart.exceptions.WallmartProductsException;
import com.wallmart.services.FindProductsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class ProductsController {

    @Autowired
    FindProductsService findProductsService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts(@RequestParam(value = "item", required = true) String item,
            @RequestParam(value = "discount", required = true) Boolean discount) {
        try {
            return new ResponseEntity<>(findProductsService.getProductsByDesc(item, discount), HttpStatus.OK);
        } catch (WallmartProductsException e) {
            log.error("generateMasterReportScheduler - MasterReportException" + e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<Products> getProducts(@RequestParam(value = "id", required = true) Integer id) {
        try {
            return new ResponseEntity<>(findProductsService.getProductsById(id), HttpStatus.OK);
        } catch (WallmartProductsException e) {
            log.error("generateMasterReportScheduler - MasterReportException" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
