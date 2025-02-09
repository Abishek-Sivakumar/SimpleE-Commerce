package com.abishek.SimpleE_commerce.controller;

import com.abishek.SimpleE_commerce.model.Product;
import com.abishek.SimpleE_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String sayHello(){
        return "Hello Abishek";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getALlProducts();
    }


}
