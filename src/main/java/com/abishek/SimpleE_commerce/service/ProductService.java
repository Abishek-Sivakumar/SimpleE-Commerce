package com.abishek.SimpleE_commerce.service;

import com.abishek.SimpleE_commerce.model.Product;
import com.abishek.SimpleE_commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    public Product getProductById(int productId){
        return productRepo.findById(productId).orElse(null);
    }

    public Product updateProduct(int prodId, Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    public String deleteProduct(int productId) {
        productRepo.deleteById(productId);
        return "Product Deleted";
    }
}
