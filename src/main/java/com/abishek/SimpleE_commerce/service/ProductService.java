package com.abishek.SimpleE_commerce.service;

import com.abishek.SimpleE_commerce.model.Product;
import com.abishek.SimpleE_commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getALlProducts(){
        return productRepo.findAll();
    }

    public Product getProduct(int prodId){ //Optional<Product>
        return productRepo.findById(prodId).orElse(null); //Here set all the values inside new Product()
    }

}
