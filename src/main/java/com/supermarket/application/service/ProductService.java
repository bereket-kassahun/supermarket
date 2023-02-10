package com.supermarket.application.service;

import com.supermarket.application.models.Product;
import com.supermarket.application.models.User;
import com.supermarket.application.ripository.ProductRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    public void saveProduct(Product user) {
        productRepository.save(user);
    }

    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
