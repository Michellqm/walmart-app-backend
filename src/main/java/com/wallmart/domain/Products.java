package com.wallmart.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "products")
public class Products implements Serializable {
    private static final long serialVersionUID = 1645386938830834374L;

    @Id
    private String mongoId;
    private Integer id;
    @TextIndexed
    private String brand;
    @TextIndexed
    private String description;
    private String image;
    private Float price;

    public Products(Integer id, String brand, String description, String image, Float price) {
        super();
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.price = price;
    }
}